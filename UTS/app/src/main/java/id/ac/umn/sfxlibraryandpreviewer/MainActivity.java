package id.ac.umn.sfxlibraryandpreviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnProfile, btnLibrary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnProfile = findViewById(R.id.btnProfile);
        btnLibrary = findViewById(R.id.btnLibrary);

        btnLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLibrary = new Intent(MainActivity.this, LoginPage.class);
                startActivity(intentLibrary);
            }
        });

    }
}