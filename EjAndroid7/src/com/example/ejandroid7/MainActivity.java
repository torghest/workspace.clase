package com.example.ejandroid7;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
    	
		Intent i;
		switch (item.getItemId()) {
    		case R.id.item2:
    			i = new Intent("android.intent.action.VIEW", Uri.parse("http://developer.android.com"));
    			startActivity(i);
	            break;
    		case R.id.item4: i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.marca.com"));
	            startActivity(i);
	            break;
    		case R.id.item5: i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.as.com"));
	            startActivity(i);
	            break;
    		case R.id.item6: finish();
       	}
		return true;
    }
    
}
