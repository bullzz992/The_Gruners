/*==============================================================================
Copyright (c) 2013 QUALCOMM Austria Research Center GmbH.
All Rights Reserved.

@file
    AboutScreen.java

@brief
    About Screen Activity for the TextReco sample application

==============================================================================*/

package com.qualcomm.QCARSamples.TextReco;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.qualcomm.QCARSamples.TextReco.R;
import com.qualcomm.vn.edu.uit.uitanpr.MainActivity;
public class AboutScreen extends Activity implements OnClickListener
{
    private Button mStartButton;
    private Button mHistory;


    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        

        mStartButton = (Button) findViewById(R.id.btnCapture);
        mStartButton.setOnClickListener(this);
        
        mHistory = (Button) findViewById(R.id.btnHelp);
        mHistory.setOnClickListener(this);
    }


    /** Starts the TextReco main activity */
    private void startARActivity()
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    private void startHistory()
    {
        Intent i = new Intent(this, History.class);
        startActivity(i);
    }


    public void onClick(View v)
    {
    	if(R.id.btnCapture==v.getId()){
    		startARActivity();
    	}
    	if(R.id.btnHelp==v.getId())
    	{
    		startHistory();
    	}
    }
}
