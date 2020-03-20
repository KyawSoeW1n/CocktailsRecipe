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

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class IngredientDetailActivity extends BaseActivity {
    TextView tvType, tvDescription, tvAlcohol, tvToolbarTitle;
    AppBarLayout appBarLayout;
    @Inject
    ViewModelFactory viewModelFactory;
    IngredientDetailViewModel ingredientDetailViewModel;
    ImageView imgIngredient;

    @Override
    protected void initComponent() {
        tvType = findViewById(R.id.tv_type);
        tvDescription = findViewById(R.id.tv_description);
        tvAlcohol = findViewById(R.id.tv_alcoholic);
        tvToolbarTitle = findViewById(R.id.tv_toolbar_title);
        appBarLayout = findViewById(R.id.appbar);
        imgIngredient = findViewById(R.id.img_cocktail);
        showNavigationBackArrow();
        setUpListener();
    }

    private void showNavigationBackArrow() {
        Toolbar toolbar = findViewById(R.id.toolbar_ingredient_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mActivity.onBackPressed();
                    }
                }
        );
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

    private void getIngredientDetail(Resource<IngredientDetail> ingredientDetailResource) {
        if (ingredientDetailResource.state == ResourceState.ERROR) {
            Log.i("ERROR", "error \t" + ingredientDetailResource.errorMessage);
        } else if (ingredientDetailResource.state == ResourceState.SUCCESS) {
            Log.i("SUCCESS", "Success");
            if (ingredientDetailResource.data != null) {
                bindData(ingredientDetailResource.data);
            }
        } else if (ingredientDetailResource.state == ResourceState.LOADING) {
            Log.i("Currency Loading", "Loading");
        }
    }

    private void bindData(IngredientDetail ingredientDetail) {
        if (ingredientDetail.getStrAlcohol() != null && !ingredientDetail.getStrAlcohol().isEmpty())
            tvAlcohol.setText(ingredientDetail.getStrAlcohol());
        else
            tvAlcohol.setVisibility(View.GONE);

        if (ingredientDetail.getStrDescription() != null && !ingredientDetail.getStrDescription().isEmpty())
            tvDescription.setText(ingredientDetail.getStrDescription());
        else
            tvDescription.setVisibility(View.GONE);
        if (ingredientDetail.getStrType() != null && !ingredientDetail.getStrType().isEmpty())
            tvType.setText(ingredientDetail.getStrType());
        else
            tvType.setVisibility(View.GONE);

        tvToolbarTitle.setText(ingredientDetail.getStrIngredient());
        Glide.with(this)
                .load(Constants.IMAGE_PATH + ingredientDetail.getStrIngredient() + Constants.PHOTO_EXTENSION)
                .into(imgIngredient);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ingredient_detail;
    }
}
