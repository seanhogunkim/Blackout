package com.example.blackout;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Main activity of the app
 * <p>
 * Author: Sean Hogun Kim
 */
public class MainActivity extends AppCompatActivity {

    FragmentHome homeFrag = new FragmentHome();
    FragmentAddDrink addDrinkFrag = new FragmentAddDrink();
    FragmentLog logFrag = new FragmentLog();

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = homeFrag;
            switch (item.getItemId()) {
                case R.id.navMain:
                    selectedFragment = new FragmentHome();
                    break;
                case R.id.navAddDrinks:
                    selectedFragment = addDrinkFrag;
                    break;
                case R.id.navLog:
                    selectedFragment = logFrag;
                    break;
            }
            openFragment(selectedFragment);
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialising and setting bottomNav bar. Start app by opening the home Fragment
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        openFragment(new FragmentHome());

    }

    public void openFragment(Fragment selectedFragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
    }


}