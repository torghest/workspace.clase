package com.example.ejandroid5;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv1;
	private RadioButton r1,r2,r3,r4;
	private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.textView1);
        r1=(RadioButton)findViewById(R.id.radio0);
        r2=(RadioButton)findViewById(R.id.radio1);
        r3=(RadioButton)findViewById(R.id.radio2);
        r4=(RadioButton)findViewById(R.id.radio3);
        rg=(RadioGroup)findViewById(R.id.radioGroup1);
        //Seleccionar por defecto el radio Verde
        rg.check(R.id.radio1);

    }

    public void mostrarColor(View view) {
    	
        int radioseleccionado=rg.getCheckedRadioButtonId();
        
		switch (radioseleccionado) {
			case R.id.radio0:
//				tv1.setTag("Rojo");
				tv1.setTextColor(Color.RED);
				break;
			case R.id.radio1:
//				tv1.setTag("Verde");
				tv1.setTextColor(Color.GREEN);
				break;
			case R.id.radio2:
//				tv1.setTag("Azul");
				tv1.setTextColor(Color.BLUE);
				break;
			case R.id.radio3:
//				tv1.setTag("Amarillo");
				tv1.setTextColor(Color.YELLOW);
				break;
			default:
				break;
        }
           
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
