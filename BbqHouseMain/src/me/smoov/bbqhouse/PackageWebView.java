package me.smoov.bbqhouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PackageWebView extends Activity {
	
	WebView webView;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.package_webview);
        
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
				   Intent intent = new Intent(PackageWebView.this, BackgroundForNoInternet.class);
				   startActivity(intent);				   

				   try {
                       webView.stopLoading();
                   } catch (Exception e) {
                   }
                   try {
                       webView.clearView();
                   } catch (Exception e) {
                   }
                   if (webView.canGoBack()) {
                       webView.goBack();
                   }
                   webView.loadUrl("about:blank");
                   
                   super.onReceivedError(webView, errorCode, description, failingUrl);
			   }
			 });
		webView.loadUrl("http://m.bbqhouse.com.sg/package_type.php");
	}
}
