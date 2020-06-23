package com.example.blackout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

/**
 * Fragment for blackout
 */

public class FragmentBlackout extends Fragment {

    boolean matches = false;
    private String _password;
    private int counter = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blackout, container, false);

        //Setting buttons and text boxes on the screen


        TextView randomPassword = rootView.findViewById(R.id.tvRandomPassword);
        EditText editPassword = rootView.findViewById(R.id.etPassword);
        TextView numFailedAttempts = rootView.findViewById(R.id.tvFailedAttempts);
        Button login = rootView.findViewById(R.id.buttonLogin);
        Button addDrink = rootView.findViewById(R.id.buttonDrinksAdder);
        CheckBox blackout = rootView.findViewById(R.id.checkBox);
        Passwords passwordsList = new Passwords();
        //Generation random password for the checker and setting it

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
                Toast.makeText(getActivity(), "u didn't type anything??", Toast.LENGTH_SHORT).show();
            }

            //If there is any input, check if it is matching
            else {
                matches = checkPassword(inputPassword, _password);

                //If it does not match, notify user and increase counter
                if (!matches) {
                    counter++;
                    Toast.makeText(getActivity(), "u typed it wrong", Toast.LENGTH_SHORT).show();
                    numFailedAttempts.setText(getString(R.string.numAttempts, counter));
                }
                //If it does match, send user to FragmentHome
                else {
                    Toast.makeText(getActivity(), "ur not drunk ;)", Toast.LENGTH_SHORT).show();
                    FragmentHome homeFrag = new FragmentHome();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homeFrag).addToBackStack(null).commit();

                }

            }

        });

        //Setting up listener for add drinks button. Send user to drink adder page without needing password verification
        addDrink.setOnClickListener(view -> {
            FragmentAddDrink drinkFrag = new FragmentAddDrink();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, drinkFrag).addToBackStack(null).commit();

        });


        //Return for onCreateView
        return rootView;
    }

    /**
     * Method that checks if password entered matches text from randomPassword
     */
    private boolean checkPassword(String inputPassword, String pass) {
        return inputPassword.equals(pass);
    }
}
