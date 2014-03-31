package com.example.ejandroid1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private double valor;
	private EditText in;
	private EditText out;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Asignamos los objetos  
        this.in = (EditText) findViewById(R.id.edit_in);  
        this.out = (EditText) findViewById(R.id.edit_out);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void cSumar(View view) {  
        this.valor = Double.parseDouble(this.in.getText().toString());  
        this.out.setText(Double.toString((this.valor + 5)));           
      }  
    
}
