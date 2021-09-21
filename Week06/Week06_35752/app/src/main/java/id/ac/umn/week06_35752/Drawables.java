package id.ac.umn.week06_35752;
import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FlingAnimation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

public class Drawables extends AppCompatActivity {
    AnimationDrawable animasiKuda;
    ImageView gambarKuda;
    ImageView umamusume;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawables);

        gambarKuda = (ImageView) findViewById(R.id.gambarKuda);
        gambarKuda.setBackgroundResource(R.drawable.kuda_lari);
        animasiKuda = (AnimationDrawable) gambarKuda.getBackground();
        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this, R.raw.umapyoi);
            mediaPlayer.setLooping(true);
        }

        umamusume = (ImageView) findViewById(R.id.umamusume);
        FlingAnimation fling = new FlingAnimation(umamusume, DynamicAnimation.ROTATION_Y);

        ObjectAnimator animation = ObjectAnimator.ofFloat(umamusume, "rotationY", 0.0f, 360f);
        animation.setDuration(1000);
        animation.setRepeatMode(ValueAnimator.RESTART);
        animation.setRepeatCount(ObjectAnimator.INFINITE);
        animation.setInterpolator(null);


        new CountDownTimer(5000, 1000) {
            int flag = 0;
            @Override
            public void onTick(long l) {
            }

            public void onFinish() {
                animation.setDuration(250);
                start();
            }
        }.start();

        gambarKuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    animasiKuda.stop();
                    umamusume.setBackgroundResource(0);
                } else {
                    mediaPlayer.start();
                    animasiKuda.start();
                    umamusume.setBackgroundResource(R.drawable.umamusume);
                    animation.start();
                }

            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}