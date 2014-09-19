package com.qualcomm.QCARSamples.TextReco;

import android.app.Application;

public class databaseApplication extends Application {

    /**
     * see NotePad tutorial for an example implementation of DataDbAdapter
     */
    private static DatabaseHandler mDbHelper;

    /**
     * create the database helper when the application is launched 
     */
    @Override
    public void onCreate() {
        mDbHelper = new DatabaseHandler(this);
    }

    /** 
     * close the database helper when the application terminates.
     */
    @Override
    public void onTerminate() {
        mDbHelper.close();
        mDbHelper = null;
    }

    public static DatabaseHandler getDatabaseHelper() {
        return mDbHelper;
    }
}