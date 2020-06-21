package com.example.mainactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DrinkAdderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_adder);


//        //Setup of bottom navigation bar
//        //TODO Need to change to fragments rather than pasting this method in every single page
//        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
//        bottomNav.setSelectedItemId(R.id.navAddDrinks);
//        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch(item.getItemId()){
//                    case R.id.navMain:
//                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                        overridePendingTransition(0, 0);
//                        return true;
//                    case R.id.navAddDrinks:
//                        return true;
//                    case R.id.navLog:
//                        startActivity(new Intent(getApplicationContext(), HomePageActivity.class));
//                        overridePendingTransition(0, 0);
//                        return true;
//                }
//                return false;
//            }
//        });


    }
}