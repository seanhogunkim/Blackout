package com.example.mainactivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

@RequiresApi(api = Build.VERSION_CODES.M) //necessary for makeBasic???
public class MainActivity extends AppCompatActivity {

    boolean matches = false;
    ActivityOptions options = ActivityOptions.makeBasic();
    private TextView randomPassword;
    private EditText editPassword;
    private TextView numFailedAttempts;
    private Button login;
    private Button addDrink;
    private Passwords passwordsList;
    private String _password;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Setting buttons and text boxes on the screen
         */
        randomPassword = findViewById(R.id.tvRandomPassword);
        editPassword = findViewById(R.id.etPassword);
        numFailedAttempts = findViewById(R.id.tvFailedAttempts);
        login = findViewById(R.id.buttonLogin);
        addDrink = findViewById(R.id.buttonDrinksAdder);

        //Generation random password for the checker and setting it
        passwordsList = new Passwords();
        randomPassword.setText(passwordsList.randomPassword());
        numFailedAttempts.setText(getString(R.string.numAttempts, counter));

        //Setting up listener for the login button
        login.setOnClickListener(view -> {
            _password = randomPassword.getText().toString();
            String inputPassword = editPassword.getText().toString();

            //If nothing is input
            if (inputPassword.isEmpty()) {
                Toast.makeText(MainActivity.this, "u didn't type anything??", Toast.LENGTH_SHORT).show();
            }

            //If there is any input, check if it is matching
            else {
                matches = checkPassword(inputPassword, _password);

                //If it does not match, notify user and increase counter
                if (!matches) {
                    counter++;
                    Toast.makeText(MainActivity.this, "u typed it wrong", Toast.LENGTH_SHORT).show();
                    numFailedAttempts.setText(getString(R.string.numAttempts, counter));
                }
                //If it does match, send user to home page
                else {
                    Toast.makeText(MainActivity.this, "ur not drunk ;)", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                    startActivity(intent);
                }

            }

        });

        //Setting up listener for add drinks button. Send user to drink adder page without needing password verification
        addDrink.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, DrinkAdderActivity.class);
            startActivity(intent);
        });


    }

    /**
     * Method that checks if password entered matches text from randomPassword
     */
    private boolean checkPassword(String inputPassword, String pass) {
        return inputPassword.equals(pass);
    }
}