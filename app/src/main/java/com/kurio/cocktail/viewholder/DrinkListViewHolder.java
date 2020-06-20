package com.kurio.cocktail.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kurio.cocktail.R;
import com.kurio.cocktail.callback.ClickDrinkItem;
import com.kurio.cocktail.domain.model.Drink;

public class DrinkListViewHolder extends BaseViewHolder<Drink> {
    private ClickDrinkItem clickDrinkITem;
    private TextView tvCocktailName;
    private ImageView imgCocktail;

    public DrinkListViewHolder(@NonNull View itemView, ClickDrinkItem clickDrinkITem) {
        super(itemView);
        this.clickDrinkITem = clickDrinkITem;
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
                    .apply(new RequestOptions().placeholder(R.mipmap.ic_launcher))
                    .into(imgCocktail);
        }
    }

    @Override
    public void onClick(View v) {
        if (clickDrinkITem != null)
            clickDrinkITem.clickCocktailItem(mData);
    }

}
