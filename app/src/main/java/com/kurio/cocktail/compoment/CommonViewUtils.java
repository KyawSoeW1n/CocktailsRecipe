package com.kurio.cocktail.compoment;

import android.content.Context;
import android.widget.ImageButton;

import com.kurio.cocktail.R;

public class CommonViewUtils {

    public static void changeFavouriteBorderIcon(Context context, ImageButton imageButton) {
        imageButton.setTag(R.drawable.ic_favorite_border);
        imageButton.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite_border));
    }

    public static void changeFullFavouriteIcon(Context context, ImageButton imageButton) {
        imageButton.setTag(R.drawable.ic_favorite_full);
        imageButton.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite_full));
    }
}
