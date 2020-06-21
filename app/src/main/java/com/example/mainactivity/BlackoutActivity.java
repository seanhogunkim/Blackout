package com.example.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class BlackoutActivity extends AppCompatActivity {

    boolean matches = false;

    private TextView randomPassword;
    private EditText editPassword;
    private TextView numFailedAttempts;
    private String _password;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackout);


        //Setting buttons and text boxes on the screen
        randomPassword = findViewById(R.id.tvRandomPassword);
        editPassword = findViewById(R.id.etPassword);
        numFailedAttempts = findViewById(R.id.tvFailedAttempts);
        Button login = findViewById(R.id.buttonLogin);
        Button addDrink = findViewById(R.id.buttonDrinksAdder);
        CheckBox blackout = findViewById(R.id.checkBox);

        //Generation random password for the checker and setting it
        Passwords passwordsList = new Passwords();
        randomPassword.setText(passwordsList.randomPassword());
        numFailedAttempts.setText(getString(R.string.numAttempts, counter));


        //Setting up listener for blackout mode button
        blackout.setOnClickListener(view -> {

        });


        //Setting up listener for the login button
        login.setOnClickListener(view -> {
            _password = randomPassword.getText().toString();
            String inputPassword = editPassword.getText().toString();

            //If nothing is input
            if (inputPassword.isEmpty()) {
                Toast.makeText(BlackoutActivity.this, "u didn't type anything??", Toast.LENGTH_SHORT).show();
            }

            //If there is any input, check if it is matching
            else {
                matches = checkPassword(inputPassword, _password);

                //If it does not match, notify user and increase counter
                if (!matches) {
                    counter++;
                    Toast.makeText(BlackoutActivity.this, "u typed it wrong", Toast.LENGTH_SHORT).show();
                    numFailedAttempts.setText(getString(R.string.numAttempts, counter));
                }
                //If it does match, send user to home page
                else {
                    Toast.makeText(BlackoutActivity.this, "ur not drunk ;)", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(BlackoutActivity.this, HomeActivity.class);
                    startActivity(intent);

                }

            }

        });

        //Setting up listener for add drinks button. Send user to drink adder page without needing password verification
        addDrink.setOnClickListener(view -> {
            Intent intent = new Intent(BlackoutActivity.this, DrinkAdderActivity.class);
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