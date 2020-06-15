package com.kurio.cocktail.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kurio.cocktail.CocktailApplication;
import com.kurio.cocktail.Constants;
import com.kurio.cocktail.R;
import com.kurio.cocktail.activity.DrinkDetailActivity;
import com.kurio.cocktail.adapters.DrinkListAdapter;
import com.kurio.cocktail.callback.ClickDrinkItem;
import com.kurio.cocktail.data.presentation.CocktailViewModel;
import com.kurio.cocktail.data.presentation.state.Resource;
import com.kurio.cocktail.data.presentation.state.ResourceState;
import com.kurio.cocktail.domain.model.Drink;
import com.kurio.cocktail.injection.ViewModelFactory;

import java.util.List;

import javax.inject.Inject;

public class FragmentDashboard extends Fragment implements ClickDrinkItem {
    View v;
    @Inject
    ViewModelFactory viewModelFactory;
    CocktailViewModel cocktailViewModel;

    private DrinkListAdapter drinkListAdapter;
    Spinner drinkTypeSpinner;
    RecyclerView recyclerDrink;
    RecyclerView.LayoutManager layoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity() != null)
            ((CocktailApplication) getActivity().getApplication()).supportFragmentInjector().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_dashboard, container, false);
        drinkTypeSpinner = v.findViewById(R.id.drink_types_spinner);
        recyclerDrink = v.findViewById(R.id.recycler_drink);
        cocktailViewModel = ViewModelProviders.of(this, viewModelFactory).get(CocktailViewModel.class);
        drinkListAdapter = new DrinkListAdapter(getContext(), this);
        setUpRecyclerAdapter();
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.drinkList));
        drinkTypeSpinner.setAdapter(arrayAdapter);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cocktailViewModel.getDrinkListLiveData().observe(getViewLifecycleOwner(), this::getDrinkList);
        return v;
    }

    private void setUpRecyclerAdapter() {
        layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerDrink.setLayoutManager(layoutManager);
        recyclerDrink.setAdapter(drinkListAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initListener();
    }

    private void initListener() {
        drinkTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                drinkListAdapter.clearData();
                if (position == 1) {
                    cocktailViewModel.fetchDrink("Non_Alcoholic");
                } else {
                    cocktailViewModel.fetchDrink("Alcoholic");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void getDrinkList(Resource<List<Drink>> resource) {
        if (resource.state == ResourceState.ERROR) {
            Log.i("ERROR", "error \t" + resource.errorMessage);
        } else if (resource.state == ResourceState.SUCCESS) {
            Log.i("SUCCESS", "Success");
            if (resource.data != null) {
                drinkListAdapter.addNewData(resource.data);
            }
        } else if (resource.state == ResourceState.LOADING) {
            Log.i("Drink Loading", "Loading");
        }
    }

    @Override
    public void clickCocktailItem(Drink drink) {
        startActivity(new Intent(getContext(), DrinkDetailActivity.class)
                .putExtra(Constants.EXTRA_ID, drink.getDrinkId()));
    }
}
