package com.kurio.cocktail.main;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kurio.cocktail.Constants;
import com.kurio.cocktail.R;
import com.kurio.cocktail.adapters.DrinkIngredientListAdapter;
import com.kurio.cocktail.callback.ClickIngredientItem;
import com.kurio.cocktail.data.presentation.CocktailDetailViewModel;
import com.kurio.cocktail.data.presentation.state.Resource;
import com.kurio.cocktail.data.presentation.state.ResourceState;
import com.kurio.cocktail.domain.model.CocktailDetail;
import com.kurio.cocktail.injection.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;


public class CocktailDetailActivity extends AppCompatActivity implements ClickIngredientItem {
    @Inject
    ViewModelFactory viewModelFactory;
    ArrayList<String> ingredientList;
    CocktailDetailViewModel cocktailDetailViewModel;
    DrinkIngredientListAdapter drinkIngredientListAdapter;
    RecyclerView rcIngredient;
    ImageView imgCocktail;
    TextView tvAlcoholic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail_detail);
        AndroidInjection.inject(this);
        rcIngredient = findViewById(R.id.rc_ingredient);
        imgCocktail = findViewById(R.id.img_cocktail);
        tvAlcoholic = findViewById(R.id.tv_alcoholic);
        drinkIngredientListAdapter = new DrinkIngredientListAdapter(this, this);
        rcIngredient.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcIngredient.setAdapter(drinkIngredientListAdapter);
        cocktailDetailViewModel = ViewModelProviders.of(this, viewModelFactory).get(CocktailDetailViewModel.class);
        cocktailDetailViewModel.getDrinkDetail(getIntent().getStringExtra(Constants.EXTRA_ID));
        cocktailDetailViewModel.getDrinkDetailLiveData().observe(this, this::getDrinkDetail);
    }

    private void getDrinkDetail(Resource<List<CocktailDetail>> resource) {
        if (resource.state == ResourceState.ERROR) {
            Log.i("ERROR", "error \t" + resource.errorMessage);
        } else if (resource.state == ResourceState.SUCCESS) {
            Log.i("SUCCESS", "Success");
            if (resource.data != null) {
                bindData(resource.data);
            }
        } else if (resource.state == ResourceState.LOADING) {
            Log.i("Currency Loading", "Loading");
        }
    }

    private void bindData(List<CocktailDetail> data) {
        Glide.with(this)
                .load(data.get(0).getStrDrinkThumb())
                .into(imgCocktail);
    }

    @Override
    public void clickIngredientItem(CocktailDetail cocktailDetail) {
        Toast.makeText(this, cocktailDetail.getStrInstructions(), Toast.LENGTH_SHORT).show();
    }
}
