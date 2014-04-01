package com.example.propuestoandroid1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	private Spinner spCurso;
	private EditText edNombre;
	private EditText edApellido;
	private EditText edTelefono;
	private RadioGroup rdHorario;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		spCurso = (Spinner)findViewById(R.id.spCurso);
		edNombre = (EditText)findViewById(R.id.edNombre);
		edApellido = (EditText)findViewById(R.id.edApellido);
		edTelefono = (EditText)findViewById(R.id.edTelefono);
		rdHorario = (RadioGroup)findViewById(R.id.rdHorario);
		// Rellenar el Combo
		String[] opciones = getResources().getStringArray(R.array.datCurso);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, opciones);
		spCurso.setAdapter(adapter);
	}
	
	public void enviar(View view){
		String curso = spCurso.getSelectedItem().toString();
		Intent i = new Intent(this, Ventana2Activity.class);
		// Cargar parametros
		i.putExtra("curso", curso);
		i.putExtra("nombre", edNombre.getText().toString());
		i.putExtra("apellido", edApellido.getText().toString());
		i.putExtra("telefono", edTelefono.getText().toString());
		i.putExtra("horario", ((RadioButton)findViewById(rdHorario.getCheckedRadioButtonId())).getText().toString());
		// Lanzar Ventana2
		startActivity(i);
	}
}
