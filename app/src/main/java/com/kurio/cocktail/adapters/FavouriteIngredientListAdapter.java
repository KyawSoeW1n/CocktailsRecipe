package com.kurio.cocktail.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.kurio.cocktail.R;
import com.kurio.cocktail.callback.ClickFavouriteDrinkItem;
import com.kurio.cocktail.callback.ClickFavouriteIngredientItem;
import com.kurio.cocktail.domain.model.CacheIngredient;
import com.kurio.cocktail.viewholder.BaseViewHolder;
import com.kurio.cocktail.viewholder.DrinkListViewHolder;
import com.kurio.cocktail.viewholder.FavouriteIngredientViewHolder;

public class FavouriteIngredientListAdapter extends BaseRecyclerAdapter<DrinkListViewHolder, CacheIngredient> {
    private ClickFavouriteIngredientItem clickFavouriteIngredientItem;

    public FavouriteIngredientListAdapter(Context context, ClickFavouriteIngredientItem clickFavouriteIngredientItem) {
        super(context);
        this.clickFavouriteIngredientItem = clickFavouriteIngredientItem;
    }

    @NonNull
    @Override
    public BaseViewHolder<CacheIngredient> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.drink_ingredient, parent, false);
        return new FavouriteIngredientViewHolder(v, clickFavouriteIngredientItem);
    }
}