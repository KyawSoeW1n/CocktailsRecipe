package com.kurio.cocktail.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.kurio.cocktail.R;
import com.kurio.cocktail.callback.ClickFavouriteDrinkItem;
import com.kurio.cocktail.domain.model.CacheDrink;
import com.kurio.cocktail.viewholder.BaseViewHolder;
import com.kurio.cocktail.viewholder.DrinkListViewHolder;
import com.kurio.cocktail.viewholder.FavouriteDrinkViewHolder;

public class FavouriteDrinkListAdapter extends BaseRecyclerAdapter<DrinkListViewHolder, CacheDrink> {
    private ClickFavouriteDrinkItem clickFavouriteDrinkItem;

    public FavouriteDrinkListAdapter(Context context, ClickFavouriteDrinkItem clickFavouriteDrinkItem) {
        super(context);
        this.clickFavouriteDrinkItem = clickFavouriteDrinkItem;
    }

    @NonNull
    @Override
    public BaseViewHolder<CacheDrink> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.drink_ingredient, parent, false);
        return new FavouriteDrinkViewHolder(v, clickFavouriteDrinkItem);
    }
}