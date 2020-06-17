package com.kurio.cocktail.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.kurio.cocktail.R;
import com.kurio.cocktail.callback.ClickFavouriteDrinkItem;
import com.kurio.cocktail.domain.model.CacheDrink;

public class FavouriteDrinkViewHolder extends BaseViewHolder<CacheDrink> {
    private ClickFavouriteDrinkItem clickFavouriteDrinkItem;
    private ImageView imgCocktail;
    private TextView tvDrinkName;

    public FavouriteDrinkViewHolder(@NonNull View itemView, ClickFavouriteDrinkItem clickFavouriteDrinkItem) {
        super(itemView);
        this.clickFavouriteDrinkItem = clickFavouriteDrinkItem;
        imgCocktail = itemView.findViewById(R.id.img_ingredient);
        tvDrinkName = itemView.findViewById(R.id.tv_ingredient);
    }

    @Override
    public void onClick(View v) {
        if (clickFavouriteDrinkItem != null)
            clickFavouriteDrinkItem.clickDrinkItem(mData);
    }

    @Override
    public void setData(CacheDrink data) {
        mData = data;
        if (mData != null) {
            Glide.with(itemView.getContext())
                    .load(mData.getDrinkUrl())
                    .into(imgCocktail);
            tvDrinkName.setText(mData.getDrinkName());
        }
    }
}
