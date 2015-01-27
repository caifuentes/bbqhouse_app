package me.smoov.bbqhouse;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;

public class BackgroundForNoInternet extends Activity{
	
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        
        alertDialogBuilder.setTitle("Cannot connect to BBQ House");
			alertDialogBuilder
				.setMessage("Please make sure your network connection is active and try again.")
				.setCancelable(false)
				.setPositiveButton("Okay",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, close
						// current activity
						dialog.cancel();
						BackgroundForNoInternet.this.finish();
					}
				  });
 
				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();
 
				// show it
				alertDialog.show();
	}
}
