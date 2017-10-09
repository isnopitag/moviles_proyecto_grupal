package com.carmona.aerolineas;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashScreen extends AppCompatActivity {

    MediaPlayer reproductor;
    static int pos = 0;
    Hilo objHilo;

    @BindView(R.id.imgLogo)
    ImageView imgLogo;

    @BindView(R.id.pgbHilo)
    ProgressBar pgbHilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);



        ButterKnife.bind(this);
        //new Hilo(pgbHilo,this).execute();
        objHilo = new Hilo(pgbHilo,this);
        objHilo.execute();
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        reproductor = MediaPlayer.create(this,R.raw.still);
        reproductor.seekTo(pos);
        reproductor.start();
        reproductor.setLooping(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        pos = reproductor.getCurrentPosition();
        reproductor.release();
        objHilo.cancel(true);
        this.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @OnClick(R.id.imgLogo)
    public void accionClick(){
        Intent intLogin = new Intent(this,Login.class);
        startActivity(intLogin);
    }
}
