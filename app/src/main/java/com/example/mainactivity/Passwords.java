package com.example.mainactivity;

public class Passwords {
    final String[] passwords = new String[7];

    public Passwords() {
        passwords[0] = "She had a habit of taking showers in lemonade.";
        passwords[1] = "Pineapples are good for you";
        passwords[2] = "Nobody questions who built the pyramids in Mexico.";
        passwords[3] = "The pet shop stocks everything you need to keep your anaconda happy.";
        passwords[4] = "We have never been to Asia, nor have we visited Africa.";
        passwords[5] = "His ultimate dream fantasy consisted of being content and sleeping eight hours in a row.";
        passwords[6] = "I like watermelon";


    }

    protected String randomPassword() {
        return passwords[(int) ((Math.random() * (passwords.length)))];
    }
}
