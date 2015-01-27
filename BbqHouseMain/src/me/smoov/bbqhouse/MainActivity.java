package me.smoov.bbqhouse;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabHost.OnTabChangeListener;

public class MainActivity extends TabActivity implements OnTabChangeListener{
	TabHost tabHost;
	
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
				
		setContentView(R.layout.main);
		
		Resources ressources = getResources(); 
		tabHost = getTabHost();
		tabHost.setOnTabChangedListener(this);
 
		// AlaCarte tab
		Intent intentAlaCarte = new Intent().setClass(this, AlaCarteWebView.class)
				.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		TabSpec tabAlaCarte = tabHost
		  .newTabSpec("AlaCarte")
		  .setIndicator("", ressources.getDrawable(R.drawable.nav_alacarte))
		  
		  .setContent(intentAlaCarte);
 
		// Package tab
		Intent intentPackage = new Intent().setClass(this, PackageWebView.class)
				.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		TabSpec tabPackage = tabHost
		  .newTabSpec("Package")
		  .setIndicator("", ressources.getDrawable(R.drawable.nav_package))
		  .setContent(intentPackage);
 
		// Delivery tab
		Intent intentDelivery = new Intent().setClass(this, DeliveryWebView.class)
				.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		TabSpec tabDelivery = tabHost
		  .newTabSpec("Delivery")
		  .setIndicator("", ressources.getDrawable(R.drawable.nav_delivery))
		  .setContent(intentDelivery);
 
		// AboutUs tab
		Intent intentAboutUs = new Intent().setClass(this, AboutUsWebView.class)
				.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		TabSpec tabAboutUs = tabHost
		  .newTabSpec("AboutUs")
		  .setIndicator("", ressources.getDrawable(R.drawable.nav_aboutus))
		  .setContent(intentAboutUs);
		
		// ContactUs tab
		Intent intentContactUs = new Intent().setClass(this, ContactUsWebView.class)
				.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		TabSpec tabContactUs = tabHost
			.newTabSpec("ContactUs")
			.setIndicator("", ressources.getDrawable(R.drawable.nav_contactus))
			.setContent(intentContactUs);
		
		// Main tab
		Intent intentMainView = new Intent().setClass(this, MainWebView.class)
				.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		TabSpec tabMain = tabHost
			.newTabSpec("MainView")
			.setIndicator("", ressources.getDrawable(R.drawable.nav_contactus))
			.setContent(intentMainView);
 		
		
		// add all tabs 
		tabHost.addTab(tabAlaCarte);
		tabHost.addTab(tabPackage);
		tabHost.addTab(tabDelivery);
		tabHost.addTab(tabAboutUs);
		tabHost.addTab(tabContactUs);
		tabHost.addTab(tabMain);
 
		tabHost.getTabWidget().setDividerDrawable(null);
		tabHost.setCurrentTab(5);
		tabHost.getTabWidget().getChildTabViewAt(5).setVisibility(View.GONE);
		
}

	@Override
	public void onTabChanged(String arg0) {
		for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
		{
			tabHost.getTabWidget().getChildAt(i).setPadding(0, 0, 0, 7);
			tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#500700"));
		}
		tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).
		setBackgroundDrawable(getResources().getDrawable(R.drawable.nav_line));  
	}
}
