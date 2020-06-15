package com.kurio.cocktail.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kurio.cocktail.CocktailApplication;
import com.kurio.cocktail.Constants;
import com.kurio.cocktail.R;
import com.kurio.cocktail.activity.DrinkDetailActivity;
import com.kurio.cocktail.adapters.FavouriteDrinkListAdapter;
import com.kurio.cocktail.callback.ClickFavouriteDrinkItem;
import com.kurio.cocktail.data.presentation.FavouriteDrinkViewModel;
import com.kurio.cocktail.data.presentation.state.Resource;
import com.kurio.cocktail.data.presentation.state.ResourceState;
import com.kurio.cocktail.domain.model.CacheDrink;
import com.kurio.cocktail.injection.ViewModelFactory;

import java.util.List;

import javax.inject.Inject;

public class FragmentDrink extends Fragment implements ClickFavouriteDrinkItem {
    @Inject
    ViewModelFactory viewModelFactory;
    FavouriteDrinkViewModel favouriteDrinkViewModel;
    View v;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FavouriteDrinkListAdapter favouriteDrinkListAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity() != null)
            ((CocktailApplication) getActivity().getApplication()).supportFragmentInjector().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_drink, container, false);
        favouriteDrinkViewModel = ViewModelProviders.of(this, viewModelFactory).get(FavouriteDrinkViewModel.class);
        favouriteDrinkListAdapter = new FavouriteDrinkListAdapter(getContext(), this);
        layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(favouriteDrinkListAdapter);
        favouriteDrinkViewModel.getFavouriteDrinkLiveData().observe(getViewLifecycleOwner(), this::getFavouriteDrinkList);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getRoute();
    }


    private void getRoute() {
        Log.e("GGWP", "GG" + FragmentDrinkArgs.fromBundle(getArguments()));
        favouriteDrinkViewModel.getFavouriteDrink();
    }


    private void getFavouriteDrinkList(Resource<List<CacheDrink>> resource) {
        if (resource.state == ResourceState.ERROR) {
            Log.i("ERROR", "error \t" + resource.errorMessage);
        } else if (resource.state == ResourceState.SUCCESS) {
            Log.i("SUCCESS", "Success");
            if (resource.data != null) {
                favouriteDrinkListAdapter.addNewData(resource.data);
            }
        } else if (resource.state == ResourceState.LOADING) {
            Log.i("Drink Loading", "Loading");
        }
    }

    @Override
    public void clickDrinkItem(CacheDrink cacheDrink) {
        startActivity(new Intent(getContext(), DrinkDetailActivity.class)
                .putExtra(Constants.EXTRA_ID, cacheDrink.getDrinkId()));
    }
}
