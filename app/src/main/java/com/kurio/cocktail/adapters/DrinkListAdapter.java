package com.kurio.cocktail.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.kurio.cocktail.R;
import com.kurio.cocktail.callback.ClickCocktailItem;
import com.kurio.cocktail.domain.model.Cocktail;
import com.kurio.cocktail.viewholder.BaseViewHolder;
import com.kurio.cocktail.viewholder.DrinkListViewHolder;

public class DrinkListAdapter extends BaseRecyclerAdapter<DrinkListViewHolder, Cocktail> {
    private ClickCocktailItem clickCocktailItem;

    public DrinkListAdapter(Context context, ClickCocktailItem clickCocktailItem) {
        super(context);
        this.clickCocktailItem = clickCocktailItem;
    }

    @NonNull
    @Override
    public BaseViewHolder<Cocktail> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.drink_listitem, parent, false);
        return new DrinkListViewHolder(v, clickCocktailItem);
    }
}
