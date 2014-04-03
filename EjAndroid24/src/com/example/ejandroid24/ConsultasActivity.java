package com.example.ejandroid24;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import core.BaseDatosHelper;

public class ConsultasActivity extends Activity {

	private EditText  nombre;  
	private TextView  resultado;
	SQLiteDatabase db = null;
	
	@Override    
	public void onCreate(Bundle savedInstanceState)     
	{         
		super.onCreate(savedInstanceState);         
		setContentView(R.layout.consultas);           
		this.resultado = (TextView) findViewById(R.id.textView1);
		this.nombre = (EditText) findViewById(R.id.EditText01); 
	}
		
	public void recuperarDatos(View view) { 
		try {
			String[] args = new String[] {nombre.getText().toString()}; 
			String codigo="";
			String nombre="";
			BaseDatosHelper usdbh = new BaseDatosHelper(this, this.getResources().getString(R.string.dataBase), null, 1);

			SQLiteDatabase db = usdbh.getReadableDatabase(); 
			Cursor c = db.rawQuery("SELECT codigo,nombre FROM Usuarios where nombre=?",args); 
//			Nos aseguramos de que existe al menos un registro 
			if (c.moveToFirst()) {      
//				Recorremos el cursor hasta que no haya más registros      
				do {           
					codigo = c.getString(0);
					nombre = c.getString(1);      
				} while(c.moveToNext()); 
			}
			this.resultado.setText("Código usuario:"+ codigo);  
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void cerrar(View view) {
		finish();
	}


}
