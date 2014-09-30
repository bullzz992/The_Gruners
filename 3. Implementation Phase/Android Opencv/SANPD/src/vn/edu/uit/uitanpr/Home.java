package vn.edu.uit.uitanpr;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Home extends Activity implements OnClickListener
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
        Intent i = new Intent(this, Detect.class);
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

