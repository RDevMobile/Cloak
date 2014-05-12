package com.RDev.cloak.app;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.support.v7.app.ActionBar;


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

}
