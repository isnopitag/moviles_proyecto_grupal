package com.carmona.aerolineas;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.ProgressBar;

/**
 * Created by carmona on 20/09/17.
 */

public class Hilo extends AsyncTask<Void,Float,Void> {

    private ProgressBar pgbHilo;
    private Context con;

    public Hilo(ProgressBar pgbHilo, Context con){
        this.pgbHilo = pgbHilo;
        this.con = con;
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

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Intent intlogin = new Intent(con,Login.class);
        con.startActivity(intlogin);
        con.
    }
}
