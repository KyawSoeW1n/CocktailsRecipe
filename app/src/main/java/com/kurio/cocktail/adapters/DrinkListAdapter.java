package com.kurio.cocktail.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.kurio.cocktail.R;
import com.kurio.cocktail.callback.ClickDrinkItem;
import com.kurio.cocktail.domain.model.Drink;
import com.kurio.cocktail.viewholder.BaseViewHolder;
import com.kurio.cocktail.viewholder.DrinkListViewHolder;

public class DrinkListAdapter extends BaseRecyclerAdapter<DrinkListViewHolder, Drink> {
    private ClickDrinkItem clickDrinkITem;

    public DrinkListAdapter(Context context, ClickDrinkItem clickDrinkITem) {
        super(context);
        this.clickDrinkITem = clickDrinkITem;
    }

    @NonNull
    @Override
    public BaseViewHolder<Drink> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.drink_listitem, parent, false);
        return new DrinkListViewHolder(v, clickDrinkITem);
    }
}
