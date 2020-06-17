package com.kurio.cocktail.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kurio.cocktail.CocktailApplication;
import com.kurio.cocktail.Constants;
import com.kurio.cocktail.R;
import com.kurio.cocktail.activity.DrinkDetailActivity;
import com.kurio.cocktail.adapters.FavouriteDrinkListAdapter;
import com.kurio.cocktail.callback.ClickFavouriteDrinkItem;
import com.kurio.cocktail.component.CommonViewUtils;
import com.kurio.cocktail.data.presentation.FavouriteDrinkViewModel;
import com.kurio.cocktail.data.presentation.state.Resource;
import com.kurio.cocktail.data.presentation.state.ResourceState;
import com.kurio.cocktail.domain.model.CacheDrink;
import com.kurio.cocktail.injection.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class FragmentFavouriteDrink extends Fragment implements ClickFavouriteDrinkItem, View.OnClickListener {
    @Inject
    ViewModelFactory viewModelFactory;
    private FavouriteDrinkViewModel favouriteDrinkViewModel;
    private View v;
    private RecyclerView recyclerView;
    private FavouriteDrinkListAdapter favouriteDrinkListAdapter;
    private List<CacheDrink> cacheDrinks = new ArrayList<>();
    private TextView tvDeleteAll;

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
        tvDeleteAll = v.findViewById(R.id.tv_delete_all);
        setUpRecyclerView();
        favouriteDrinkViewModel.getFavouriteDrinkLiveData().observe(getViewLifecycleOwner(), this::getFavouriteDrinkList);
        return v;
    }

    private void setUpRecyclerView() {
        favouriteDrinkListAdapter = new FavouriteDrinkListAdapter(getContext(), this);
        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(favouriteDrinkListAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        favouriteDrinkViewModel.getFavouriteDrink();
        tvDeleteAll.setOnClickListener(this);
        setUpRecyclerHelper();
    }

    private void getFavouriteDrinkList(Resource<List<CacheDrink>> resource) {
        if (resource.state == ResourceState.ERROR) {
            Log.i("ERROR", "error \t" + resource.errorMessage);
        } else if (resource.state == ResourceState.SUCCESS) {
            Log.i("SUCCESS", "Success");
            if (resource.data != null) {
                if (resource.data.isEmpty()) {
                    tvDeleteAll.setVisibility(View.GONE);
                } else {
                    cacheDrinks.clear();
                    cacheDrinks.addAll(resource.data);
                    favouriteDrinkListAdapter.addNewData(cacheDrinks);
                }
            } else {
                tvDeleteAll.setVisibility(View.GONE);
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

    private void setUpRecyclerHelper() {
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                CacheDrink cacheDrink = cacheDrinks.get(viewHolder.getAdapterPosition());
                favouriteDrinkListAdapter.removeSingleData(cacheDrink);
                favouriteDrinkViewModel.deleteDrink(cacheDrink.getDrinkId());
            }
        }).attachToRecyclerView(recyclerView);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_delete_all) {
            CommonViewUtils.showAlertDialog(getActivity(), getString(R.string.do_you_want_to_delete_all_favourite_drink), getString(R.string.yes), getString(R.string.no), event -> {
                if (event == Constants.EVENT_CONFIRM) {
                    favouriteDrinkViewModel.deleteAllDrink();
                    favouriteDrinkListAdapter.clearData();
                }
            });
        }
    }
}
