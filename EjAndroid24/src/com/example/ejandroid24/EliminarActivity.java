package com.example.ejandroid24;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import core.BaseDatosHelper;

public class EliminarActivity extends Activity {

	private EditText  nombre;  
	private TextView  resultado;
	SQLiteDatabase db=null;

	@Override    
	public void onCreate(Bundle savedInstanceState){         
		super.onCreate(savedInstanceState);         
		setContentView(R.layout.eliminar);           
		this.resultado = (TextView) findViewById(R.id.txtBorrado);
		this.nombre = (EditText) findViewById(R.id.txtNombreBorrar); 
	} 

	public void BorrarBD(View view) { 
		try {
			BaseDatosHelper usdbh = new BaseDatosHelper(this, this.getResources().getString(R.string.dataBase), null, 1);
			//Abrimos la base de datos 'DBUsuarios' en modo escritura         
			db= usdbh.getWritableDatabase();          
             
			//Como vemos, volvemos a pasar como primer parámetro el nombre de la tabla y 
			//en segundo lugar la condición WHERE. Por supuesto, 
			//si no necesitáramos ninguna condición, podríamos dejar como null en este parámetro.
			 
			db.delete("Usuarios", "nombre=?",new String[] { nombre.getText().toString() });  
			this.resultado.setText("BORRADO CON ÉXITO"); 
		} catch(Exception e){
			System.out.println(e.toString());
		}
	}

	public void cerrar(View view) {
		finish();
	}

}
