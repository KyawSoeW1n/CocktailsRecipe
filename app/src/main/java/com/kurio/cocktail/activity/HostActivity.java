package com.kurio.cocktail.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.kurio.cocktail.R;

import java.util.HashSet;
import java.util.Set;

import dagger.android.AndroidInjection;

public class HostActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    private NavController navController;

    private NavigationView navigationView;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);
        AndroidInjection.inject(this);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        setupNavigation();
    }

    // Setting Up One Time Navigation
    private void setupNavigation() {
        Set<Integer> topLevelDestinations = new HashSet<Integer>() {{
            add(R.id.nav_fragment_dashboard);
            add(R.id.nav_fragment_drink);
            add(R.id.nav_fragment_ingredient);
            add(R.id.nav_about);
        }};
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        appBarConfiguration = new AppBarConfiguration.Builder(topLevelDestinations)
                .setDrawerLayout(drawerLayout)
                .build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.menu_home);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        menuItem.setChecked(true);
        switch (menuItem.getItemId()) {

            case R.id.menu_home:
                navController.navigate(R.id.nav_fragment_dashboard);
                break;

            case R.id.menu_drink:
//                navController.setGraph(R.navigation.nav_graph, setBundle(Constants.FAVOURITE_DRINK));
                navController.navigate(R.id.nav_fragment_drink);
                break;

            case R.id.menu_ingredient:
                navController.navigate(R.id.nav_fragment_ingredient);
                break;

            case R.id.menu_about:
                navController.navigate(R.id.nav_about);
                break;

        }
        drawerLayout.closeDrawers();
        return true;
    }

    private Bundle setBundle(String data) {
        Bundle bundle = new Bundle();
        bundle.putString("Test", data);
        return bundle;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
