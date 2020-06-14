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
import java.util.List;

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

    private void getDrinkDetail(Resource<List<CocktailDetail>> resource) {
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

    private void bindData(List<CocktailDetail> cocktailDetail) {
        Glide.with(this)
                .load(cocktailDetail.get(0).getStrDrinkThumb())
                .into(imgCocktail);


        if (cocktailDetail.get(0).getStrTag() != null && !cocktailDetail.get(0).getStrTag().isEmpty()) {
            tvDrinkTag.setText(cocktailDetail.get(0).getStrTag());
        } else {
            tvDrinkTag.setVisibility(View.GONE);
        }
        tvToolbarTitle.setText(cocktailDetail.get(0).getStrDrink());
        tvAlcoholic.setText(cocktailDetail.get(0).getStrAlcoholic());

        tvDrinkCategory.setText(cocktailDetail.get(0).getStrCategory());
        tvInstruction.setText(cocktailDetail.get(0).getStrInstructions());
        addIngredient(cocktailDetail);
    }

    private void addIngredient(List<CocktailDetail> cocktailDetail) {

        if (ingredientList == null) {
            ingredientList = new ArrayList<>();
        } else {
            ingredientList.clear();
        }

        if (cocktailDetail.get(0).getStrIngredient1() != null && !cocktailDetail.get(0).getStrIngredient1().isEmpty()) {
            ingredientList.add(cocktailDetail.get(0).getStrIngredient1());
        }
        if (cocktailDetail.get(0).getStrIngredient2() != null && !cocktailDetail.get(0).getStrIngredient2().isEmpty()) {
            ingredientList.add(cocktailDetail.get(0).getStrIngredient2());
        }
        if (cocktailDetail.get(0).getStrIngredient3() != null && !cocktailDetail.get(0).getStrIngredient3().isEmpty()) {
            ingredientList.add(cocktailDetail.get(0).getStrIngredient3());
        }
        if (cocktailDetail.get(0).getStrIngredient4() != null && !cocktailDetail.get(0).getStrIngredient4().isEmpty()) {
            ingredientList.add(cocktailDetail.get(0).getStrIngredient4());
        }
        if (cocktailDetail.get(0).getStrIngredient5() != null && !cocktailDetail.get(0).getStrIngredient5().isEmpty()) {
            ingredientList.add(cocktailDetail.get(0).getStrIngredient5());
        }
        if (cocktailDetail.get(0).getStrIngredient6() != null && !cocktailDetail.get(0).getStrIngredient6().isEmpty()) {
            ingredientList.add(cocktailDetail.get(0).getStrIngredient6());
        }
        if (cocktailDetail.get(0).getStrIngredient7() != null && !cocktailDetail.get(0).getStrIngredient7().isEmpty()) {
            ingredientList.add(cocktailDetail.get(0).getStrIngredient7());
        }
        if (cocktailDetail.get(0).getStrIngredient8() != null && !cocktailDetail.get(0).getStrIngredient8().isEmpty()) {
            ingredientList.add(cocktailDetail.get(0).getStrIngredient8());
        }
        if (cocktailDetail.get(0).getStrIngredient9() != null && !cocktailDetail.get(0).getStrIngredient9().isEmpty()) {
            ingredientList.add(cocktailDetail.get(0).getStrIngredient9());
        }
        if (cocktailDetail.get(0).getStrIngredient10() != null && !cocktailDetail.get(0).getStrIngredient10().isEmpty()) {
            ingredientList.add(cocktailDetail.get(0).getStrIngredient10());
        }
        if (cocktailDetail.get(0).getStrIngredient11() != null && !cocktailDetail.get(0).getStrIngredient11().isEmpty()) {
            ingredientList.add(cocktailDetail.get(0).getStrIngredient11());
        }
        if (cocktailDetail.get(0).getStrIngredient12() != null && !cocktailDetail.get(0).getStrIngredient12().isEmpty()) {
            ingredientList.add(cocktailDetail.get(0).getStrIngredient12());
        }
        if (cocktailDetail.get(0).getStrIngredient13() != null && !cocktailDetail.get(0).getStrIngredient13().isEmpty()) {
            ingredientList.add(cocktailDetail.get(0).getStrIngredient13());
        }
        if (cocktailDetail.get(0).getStrIngredient14() != null && !cocktailDetail.get(0).getStrIngredient14().isEmpty()) {
            ingredientList.add(cocktailDetail.get(0).getStrIngredient14());
        }
        if (cocktailDetail.get(0).getStrIngredient15() != null && !cocktailDetail.get(0).getStrIngredient15().isEmpty()) {
            ingredientList.add(cocktailDetail.get(0).getStrIngredient15());
        }
        drinkIngredientListAdapter.addNewData(ingredientList);
    }

    @Override
    public void clickIngredientItem(String ingredientName) {
        startActivity(new Intent(CocktailDetailActivity.this, IngredientDetailActivity.class)
                .putExtra(Constants.EXTRA_NAME, ingredientName));
    }
}
