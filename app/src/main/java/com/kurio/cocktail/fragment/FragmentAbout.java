package com.kurio.cocktail.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kurio.cocktail.BuildConfig;
import com.kurio.cocktail.CocktailApplication;
import com.kurio.cocktail.R;

public class FragmentAbout extends Fragment {
    TextView tvVersion;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity() != null)
            ((CocktailApplication) getActivity().getApplication()).supportFragmentInjector().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_about, container, false);
        tvVersion = v.findViewById(R.id.tv_version);
        tvVersion.setText(getString(R.string.app_version, BuildConfig.VERSION_NAME, String.valueOf(BuildConfig.VERSION_CODE)));
        return v;
    }
}
