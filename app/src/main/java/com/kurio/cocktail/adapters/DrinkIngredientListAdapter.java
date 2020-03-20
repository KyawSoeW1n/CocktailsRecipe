package com.kurio.cocktail.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.kurio.cocktail.R;
import com.kurio.cocktail.callback.ClickIngredientItem;
import com.kurio.cocktail.viewholder.BaseViewHolder;
import com.kurio.cocktail.viewholder.DrinkDetailViewHolder;

public class DrinkIngredientListAdapter extends BaseRecyclerAdapter<DrinkDetailViewHolder, String> {
    private ClickIngredientItem clickIngredientItem;

    public DrinkIngredientListAdapter(Context context, ClickIngredientItem clickIngredientItem) {
        super(context);
        this.clickIngredientItem = clickIngredientItem;
    }

    @NonNull
    @Override
    public BaseViewHolder<String> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.drink_ingredient, parent, false);
        return new DrinkDetailViewHolder(v, clickIngredientItem);
    }
}
