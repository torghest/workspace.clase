package com.example.ejandroid24;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import core.BaseDatosHelper;

public class MainActivity extends Activity {
	
	SQLiteDatabase db = null;
	private RadioButton rCons;
	private RadioButton rAlta;
	private RadioButton rElim;
	private RadioButton rModi;
	private RadioGroup rAccion;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		rCons=(RadioButton)findViewById(R.id.rdConsultas);
        rAlta=(RadioButton)findViewById(R.id.rdAlta);
        rElim=(RadioButton)findViewById(R.id.rdEliminar);
        rModi=(RadioButton)findViewById(R.id.rdModificar);
        rAccion=(RadioGroup)findViewById(R.id.rgAccion);
	}
	
	public void crearBd(View view) {  
		BaseDatosHelper usdbh = new BaseDatosHelper(this, "DBUsuarios", null, 1);
//		Abrimos la base de datos 'DBUsuarios' en modo escritura         
		db= usdbh.getWritableDatabase();          
//		Si hemos abierto correctamente la base de datos         
		if(db != null){            
//			Insertamos 5 usuarios de ejemplo             
			for(int i=1; i<=5; i++){                
//				Generamos los datos                 
				int codigo = i;                
				String nombre = "Usuario" + i;                  
//				Insertamos los datos en la tabla Usuarios                 
				db.execSQL("INSERT INTO Usuarios (codigo, nombre) " +                           
				"VALUES (" + codigo + ", '" + nombre +"')");            
			}              
			System.out.println("INSERTADO!!!!");
//			Cerramos la base de datos            
//			db.close();  
		}
	}
	
	public void mostrarLayout(View view) {
    	int radioseleccionado = rAccion.getCheckedRadioButtonId();
		switch (radioseleccionado) {
			case R.id.rdConsultas:
				Intent i = new Intent(this, ConsultasActivity.class );
				startActivity(i);
				break;
			case R.id.rdAlta:
				Intent i2 = new Intent(this, AltaActivity.class );
				startActivity(i2);
				break;
			case R.id.rdEliminar:
				Intent i3 = new Intent(this, EliminarActivity.class );
				startActivity(i3);
				break;
			case R.id.rdModificar:
				Intent i4 = new Intent(this, ModificarActivity.class );
				startActivity(i4);
				break;
			default:
				break;
		}  
	}

}
