package com.kurio.cocktail.viewholder;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.kurio.cocktail.R;
import com.kurio.cocktail.callback.ClickCocktailItem;
import com.kurio.cocktail.callback.ClickIngredientItem;
import com.kurio.cocktail.domain.model.Cocktail;
import com.kurio.cocktail.domain.model.CocktailDetail;

public class DrinkDetailViewHolder extends BaseViewHolder<CocktailDetail> {
    private ClickIngredientItem clickCocktailItem;
    private TextView tvIngredientName;
    private ImageView imgIngredient;

    public DrinkDetailViewHolder(@NonNull View itemView, ClickIngredientItem clickCocktailItem) {
        super(itemView);
        this.clickCocktailItem = clickCocktailItem;
        tvIngredientName = itemView.findViewById(R.id.tv_ingredient);
        imgIngredient= itemView.findViewById(R.id.img_ingredient);
    }

    @Override
    public void setData(CocktailDetail data) {
        mData = data;
//        if (mData != null) {
//            tvIngredientName.setText(mData.getS());
//            Glide.with(itemView.getContext())
//                    .load(mData.getStrDrinkThumb())
//                    .into(imgCocktail);
//        }
    }

    @Override
    public void onClick(View v) {
        if (clickCocktailItem != null)
            clickCocktailItem.clickIngredientItem(mData);
        else
            Log.i("GGWP", "GG");
    }

}
