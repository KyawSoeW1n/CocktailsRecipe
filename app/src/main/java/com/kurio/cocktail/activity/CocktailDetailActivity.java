package com.kurio.cocktail.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
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

import javax.inject.Inject;

import dagger.android.AndroidInjection;


public class CocktailDetailActivity extends BaseActivity implements ClickIngredientItem {
    @Inject
    ViewModelFactory viewModelFactory;
    ArrayList<String> ingredientList;
    CocktailDetailViewModel cocktailDetailViewModel;
    DrinkIngredientListAdapter drinkIngredientListAdapter;
    RecyclerView rcIngredient;
    ImageView imgCocktail;
    TextView tvAlcoholic, tvDrinkTag, tvDrinkCategory, tvToolbarTitle, tvInstruction;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        cocktailDetailViewModel = ViewModelProviders.of(this, viewModelFactory).get(CocktailDetailViewModel.class);
        cocktailDetailViewModel.getDrinkDetail(getIntent().getStringExtra(Constants.EXTRA_ID));
        cocktailDetailViewModel.getDrinkDetailLiveData().observe(this, this::getDrinkDetail);
    }

    @Override
    protected void initComponent() {
        rcIngredient = findViewById(R.id.rc_ingredient);
        imgCocktail = findViewById(R.id.img_cocktail);
        tvAlcoholic = findViewById(R.id.tv_alcoholic);
        tvDrinkTag = findViewById(R.id.tv_tags);
        tvDrinkCategory = findViewById(R.id.tv_str_Category);
        tvToolbarTitle = findViewById(R.id.tv_toolbar_title);
        tvInstruction = findViewById(R.id.tv_instruction);
        toolbar = findViewById(R.id.toolbar_cocktail_detail);
        drinkIngredientListAdapter = new DrinkIngredientListAdapter(this, this);
        rcIngredient.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcIngredient.setAdapter(drinkIngredientListAdapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_cocktail_detail;
    }

    @Override
    protected Toolbar getToolbar() {
        return toolbar;
    }

    private void getDrinkDetail(Resource<CocktailDetail> resource) {
        if (resource.state == ResourceState.ERROR) {
            Log.i("ERROR", "error \t" + resource.errorMessage);
        } else if (resource.state == ResourceState.SUCCESS) {
            Log.i("Detail SUCCESS", "Success");
            if (resource.data != null) {
                bindData(resource.data);
            }
        } else if (resource.state == ResourceState.LOADING) {
            Log.i("Currency Loading", "Loading");
        }
    }

    private void bindData(CocktailDetail cocktailDetail) {
        Glide.with(this)
                .load(cocktailDetail.getStrDrinkThumb())
                .into(imgCocktail);


        if (cocktailDetail.getStrTag() != null && !cocktailDetail.getStrTag().isEmpty()) {
            tvDrinkTag.setText(cocktailDetail.getStrTag());
        } else {
            tvDrinkTag.setVisibility(View.GONE);
        }
        tvToolbarTitle.setText(cocktailDetail.getStrDrink());
        tvAlcoholic.setText(cocktailDetail.getStrAlcoholic());

        tvDrinkCategory.setText(cocktailDetail.getStrCategory());
        tvInstruction.setText(cocktailDetail.getStrInstructions());
        addIngredient(cocktailDetail);
    }

    private void addIngredient(CocktailDetail cocktailDetail) {

        if (ingredientList == null) {
            ingredientList = new ArrayList<>();
        } else {
            ingredientList.clear();
        }

        if (cocktailDetail.getStrIngredient1() != null && !cocktailDetail.getStrIngredient1().isEmpty()) {
            ingredientList.add(cocktailDetail.getStrIngredient1());
        }
        if (cocktailDetail.getStrIngredient2() != null && !cocktailDetail.getStrIngredient2().isEmpty()) {
            ingredientList.add(cocktailDetail.getStrIngredient2());
        }
        if (cocktailDetail.getStrIngredient3() != null && !cocktailDetail.getStrIngredient3().isEmpty()) {
            ingredientList.add(cocktailDetail.getStrIngredient3());
        }
        if (cocktailDetail.getStrIngredient4() != null && !cocktailDetail.getStrIngredient4().isEmpty()) {
            ingredientList.add(cocktailDetail.getStrIngredient4());
        }
        if (cocktailDetail.getStrIngredient5() != null && !cocktailDetail.getStrIngredient5().isEmpty()) {
            ingredientList.add(cocktailDetail.getStrIngredient5());
        }
        if (cocktailDetail.getStrIngredient6() != null && !cocktailDetail.getStrIngredient6().isEmpty()) {
            ingredientList.add(cocktailDetail.getStrIngredient6());
        }
        if (cocktailDetail.getStrIngredient7() != null && !cocktailDetail.getStrIngredient7().isEmpty()) {
            ingredientList.add(cocktailDetail.getStrIngredient7());
        }
        if (cocktailDetail.getStrIngredient8() != null && !cocktailDetail.getStrIngredient8().isEmpty()) {
            ingredientList.add(cocktailDetail.getStrIngredient8());
        }
        if (cocktailDetail.getStrIngredient9() != null && !cocktailDetail.getStrIngredient9().isEmpty()) {
            ingredientList.add(cocktailDetail.getStrIngredient9());
        }
        if (cocktailDetail.getStrIngredient10() != null && !cocktailDetail.getStrIngredient10().isEmpty()) {
            ingredientList.add(cocktailDetail.getStrIngredient10());
        }
        if (cocktailDetail.getStrIngredient11() != null && !cocktailDetail.getStrIngredient11().isEmpty()) {
            ingredientList.add(cocktailDetail.getStrIngredient11());
        }
        if (cocktailDetail.getStrIngredient12() != null && !cocktailDetail.getStrIngredient12().isEmpty()) {
            ingredientList.add(cocktailDetail.getStrIngredient12());
        }
        if (cocktailDetail.getStrIngredient13() != null && !cocktailDetail.getStrIngredient13().isEmpty()) {
            ingredientList.add(cocktailDetail.getStrIngredient13());
        }
        if (cocktailDetail.getStrIngredient14() != null && !cocktailDetail.getStrIngredient14().isEmpty()) {
            ingredientList.add(cocktailDetail.getStrIngredient14());
        }
        if (cocktailDetail.getStrIngredient15() != null && !cocktailDetail.getStrIngredient15().isEmpty()) {
            ingredientList.add(cocktailDetail.getStrIngredient15());
        }
        drinkIngredientListAdapter.addNewData(ingredientList);
    }

    @Override
    public void clickIngredientItem(String ingredientName) {
        startActivity(new Intent(CocktailDetailActivity.this, IngredientDetailActivity.class)
                .putExtra(Constants.EXTRA_NAME, ingredientName));
    }
}
