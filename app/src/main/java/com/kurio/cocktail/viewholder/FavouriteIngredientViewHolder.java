package com.kurio.cocktail.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.kurio.cocktail.R;
import com.kurio.cocktail.callback.ClickFavouriteIngredientItem;
import com.kurio.cocktail.domain.model.CacheIngredient;

public class FavouriteIngredientViewHolder extends BaseViewHolder<CacheIngredient> {
    private ClickFavouriteIngredientItem clickFavouriteIngredientItem;
    private ImageView imgCocktail;
    private TextView tvDrinkName;

    public FavouriteIngredientViewHolder(@NonNull View itemView, ClickFavouriteIngredientItem clickFavouriteIngredientItem) {
        super(itemView);
        this.clickFavouriteIngredientItem = clickFavouriteIngredientItem;
        imgCocktail = itemView.findViewById(R.id.img_ingredient);
        tvDrinkName = itemView.findViewById(R.id.tv_ingredient);
    }

    @Override
    public void onClick(View v) {
        if (clickFavouriteIngredientItem != null)
            clickFavouriteIngredientItem.clickIngredientItem(mData);
    }

    @Override
    public void setData(CacheIngredient data) {
        mData = data;
        if (mData != null) {
            Glide.with(itemView.getContext())
                    .load(mData.getIngredientUrl())
                    .into(imgCocktail);
            tvDrinkName.setText(mData.getStrIngredient());
        }
    }
}
