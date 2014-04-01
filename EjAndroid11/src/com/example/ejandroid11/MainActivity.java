package com.example.ejandroid11;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText edUrl;
	private WebView webView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		edUrl = (EditText)findViewById(R.id.edUrl);
		webView = (WebView)findViewById(R.id.webView);
	}

	public void mostrar(View view){
		webView.loadUrl("http://"+edUrl.getText());
		webView.setWebViewClient(new mostrarEnAplicacion());
	}
	
	public void volver(View view){
		webView.goBack();
	}
	
	private class mostrarEnAplicacion extends WebViewClient{
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
		
	}
	
}
