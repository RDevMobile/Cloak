package com.RDev.cloak.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.parse.ParseUser;

public class logout extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParseUser.logOut();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}