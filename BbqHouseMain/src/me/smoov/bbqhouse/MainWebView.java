package me.smoov.bbqhouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainWebView extends Activity {
	
	private WebView webView;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main_webview);
        
        webView = (WebView) findViewById(R.id.webView);
        webView.setVerticalScrollBarEnabled(false);
        webView.setWebViewClient(new WebViewClient());
		webView.getSettings().setJavaScriptEnabled(true);
		
		webView.setWebChromeClient(new WebChromeClient() {
			@Override public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
				return super.onJsAlert(view, url, message, result); 
				} 
			}); 
		
		webView.setWebViewClient(new WebViewClient() {
			   public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
//				   Intent intent = new Intent(MainWebView.this, BackgroundForNoInternet.class);
				   				   
				   try {
                       webView.stopLoading();
                   } catch (Exception e) {
                   }
                   try {
                       webView.clearView();
                   } catch (Exception e) {
                   }
//                   if (webView.canGoBack()) {
//                       webView.goBack();
//                   }
                   webView.loadUrl("about:blank");
                   
//                   super.onReceivedError(webView, errorCode, description, failingUrl);
//                   startActivity(intent);
               				   
			   }
			 });
		webView.loadUrl("http://m.bbqhouse.com.sg/index.php");
	}

}
