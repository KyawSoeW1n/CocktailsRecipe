package com.kurio.cocktail.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kurio.cocktail.Constants;
import com.kurio.cocktail.R;
import com.kurio.cocktail.adapters.DrinkListAdapter;
import com.kurio.cocktail.callback.ClickDrinkItem;
import com.kurio.cocktail.data.presentation.CocktailViewModel;
import com.kurio.cocktail.data.presentation.state.Resource;
import com.kurio.cocktail.data.presentation.state.ResourceState;
import com.kurio.cocktail.domain.model.Drink;
import com.kurio.cocktail.injection.ViewModelFactory;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements ClickDrinkItem {
    @Inject
    ViewModelFactory viewModelFactory;
    DrinkListAdapter drinkListAdapter;
    CocktailViewModel cocktailViewModel;
    RecyclerView recycler_view_rates;
    RecyclerView.LayoutManager layoutManager;
    String[] cocktailType = {"Non Alcoholic", "Alcoholic"};
    Spinner cocktailTypeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidInjection.inject(this);
        cocktailViewModel = ViewModelProviders.of(this, viewModelFactory).get(CocktailViewModel.class);
        recycler_view_rates = findViewById(R.id.recycler_view_rates);
        cocktailTypeSpinner = findViewById(R.id.cocktail_types_spinner);
//        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        layoutManager = new GridLayoutManager(this, 2);
        drinkListAdapter = new DrinkListAdapter(this, this);
        recycler_view_rates.setAdapter(drinkListAdapter);
        initListener();
        recycler_view_rates.setLayoutManager(layoutManager);
        cocktailTypeSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cocktailType));
        cocktailViewModel.getDrinkListLiveData().observe(this, this::getDrinkList);
    }

    private void initListener() {
        cocktailTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        startActivity(new Intent(this, DrinkDetailActivity.class)
                .putExtra(Constants.EXTRA_ID, drink.getDrinkId()));
    }
}
