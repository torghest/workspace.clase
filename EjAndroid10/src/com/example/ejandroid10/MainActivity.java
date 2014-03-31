package com.example.ejandroid10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	private EditText edNombre;
	private EditText edApellido;
	private EditText edFxNacimiento;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		edNombre = (EditText)findViewById(R.id.edNombre);
		edApellido = (EditText)findViewById(R.id.edApellido);
		edFxNacimiento = (EditText)findViewById(R.id.edFxNacimiento);
	}
	
	public void mostrar(View view){
		Intent i = new Intent(this, Ventana2Activity.class);
		// Añadimos los parametros
		i.putExtra("nombre", edNombre.getText().toString());
		i.putExtra("apellido", edApellido.getText().toString());
		i.putExtra("fxNacimiento", edFxNacimiento.getText().toString());
		// Lanzamos la ventana
		startActivity(i);
	}

}
