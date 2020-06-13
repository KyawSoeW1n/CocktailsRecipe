package com.kurio.cocktail.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.kurio.cocktail.Constants;
import com.kurio.cocktail.R;
import com.kurio.cocktail.callback.ClickIngredientItem;

public class DrinkDetailViewHolder extends BaseViewHolder<String> {
    private ClickIngredientItem clickIngredientItem;
    private ImageView imgIngredient;
    private TextView tvIngredient;

    public DrinkDetailViewHolder(@NonNull View itemView, ClickIngredientItem clickIngredientItem) {
        super(itemView);
        this.clickIngredientItem = clickIngredientItem;
        imgIngredient = itemView.findViewById(R.id.img_ingredient);
        tvIngredient = itemView.findViewById(R.id.tv_ingredient);
    }

    @Override
    public void setData(String data) {
        mData = data;
        if (mData != null) {
            Glide.with(itemView.getContext())
                    .load(Constants.IMAGE_PATH + mData + Constants.PHOTO_EXTENSION)
                    .into(imgIngredient);
            tvIngredient.setText(data);
        }
    }

    @Override
    public void onClick(View v) {

        //TODO setListener

    }

}
