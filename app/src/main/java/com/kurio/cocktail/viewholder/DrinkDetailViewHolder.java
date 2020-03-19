package com.kurio.cocktail.viewholder;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.kurio.cocktail.Constants;
import com.kurio.cocktail.R;
import com.kurio.cocktail.callback.ClickCocktailItem;
import com.kurio.cocktail.callback.ClickIngredientItem;
import com.kurio.cocktail.domain.model.Cocktail;

public class DrinkDetailViewHolder extends BaseViewHolder<String> {
    private ClickIngredientItem clickIngredientItem;
    private ImageView imgIngredient;

    public DrinkDetailViewHolder(@NonNull View itemView, ClickIngredientItem clickIngredientItem) {
        super(itemView);
        this.clickIngredientItem = clickIngredientItem;
        imgIngredient = itemView.findViewById(R.id.img_ingredient);
    }

    @Override
    public void setData(String data) {
        mData = data;
        if (mData != null) {
            Glide.with(itemView.getContext())
                    .load(Constants.IMAGE_PATH + mData + Constants.PHOTO_EXTENSION)
                    .into(imgIngredient);
        }
    }

    @Override
    public void onClick(View v) {
        if (clickIngredientItem != null)
            Toast.makeText(itemView.getContext(), "CLICk", Toast.LENGTH_SHORT).show();
        else
            Log.i("GGWP", "GG");
    }

}
