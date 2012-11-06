package com.example.helloandroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.widget.TextView;

public class PrefActivity extends Activity {
	
	TextView textName;
	TextView textStNum;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);
        
        textName = (TextView)findViewById(R.id.name);
        textStNum = (TextView)findViewById(R.id.stnum);
        
        SharedPreferences pref = getSharedPreferences("PrefActivity",0);
        String Name = pref.getString("Name", "No Name");
        textName.setText(Name);
    }
    
    @Override
    public void onPause()
    {
    	super.onPause();
    	
    	SharedPreferences pref = getSharedPreferences("PrefActivity", 0);
    	SharedPreferences.Editor edit = pref.edit();
    	
    	String Name = textName.getText().toString();
    	int StNum = 0;
    	
    	try
    	{
    		StNum = Integer.parseInt(textStNum.getText().toString());
    	}
    	catch( Exception e){}
    	
    	edit.putString("Name",  Name);
    	
    	edit.putInt("StNum", StNum);
    	
    	edit.commit();
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_pref, menu);
        return true;
    }
}
