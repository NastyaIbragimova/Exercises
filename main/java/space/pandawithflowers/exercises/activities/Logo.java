package space.pandawithflowers.exercises.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import space.pandawithflowers.exercises.R;

public class Logo extends AppCompatActivity {

    private Animation logoAnim, buttonLogoAnim;
    private Button start;
    private ImageView logotip;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_activity);
        init();
        startMainActivity();
    }

    public void onClickStart(View view) {
        Intent intent = new Intent(Logo.this, MainActivity.class);
        startActivity(intent);
    }

    private void init() {
        logoAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo_anim);
        buttonLogoAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_anim);
        start = findViewById(R.id.buttonStart);
        logotip = findViewById(R.id.ivLogo);
        logotip.startAnimation(logoAnim);
        start.startAnimation(buttonLogoAnim);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    private void startMainActivity(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                Intent intent = new Intent(Logo.this, MainActivity.class);
                startActivity(intent);
            }
        });
        thread.start();

    }
}
