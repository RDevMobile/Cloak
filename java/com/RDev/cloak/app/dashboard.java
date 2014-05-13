package com.RDev.cloak.app;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.support.v7.app.ActionBar;
import android.widget.Toast;


public class dashboard extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.show();
        setContentView(R.layout.dashboard);


    }

public void more_info_txt(View view){
    setContentView(R.layout.info_txt);
}

    public void go_back_txt(View view){
        setContentView(R.layout.dashboard);
    }

    public void itemClicked(View v) {
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox)v;
        if(checkBox.isChecked()){
            Intent intent2 = new Intent(this, smslistener.class);
            startActivity(intent2);
        }
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
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Uh Oh!");
            alertDialog.setMessage("The settings are currently Under Development!");
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            alertDialog.show();
        }
        if (id == R.id.action_logout) {
            Intent intent3 = new Intent(this, logout.class);
            startActivity(intent3);
        }

        return super.onOptionsItemSelected(item);

    }
}
