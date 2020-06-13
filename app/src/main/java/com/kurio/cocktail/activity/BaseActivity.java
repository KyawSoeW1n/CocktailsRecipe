package com.kurio.cocktail.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;
    protected Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        renderScreen();
        mActivity = this;
        mContext = mActivity.getBaseContext();
        initComponent();
        initData();
        showNavigationBackArrow(getToolbar());
    }

    /**
     * all the common setting for all the activity screen
     */
    private void renderScreen() {
        setContentView(getLayoutId());

    }

    /**
     * the method for UI component pre-setting
     */
    protected abstract void initComponent();

    /**
     * the method for request or adapt data
     */
    protected abstract void initData();

    /**
     * @return the current layout resource
     */
    protected abstract int getLayoutId();


    /**
     * @return the toolbar
     */
    protected abstract Toolbar getToolbar();


    /**
     * all the common toolbar for all the activity screen
     */
    private void showNavigationBackArrow(Toolbar toolbar) {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            toolbar.setNavigationOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mActivity.onBackPressed();
                        }
                    }
            );
        }
    }
}
