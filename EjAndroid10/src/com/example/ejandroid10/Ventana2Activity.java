package com.example.ejandroid10;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class Ventana2Activity extends Activity {

	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ventana2);
		tv = (TextView)findViewById(R.id.txtRegistro);
		// Recogemos los parametros
		Bundle b = getIntent().getExtras();
		String nombre = b.getString("nombre");
		String apellido = b.getString("apellido");
		String fxNacimiento = b.getString("fxNacimiento");
		// Rellenamos los datos en el TextView
		tv.setText(
				Html.fromHtml(
						"<p><h3>Registro Usuario:</h3></p>" +
						nombre + "<br/>" +
						apellido + "<br/>" +
						fxNacimiento
				),
				BufferType.SPANNABLE
		);
	}
	
	public void cerrar(View view){
		finish();
	}
	
}
