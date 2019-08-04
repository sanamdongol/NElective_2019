package com.example.day6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvBlinkAnim;
    private TextView tvFade;
    private TextView tvZoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnBlink = findViewById(R.id.btn_blink);
        Button btnFade = findViewById(R.id.btn_fade);
        Button btnZoom = findViewById(R.id.btn_zoom);
        Button btnNextPage = findViewById(R.id.btn_next_page);


        tvBlinkAnim = findViewById(R.id.tv_blink_anim);
        tvFade = findViewById(R.id.tv_fade);
        tvZoom = findViewById(R.id.tv_zoom);

        btnBlink.setOnClickListener(this);
        btnZoom.setOnClickListener(this);
        btnFade.setOnClickListener(this);

        /*btnBlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation blinkAnim =
                        AnimationUtils.loadAnimation
                                (getApplicationContext(),
                                        R.anim.anim_blink);
                tvBlinkAnim.startAnimation(blinkAnim);

            }
        });
*/

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_blink:
                loadAnimation(tvBlinkAnim, R.anim.anim_blink);
                break;
            case R.id.btn_fade:
                loadAnimation(tvFade, R.anim.anim_fade_in);
                break;
            case R.id.btn_zoom:
                loadAnimation(tvZoom, R.anim.anim_zoom);
                break;
            case R.id.btn_next_page:
                Intent intent = new Intent(AnimationActivity.this, SharedActivity.class);
                startActivity(intent);
                break;

        }
    }

    private void loadAnimation(TextView textView, int animRes) {
        Animation blinkAnim = AnimationUtils.loadAnimation
                (getApplicationContext(),
                        animRes);
        textView.startAnimation(blinkAnim);
    }
}
