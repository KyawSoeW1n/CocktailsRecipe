package com.kurio.cocktail.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
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
import com.kurio.cocktail.component.CommonViewUtils;
import com.kurio.cocktail.data.presentation.DrinkDetailViewModel;
import com.kurio.cocktail.data.presentation.state.Resource;
import com.kurio.cocktail.data.presentation.state.ResourceState;
import com.kurio.cocktail.domain.model.CacheDrink;
import com.kurio.cocktail.domain.model.DrinkDetail;
import com.kurio.cocktail.injection.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;


public class DrinkDetailActivity extends BaseActivity implements ClickIngredientItem, View.OnClickListener {
    @Inject
    ViewModelFactory viewModelFactory;
    ArrayList<String> ingredientList;
    DrinkDetailViewModel drinkDetailViewModel;
    DrinkIngredientListAdapter drinkIngredientListAdapter;
    RecyclerView rcIngredient;
    ImageView imgCocktail;
    TextView tvAlcoholic, tvDrinkTag, tvDrinkCategory, tvToolbarTitle, tvInstruction;
    Toolbar toolbar;
    ImageButton imbFavourite;
    List<DrinkDetail> drinkDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        drinkDetailViewModel = ViewModelProviders.of(this, viewModelFactory).get(DrinkDetailViewModel.class);
        drinkDetailViewModel.getCacheDrink(getIntent().getStringExtra(Constants.EXTRA_ID));
        drinkDetailViewModel.fetchDrinkDetail(getIntent().getStringExtra(Constants.EXTRA_ID));
        drinkDetailViewModel.getDrinkDetailLiveData().observe(this, this::getDrinkDetail);
        drinkDetailViewModel.getCacheDrinkLiveData().observe(this, this::cacheDrinkDetail);
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
        imbFavourite = findViewById(R.id.imb_favourite);
        drinkIngredientListAdapter = new DrinkIngredientListAdapter(this, this);
        rcIngredient.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcIngredient.setAdapter(drinkIngredientListAdapter);
        imbFavourite.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_drink_detail;
    }

    @Override
    protected Toolbar getToolbar() {
        return toolbar;
    }

    private void getDrinkDetail(Resource<List<DrinkDetail>> resource) {
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

    private void cacheDrinkDetail(Resource<CacheDrink> resource) {
        if (resource.state == ResourceState.ERROR) {
            Log.i("ERROR", "error \t" + resource.errorMessage);
            CommonViewUtils.changeFavouriteBorderIcon(this, imbFavourite);
        } else if (resource.state == ResourceState.SUCCESS) {
            CommonViewUtils.changeFullFavouriteIcon(this, imbFavourite);
        } else if (resource.state == ResourceState.LOADING) {
            Log.i("Currency Loading", "Loading");
        }
    }

    private void bindData(List<DrinkDetail> cocktailDetail) {
        this.drinkDetail = cocktailDetail;
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

    private void addIngredient(List<DrinkDetail> cocktailDetail) {

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
    public void onClick(View view) {
        if (view.getId() == R.id.imb_favourite) {
            if (String.valueOf(imbFavourite.getTag()).equals(String.valueOf(R.drawable.ic_favorite_border))) {
                CommonViewUtils.changeFullFavouriteIcon(this, imbFavourite);
                drinkDetailViewModel.saveDrink(new CacheDrink(drinkDetail.get(0).getDrinkId(),
                        drinkDetail.get(0).getStrDrink(), drinkDetail.get(0).getStrDrinkThumb()));
            } else {
                CommonViewUtils.changeFavouriteBorderIcon(this, imbFavourite);
                drinkDetailViewModel.removeDrink(drinkDetail.get(0).getDrinkId());
            }
        }
    }

    @Override
    public void clickIngredientItem(String ingredientName) {
        startActivity(new Intent(DrinkDetailActivity.this, IngredientDetailActivity.class)
                .putExtra(Constants.EXTRA_NAME, ingredientName));
    }
}
