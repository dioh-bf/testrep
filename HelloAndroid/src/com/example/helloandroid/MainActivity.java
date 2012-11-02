package com.example.helloandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import android.content.*;


public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
   
    public void OnButtonClicked(View view) {
    	TextView text1 = (TextView)findViewById(R.id.textView1);
    	text1.setText("Hello Lindsey!!");
    	//getString(R.string.hello_world);
    }
    
    public void OnBtnNextClick(View view) {
    	Intent intentSub = new Intent( this, SecondActivity.class);
    	startActivity(intentSub);
    }
}
