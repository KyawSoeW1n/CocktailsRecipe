package com.kurio.cocktail.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.kurio.cocktail.R;
import com.kurio.cocktail.callback.ClickCocktailItem;
import com.kurio.cocktail.domain.model.Drink;

public class DrinkListViewHolder extends BaseViewHolder<Drink> {
    private ClickCocktailItem clickCocktailItem;
    private TextView tvCocktailName;
    private ImageView imgCocktail;

    public DrinkListViewHolder(@NonNull View itemView, ClickCocktailItem clickCocktailItem) {
        super(itemView);
        this.clickCocktailItem = clickCocktailItem;
        tvCocktailName = itemView.findViewById(R.id.tv_cocktail_name);
        imgCocktail = itemView.findViewById(R.id.img_cocktail);
    }

    @Override
    public void setData(Drink data) {
        mData = data;
        if (mData != null) {
            tvCocktailName.setText(mData.getStrDrink());
            Glide.with(itemView.getContext())
                    .load(mData.getStrDrinkThumb())
                    .into(imgCocktail);
        }
    }

    @Override
    public void onClick(View v) {
        if (clickCocktailItem != null)
            clickCocktailItem.clickCocktailItem(mData);
    }

}
