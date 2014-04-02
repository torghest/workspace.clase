package com.example.ejandroid25;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class MainActivity extends Activity {

	static final String SOAPACTION = "http://tempuri.org/Calcular";
    private static final String METHOD = "Calcular";
    private static final String NAMESPACE = "http://tempuri.org/";
    private static final String URL = "http://172.16.1.97/bbdd_ws/Service.asmx";

    TextView tv1;
	EditText et1;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		tv1=(TextView)findViewById(R.id.textView2);  
		et1=(EditText)findViewById(R.id.editText1); 
	}
  
	public void ConsumirServicio(View  v){
		try {
	/*Lo recomendado es crear esa tarea en un subproceso o hilo secundario, no obstante, si necesitáis hacerlo a la fuerza, se puede establecer un cambio en las políticas de restricciones de Android para nuestra clase (repito, no es recomendable). 
	Lo único que habría que hacer es insertar estas dos líneas de código en el onCreate() de nuestra clase principal, y Android se tragará cualquier acceso a red que hagamos en el Main Thread, sin rechistar
	 */
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitNetwork().build();
			StrictMode.setThreadPolicy(policy);
			
			String resultadoFINAL;
			//Creacion de la Solicitud
			SoapObject request = new SoapObject(NAMESPACE, METHOD);
			//Creacion del Envelope
			SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			sobre.dotNet = true;
			sobre.setOutputSoapObject(request);
			//Creacion del transporte
			HttpTransportSE transporte = new HttpTransportSE(URL);
			
			// Paso de parámetro
			PropertyInfo Nombre = new PropertyInfo();
			Nombre.setName("dato");
			Nombre.setValue(et1.getText().toString());
			Nombre.setType(String.class);
			request.addProperty(Nombre);
			
			//Llamada
			transporte.call(SOAPACTION, sobre);
			
			//Resultado
			SoapPrimitive resultado = (SoapPrimitive) sobre.getResponse();
			resultadoFINAL = "Día de la semana: "+resultado.toString();
			tv1.setText(resultadoFINAL);
			
		} catch (Exception e) {
			tv1.setText(e.toString());
		}
		
	}

}
