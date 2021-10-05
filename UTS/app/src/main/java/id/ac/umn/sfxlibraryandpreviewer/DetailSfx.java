package id.ac.umn.sfxlibraryandpreviewer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class DetailSfx extends AppCompatActivity {
    private ImageView imgView;
    private TextView etJudul;
    private TextView etKeterangan;
    private Button btnKembali;
    private ImageButton playSfx;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sfx);

        etJudul = findViewById(R.id.sfxDetailJudul);
        etKeterangan =  findViewById(R.id.sfxDetailKeterangan);
        playSfx = findViewById(R.id.playSfx);
        imgView = findViewById(R.id.sfxDetailImg);

        //Tombol Back
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        SumberSfx ss = (SumberSfx) bundle.getSerializable("DetailSfx");
        etJudul.setText(ss.getJudul());
        etKeterangan.setText(ss.getKeterangan());
        setTitle(ss.getJudul());

        ObjectAnimator animation = ObjectAnimator.ofFloat(imgView, "rotation", 0.0f, 360f);
        animation.setDuration(5000);
        animation.setRepeatMode(ValueAnimator.RESTART);
        animation.setRepeatCount(ObjectAnimator.INFINITE);
        animation.setInterpolator(null);

        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this, Uri.parse(ss.getSfxURI()));
            mediaPlayer.setLooping(true);
        }

        playSfx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    animation.pause();
                    playSfx.setImageResource(R.drawable.play);
                } else {
                    mediaPlayer.start();
                    animation.start();
                    playSfx.setImageResource(R.drawable.pause);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        mediaPlayer.release();
        this.finish();
    }

}