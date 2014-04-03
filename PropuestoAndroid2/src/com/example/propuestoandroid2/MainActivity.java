package com.example.propuestoandroid2;

import core.BaseDatosHelper;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private SQLiteDatabase db;
	private Spinner spNombre;
	private EditText etCodigo;
	private TextView tvBD;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		spNombre = (Spinner)findViewById(R.id.spNombre);
		etCodigo = (EditText)findViewById(R.id.etCodigo);
		tvBD = (TextView)findViewById(R.id.tvBD);
		BaseDatosHelper sqloh = new BaseDatosHelper(this,this.getResources().getString(R.string.dataBase),null,1);
		db = sqloh.getReadableDatabase();
		tvBD.setText("#DBpath: "+db.getPath()+"#PkgCodePath"+this.getPackageCodePath()+"#PkgResPath"+this.getPackageResourcePath());
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this,android.R.layout.simple_spinner_item, cargarCombo());
		spNombre.setAdapter(adapter);
	}
	
	private String[] cargarCombo(){
		Cursor c = db.rawQuery("SELECT nombre FROM Usuarios", null);
		int filas = c.getCount();
		System.out.println(filas);
		String[] res = new String[filas];
		c.moveToFirst();
		for (int i = 0; i < filas; i++){
			res[i] = c.getString(0);
			c.moveToNext();
		}
		return res;
	}
	
	public void consultarCodigo(View view){
		String[] args = {spNombre.getSelectedItem().toString()};
		Cursor c = db.rawQuery("SELECT codigo FROM Usuarios WHERE nombre = ?", args);
		c.moveToFirst();
		etCodigo.setText(c.getString(0));
	}

}
