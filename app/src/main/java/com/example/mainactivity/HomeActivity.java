//package com.example.mainactivity;
//
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class HomePageActivity extends AppCompatActivity {
//
//    TextView visitNumber = findViewById(R.id.visitNumber);
//    EditText commentText = findViewById(R.id.etComment);
//    Button saveButton = findViewById(R.id.buttonSaveComment);
//    int count = 0;
//
//    public static final String SHARED_PREFS = "sharedPrefs";
//    public static final String COMMENT = "text";
//
//    private String comment;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_log);
//    }
//}
////        visitNumber.setText(getString(R.string.visitNumber, count));
////
////
////        saveButton.setOnClickListener(view -> {
////            saveData();
////        });
////
////
////
//
//
////    public void saveData(){
////        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
////        SharedPreferences.Editor editor = sharedPreferences.edit();
////
////        editor.putString(COMMENT, commentText.getText().toString());
////        editor.apply();
////        Toast.makeText(this, "Comment saved", Toast.LENGTH_SHORT).show();
////    }
////
////    public void loadData() {
////        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
////        comment = sharedPreferences.getString(COMMENT, "No comment left");
////    }
////
////    public void updateViews() {
////
////    }

package com.example.mainactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_log);

//        //Setup of bottom navigation bar
//        //TODO Need to change to fragments rather than pasting this method in every single page
//        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
//        bottomNav.setSelectedItemId(R.id.navLog);
//        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch(item.getItemId()){
//                    case R.id.navMain:
//                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                        overridePendingTransition(0, 0);
//                        return true;
//                    case R.id.navAddDrinks:
//                        startActivity(new Intent(getApplicationContext(), DrinkAdderActivity.class));
//                        overridePendingTransition(0, 0);
//                        return true;
//                    case R.id.navLog:
//                        return true;
//                }
//                return false;
//            }
//        });
    }
}
