package com.example.ejandroid23;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void toastNormal(View view){
		Toast mensaje = Toast.makeText(
				getApplicationContext(),
				"Mensaje Toast Normal",
				Toast.LENGTH_SHORT
		);
		mensaje.show();	
	}
	
	public void toastPosicionado(View view){
		Toast mensaje = Toast.makeText(
				getApplicationContext(),
				"Mensaje Toast Normal",
				Toast.LENGTH_SHORT
		);
		mensaje.setGravity(Gravity.TOP|Gravity.RIGHT, 0, 0);
		mensaje.show();
	}

	public void toastPersonalizado(View view){
		Toast mensaje = new Toast(getApplicationContext());
		LayoutInflater inflater = getLayoutInflater();
		View layout = inflater.inflate(R.layout.capa_toast,
				 (ViewGroup) findViewById(R.id.toastLayout));
		TextView txtMsg = (TextView)layout.findViewById(R.id.txMensaje);
        txtMsg.setText("Toast Personalizado Icono");
 
        mensaje.setDuration(Toast.LENGTH_LONG);
        mensaje.setView(layout);
        mensaje.show();
	}
}
