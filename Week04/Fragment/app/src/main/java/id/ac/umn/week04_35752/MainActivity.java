package id.ac.umn.week04_35752;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText nama;
    private Button btnHalaman1, btnHalaman2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnHalaman1 = findViewById(R.id.main_button_change_1);
        btnHalaman2 = findViewById(R.id.main_button_change_2);

        btnHalaman1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHal1 = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intentHal1);
            }
        });

        btnHalaman2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHal2 = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intentHal2);
            }
        });

    }
}