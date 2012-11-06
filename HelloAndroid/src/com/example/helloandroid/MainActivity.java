package com.example.helloandroid;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import java.io.*;
import java.net.*;


public class MainActivity extends Activity {

    public ImageView mImageView;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mImageView = (ImageView)findViewById(R.id.imageView1);
        
        Button btnTest = (Button)findViewById(R.id.button3);
        btnTest.setOnClickListener(new Button.OnClickListener() {
        	public void onClick(View v) {
        		
        		ConnectivityManager connMgr = (ConnectivityManager) 
        	            getSystemService(Context.CONNECTIVITY_SERVICE);
        	        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        	        if (networkInfo != null && networkInfo.isConnected()) {
        	            new DownloadImageTask().execute("http://s.nx.com/S2/game/bf/bf_obt/Main_new/bg_cs.gif");
        	        } else {
        	            //.setText("No network connection available.");
        	        } 
        	}
        	
        });
        
        Button btnPref1 = (Button)findViewById(R.id.pref1);
        btnPref1.setOnClickListener(new Button.OnClickListener() {
        	
        	public void onClick(View v) {
        		
        		Intent prefIntent = new Intent(MainActivity.this, Pref2Activity.class);
        		startActivity(prefIntent);
        	}
        });
        
       
    }
    
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
	    /** The system calls this to perform work in a worker thread and
	      * delivers it the parameters given to AsyncTask.execute() */
	    protected Bitmap doInBackground(String... urls) {
	        return loadImageFromNetwork(urls[0]);
	    }	
	    
	    /** The system calls this to perform work in the UI thread and delivers
	      * the result from doInBackground() */
	    protected void onPostExecute(Bitmap result) {
	        mImageView.setImageBitmap(result);
	    }
	}
    
    private Bitmap loadImageFromNetwork(String url) {

    	Bitmap bitmap = null;
    	
        try {
            bitmap = BitmapFactory.decodeStream((InputStream) new URL(url).getContent());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
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

