package com.kurio.cocktail.component;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;

import com.kurio.cocktail.Constants;
import com.kurio.cocktail.R;
import com.kurio.cocktail.callback.DialogCallback;

public class CommonViewUtils {

    public static void changeFavouriteBorderIcon(Context context, ImageButton imageButton) {
        imageButton.setTag(R.drawable.ic_favorite_border);
        imageButton.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite_border));
    }

    public static void changeFullFavouriteIcon(Context context, ImageButton imageButton) {
        imageButton.setTag(R.drawable.ic_favorite_full);
        imageButton.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite_full));
    }

    public static void showAlertDialog(Activity activity, String message, String positiveButtonText, String negativeButtonText, DialogCallback dialogCallback) {
        AlertDialog.Builder alertbox = new AlertDialog.Builder(activity);
        alertbox.setMessage(message);
        alertbox.setPositiveButton(positiveButtonText, (dialog, which) -> {
            dialogCallback.dialogEvent(Constants.EVENT_CONFIRM);
            dialog.dismiss();
        });
        alertbox.setNegativeButton(negativeButtonText, (dialog, which) -> {
            dialogCallback.dialogEvent(Constants.EVENT_CANCEL);
            dialog.dismiss();
        });
        alertbox.show();
    }
}
