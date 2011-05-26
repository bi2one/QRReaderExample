package com.example.android.qr;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.content.Intent;

import com.example.android.qr.qrutil.IntentResult;
import com.example.android.qr.qrutil.IntentIntegrator;

public class QRScanActivity extends Activity
{
    private IntentResult qrResult;
    private AlertDialog qrDialog;
    
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
	qrDialog = IntentIntegrator.initiateScan(this);
    }

    protected void onResume() {
	super.onResume();
	if (qrDialog != null)
	    qrDialog.show();
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	qrResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
	if (qrResult.getContents() != null) {
	    Log.d("=======", qrResult.getContents());
	}
    }    
}
