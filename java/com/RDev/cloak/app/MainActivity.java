package com.RDev.cloak.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.parse.Parse;
import com.parse.ParseUser;
import com.parse.PushService;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parse.initialize(this, "xgsso9bGb2buDFUcIsGY2tGXYUTVXlBKHIqc496i", "lFGorxlMddZv2TRbkp0aGfLSi1CHDxSe2PRS5c4u");
        PushService.setDefaultPushCallback(this, MainActivity.class);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final ParseUser user = ParseUser.getCurrentUser();
                if (user != null) {
                    Toast.makeText(getBaseContext(), R.string.already_config,
                            Toast.LENGTH_LONG).show();
                    Intent dash = new Intent(MainActivity.this, dashboard.class);
                    startActivity(dash);
                } else {
                    setContentView(R.layout.configure);
                }


            }
        });
    }


    public void Signup(View v) {
        Intent intent = new Intent(this, signuplogin.class);
        startActivity(intent);
    }
public void Login(View view) {
   Intent intent2 = new Intent(this, login.class);
    startActivity(intent2);
}










    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(getBaseContext(), R.string.must_config,
                    Toast.LENGTH_LONG).show();
        }
        if (id == R.id.action_logout) {
            Intent intent3 = new Intent(this, logout.class);
            startActivity(intent3);
        }

        return super.onOptionsItemSelected(item);

    }


}
