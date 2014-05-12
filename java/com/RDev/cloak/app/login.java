package com.RDev.cloak.app;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

public class login extends Activity {
Button signup;
String usertxt;
EditText user;
EditText password;
String passwordtxt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Parse.initialize(this, "xgsso9bGb2buDFUcIsGY2tGXYUTVXlBKHIqc496i", "lFGorxlMddZv2TRbkp0aGfLSi1CHDxSe2PRS5c4u");
        super.onCreate(savedInstanceState);
        getActionBar().show();
        setContentView(R.layout.login);
        password = (EditText) findViewById(R.id.editText);
        user = (EditText) findViewById(R.id.editText2);
        signup = (Button) findViewById(R.id.button);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordtxt = password.getText().toString();
                usertxt = user.getText().toString();
                ParseUser.logInInBackground("Administrator", "tetoffensive", new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            Context context = getApplicationContext();
                            CharSequence text = "Login successful!";
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            Intent intent = new Intent(login.this, dashboard.class);
                            startActivity(intent);

                        } else {
                            Context context = getApplicationContext();
                            CharSequence text = "There was an error logging in! Please try again.";
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            e.printStackTrace();
                        }

                    }
                });




            }
        });

    }


}