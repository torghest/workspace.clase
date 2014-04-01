package com.example.propuestoandroid1;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class Ventana2Activity extends Activity {

	private TextView txtResul;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ventana2);
		txtResul=(TextView)findViewById(R.id.txtResult);
		// Recogemos los parámetros enviados por el primer Activity  a través del método getExtras 
		Bundle bundle = getIntent().getExtras();
		String nombre = bundle.getString("nombre");
		String apellido = bundle.getString("apellido");
		String telefono = bundle.getString("telefono");
		String curso = bundle.getString("curso");
		String horario = bundle.getString("horario");
		txtResul.setText(
				Html.fromHtml(
						"<p><h3>Registro Usuario:</h3></p>" +
						nombre + "<br/>" +
						apellido + "<br/>" +
						telefono + "<br/>" +
						curso + "<br/>" +
						horario
				), BufferType.SPANNABLE
		);
	}
	
	public void cerrar(View view) {
		finish();	
    }

}
