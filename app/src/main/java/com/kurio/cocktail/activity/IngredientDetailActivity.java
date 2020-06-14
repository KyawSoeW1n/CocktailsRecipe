package com.kurio.cocktail.activity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.kurio.cocktail.Constants;
import com.kurio.cocktail.R;
import com.kurio.cocktail.data.presentation.IngredientDetailViewModel;
import com.kurio.cocktail.data.presentation.state.Resource;
import com.kurio.cocktail.data.presentation.state.ResourceState;
import com.kurio.cocktail.domain.model.IngredientDetail;
import com.kurio.cocktail.injection.ViewModelFactory;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class IngredientDetailActivity extends BaseActivity {
    TextView tvType, tvDescription, tvAlcohol, tvToolbarTitle;
    AppBarLayout appBarLayout;
    @Inject
    ViewModelFactory viewModelFactory;
    IngredientDetailViewModel ingredientDetailViewModel;
    ImageView imgIngredient;
    Toolbar toolbar;

    @Override
    protected void initComponent() {
        tvType = findViewById(R.id.tv_type);
        tvDescription = findViewById(R.id.tv_description);
        tvAlcohol = findViewById(R.id.tv_alcoholic);
        tvToolbarTitle = findViewById(R.id.tv_toolbar_title);
        appBarLayout = findViewById(R.id.appbar);
        imgIngredient = findViewById(R.id.img_cocktail);
        toolbar = findViewById(R.id.toolbar_ingredient_detail);
        setUpListener();
    }

    private void setUpListener() {
        appBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            if (Math.abs(verticalOffset) - appBarLayout.getTotalScrollRange() == 0) {
                //  Collapsed
                tvToolbarTitle.setTextColor(getResources().getColor(R.color.white));
            } else {
                //Expanded
                tvToolbarTitle.setTextColor(getResources().getColor(R.color.black));
            }
        });
    }

    @Override
    protected void initData() {
        AndroidInjection.inject(this);
        ingredientDetailViewModel = ViewModelProviders.of(this, viewModelFactory).get(IngredientDetailViewModel.class);
        ingredientDetailViewModel.getIngredientDetail(getIntent().getStringExtra(Constants.EXTRA_NAME));
        ingredientDetailViewModel.getIngredientDetailLiveData().observe(this, this::getIngredientDetail);
    }

    private void getIngredientDetail(Resource<List<IngredientDetail>> ingredientDetailResource) {
        if (ingredientDetailResource.state == ResourceState.ERROR) {
            Log.i("ERROR", "error \t" + ingredientDetailResource.errorMessage);
        } else if (ingredientDetailResource.state == ResourceState.SUCCESS) {
            Log.i("IDetail success", "Success");
            if (ingredientDetailResource.data != null) {
                bindData(ingredientDetailResource.data);
            }
        } else if (ingredientDetailResource.state == ResourceState.LOADING) {
            Log.i("Currency Loading", "Loading");
        }
    }

    private void bindData(List<IngredientDetail> ingredientDetail) {
        if (ingredientDetail.get(0).getStrAlcohol() != null && !ingredientDetail.get(0).getStrAlcohol().isEmpty())
            tvAlcohol.setText(ingredientDetail.get(0).getStrAlcohol());
        else
            tvAlcohol.setVisibility(View.GONE);

        if (ingredientDetail.get(0).getStrDescription() != null && !ingredientDetail.get(0).getStrDescription().isEmpty())
            tvDescription.setText(ingredientDetail.get(0).getStrDescription());
        else
            tvDescription.setVisibility(View.GONE);
        if (ingredientDetail.get(0).getStrType() != null && !ingredientDetail.get(0).getStrType().isEmpty())
            tvType.setText(ingredientDetail.get(0).getStrType());
        else
            tvType.setVisibility(View.GONE);

        tvToolbarTitle.setText(ingredientDetail.get(0).getStrIngredient());
        Glide.with(this)
                .load(Constants.IMAGE_PATH + ingredientDetail.get(0).getStrIngredient() + Constants.PHOTO_EXTENSION)
                .into(imgIngredient);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ingredient_detail;
    }

    @Override
    protected Toolbar getToolbar() {
        return toolbar;
    }
}
