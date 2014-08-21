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

public class AboutScreen extends Activity implements OnClickListener
{
    private Button mStartButton;


    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        

        mStartButton = (Button) findViewById(R.id.btnCapture);
        mStartButton.setOnClickListener(this);
    }


    /** Starts the TextReco main activity */
    private void startARActivity()
    {
        Intent i = new Intent(this, TextReco.class);
        startActivity(i);
    }


    public void onClick(View v)
    {
        switch (v.getId())
        {
        case R.id.btnCapture:
            startARActivity();
            break;
        }
    }
}
