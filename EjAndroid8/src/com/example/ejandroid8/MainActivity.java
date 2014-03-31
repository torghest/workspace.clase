package com.example.ejandroid8;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText et1;
	EditText et2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.editText1);
        registerForContextMenu(et1); 
        et2=(EditText)findViewById(R.id.editText2);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo)
    {
        menu.setHeaderTitle("Convertir texto a:");        
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
    }  

    public boolean onContextItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
        case R.id.item1:
        	et2.setText(et1.getText().toString().toUpperCase());
       	 	break;
        case R.id.item2: 
        	et2.setText(et1.getText().toString().toLowerCase());
        	break;
        }
        return true;
    }

}
