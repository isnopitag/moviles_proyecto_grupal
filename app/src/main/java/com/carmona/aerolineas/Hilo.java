package com.carmona.aerolineas;

import android.os.AsyncTask;
import android.widget.ProgressBar;

/**
 * Created by carmona on 20/09/17.
 */

public class Hilo extends AsyncTask<Void,Float,Void> {

    private ProgressBar pgbHilo;

    public Hilo(ProgressBar pgbHilo){

    }
    @Override
    protected Void doInBackground(Void... params) {
        try {
            for (int i=1; i<=3; i++){
                Thread.sleep(1000);
                publishProgress(i*33f);
            }
        }catch (InterruptedException e){}
        return null;
    }

    @Override
    protected void onProgressUpdate(Float... values) {
        super.onProgressUpdate(values);
        pgbHilo.setProgress(values[0].intValue());
    }
}
