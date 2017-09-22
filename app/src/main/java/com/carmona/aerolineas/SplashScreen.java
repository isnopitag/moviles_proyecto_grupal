package com.carmona.aerolineas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashScreen extends AppCompatActivity {

    @BindView(R.id.imgLogo)
    ImageView imgLogo;

    @BindView(R.id.pgbHilo)
    ProgressBar pgbHilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ButterKnife.bind(this);
        new Hilo(pgbHilo);
    }

    @OnClick(R.id.imgLogo)
    public void accionClick(){
        Intent intLogin = new Intent(this,Login.class);
        startActivity(intLogin);
    }
}
