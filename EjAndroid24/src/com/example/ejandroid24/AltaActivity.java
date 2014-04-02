package com.example.ejandroid24;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import core.BaseDatosHelper;

public class AltaActivity extends Activity {

	private EditText  codigo,nombre;  
	private TextView  resultado;
	SQLiteDatabase db=null;
	
	@Override    
	public void onCreate(Bundle savedInstanceState){         
		super.onCreate(savedInstanceState);         
		setContentView(R.layout.alta);           
		this.codigo = (EditText) findViewById(R.id.txtCodigo);
		this.nombre = (EditText) findViewById(R.id.txtNombre); 
		this.resultado = (TextView) findViewById(R.id.tvResultado); 
	} 
		
	public void Alta(View view) {  
		BaseDatosHelper usdbh = new BaseDatosHelper(this, "DBUsuarios", null, 1);
		//Abrimos la base de datos 'DBUsuarios' en modo escritura         
		db= usdbh.getWritableDatabase();          

		ContentValues nuevoRegistro = new ContentValues();
		nuevoRegistro.put("codigo", codigo.getText().toString());
		nuevoRegistro.put("nombre",nombre.getText().toString()); 
		//Insertamos el registro en la base de datos
		db.insert("Usuarios", null, nuevoRegistro);
		//El segundo parámetro lo obviaremos por el momento ya que tan sólo se 
		//hace necesario en casos muy puntuales 
		//(por ejemplo para poder insertar registros completamente vacíos)
		this.resultado.setText("ALTA CORRECTA"); 
				
		//Cerramos la base de datos            
		//db.close();  
	}
	
	public void cerrar(View view) {
		finish();
	}

}
