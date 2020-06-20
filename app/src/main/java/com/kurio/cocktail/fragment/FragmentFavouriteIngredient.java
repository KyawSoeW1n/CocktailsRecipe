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
import com.kurio.cocktail.activity.IngredientDetailActivity;
import com.kurio.cocktail.adapters.FavouriteIngredientListAdapter;
import com.kurio.cocktail.callback.ClickFavouriteIngredientItem;
import com.kurio.cocktail.component.CommonViewUtils;
import com.kurio.cocktail.data.presentation.FavouriteIngredientViewModel;
import com.kurio.cocktail.data.presentation.state.Resource;
import com.kurio.cocktail.data.presentation.state.ResourceState;
import com.kurio.cocktail.domain.model.CacheIngredient;
import com.kurio.cocktail.injection.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class FragmentFavouriteIngredient extends Fragment implements ClickFavouriteIngredientItem, View.OnClickListener {
    private View v;
    private TextView tvDeleteAll;
    @Inject
    ViewModelFactory viewModelFactory;
    private FavouriteIngredientViewModel favouriteIngredientViewModel;
    private FavouriteIngredientListAdapter favouriteIngredientListAdapter;
    private RecyclerView recyclerView;
    private List<CacheIngredient> cacheIngredients = new ArrayList<>();

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
        favouriteIngredientViewModel = ViewModelProviders.of(this, viewModelFactory).get(FavouriteIngredientViewModel.class);
        tvDeleteAll = v.findViewById(R.id.tv_delete_all);
        setUpRecyclerView();
        favouriteIngredientViewModel.getFavouriteIngredientLiveData().observe(getViewLifecycleOwner(), this::getFavouriteIngredientList);
        return v;
    }

    private void setUpRecyclerView() {
        favouriteIngredientListAdapter = new FavouriteIngredientListAdapter(getContext(), this);
        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(favouriteIngredientListAdapter);
    }

    private void getFavouriteIngredientList(Resource<List<CacheIngredient>> resource) {
        if (resource.state == ResourceState.ERROR) {
            Log.i("ERROR", "error \t" + resource.errorMessage);
        } else if (resource.state == ResourceState.SUCCESS) {
            Log.i("SUCCESS", "Success");
            if (resource.data != null) {
                if (resource.data.isEmpty()){
                    tvDeleteAll.setVisibility(View.GONE);
                }else{
                    cacheIngredients.clear();
                    cacheIngredients.addAll(resource.data);
                    favouriteIngredientListAdapter.addNewData(cacheIngredients);
                }
            } else {
                tvDeleteAll.setVisibility(View.GONE);
            }
        } else if (resource.state == ResourceState.LOADING) {
            Log.i("Drink Loading", "Loading");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        favouriteIngredientViewModel.getFavouriteIngredient();
        tvDeleteAll.setOnClickListener(this);
        setUpRecyclerHelper();
    }

    @Override
    public void clickIngredientItem(CacheIngredient cacheIngredient) {
        startActivity(new Intent(getContext(), IngredientDetailActivity.class)
                .putExtra(Constants.EXTRA_NAME, cacheIngredient.getStrIngredient()));
    }

    private void setUpRecyclerHelper() {
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                CacheIngredient cacheIngredient = cacheIngredients.get(viewHolder.getAdapterPosition());
                favouriteIngredientListAdapter.removeSingleData(cacheIngredient);
                favouriteIngredientViewModel.deleteIngredient(cacheIngredient.getIdIngredient());

            }
        }).attachToRecyclerView(recyclerView);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_delete_all) {
            CommonViewUtils.showAlertDialog(getActivity(), getString(R.string.do_you_want_to_delete_all_favourite_drink), getString(R.string.yes), getString(R.string.no), event -> {
                if (event == Constants.EVENT_CONFIRM) {
                    favouriteIngredientViewModel.deleteAllIngredient();
                    favouriteIngredientListAdapter.clearData();
                }
            });
        }
    }
}
