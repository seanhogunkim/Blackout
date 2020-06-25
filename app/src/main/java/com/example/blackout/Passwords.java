package com.example.blackout;

/**
 * Array where I store password values
 * <p>
 * Author: Sean Hogun Kim
 */
public class Passwords {
    final String[] passwords = new String[7];

    public Passwords() {
        passwords[0] = "Why is the world spinning";
        passwords[1] = "Pineapples are good for you";
        passwords[2] = "I am at peak performance right now";
        passwords[3] = "I don't feel sleepy at all";
        passwords[4] = "Sometimes it just do be like that";
        passwords[5] = "His ultimate dream fantasy consisted of sleeping eight hours in a row";
        passwords[6] = "I like watermelon";


    }

    protected String randomPassword() {
        return passwords[(int) ((Math.random() * (passwords.length)))];
    }
}
