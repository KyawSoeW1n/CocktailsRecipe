package com.kurio.cocktail.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.kurio.cocktail.R;
import com.kurio.cocktail.callback.ClickCocktailItem;
import com.kurio.cocktail.callback.ClickIngredientItem;
import com.kurio.cocktail.domain.model.Cocktail;
import com.kurio.cocktail.domain.model.CocktailDetail;
import com.kurio.cocktail.viewholder.BaseViewHolder;
import com.kurio.cocktail.viewholder.DrinkDetailViewHolder;
import com.kurio.cocktail.viewholder.DrinkListViewHolder;

public class DrinkIngredientListAdapter extends BaseRecyclerAdapter<DrinkListViewHolder, CocktailDetail> {
    private ClickIngredientItem clickCocktailItem;

    public DrinkIngredientListAdapter(Context context, ClickIngredientItem clickCocktailItem) {
        super(context);
        this.clickCocktailItem = clickCocktailItem;
    }

    @NonNull
    @Override
    public BaseViewHolder<CocktailDetail> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.drink_ingredient, parent, false);
        return new DrinkDetailViewHolder(v, clickCocktailItem);
    }
}
