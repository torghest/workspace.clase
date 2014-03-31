package com.example.ejandroid9;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Ventana2Activity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana2);
    }
	
	public void cerrar(View view) {
		finish();
	}

}
