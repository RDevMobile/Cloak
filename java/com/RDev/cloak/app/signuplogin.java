package com.RDev.cloak.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class signuplogin extends Activity {
    Button signup;
    String Emailtxt;
    String passwordtxt;
    EditText password;
    EditText Email;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Email = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);


        signup = (Button) findViewById(R.id.button);
        signup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Emailtxt = Email.getText().toString();
                passwordtxt = password.getText().toString();
                ParseUser user = new ParseUser();
                user.setUsername(Emailtxt);
                user.setPassword(passwordtxt);




                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            Context context = getApplicationContext();
                            CharSequence text = "You are now a Beta Tester for Cloak.";
                            int duration = Toast.LENGTH_SHORT;
                             Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            Intent intent2 = new Intent(signuplogin.this, login.class);
                            startActivity(intent2);
                        }else{
                            Context context1 = getApplicationContext();
                            CharSequence text = "There was an error!";
                            int duration1 = Toast.LENGTH_SHORT;

                            Toast toast1 = Toast.makeText(context1, text, duration1);
                            toast1.show();
                            e.printStackTrace();
                        }
                    }
                });
            }

            {


            }

        });

    }
}