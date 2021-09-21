package id.ac.umn.week06_35752;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnProperty, btnUma, btnPhysics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProperty = findViewById(R.id.property);
        btnUma = findViewById(R.id.uma);
        btnPhysics = findViewById(R.id.physics);

        btnProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProperty = new Intent(MainActivity.this, Property.class);
                startActivity(intentProperty);
            }
        });

        btnUma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intentUma = new Intent(MainActivity.this, Drawables.class);
                startActivity(intentUma);
            }
        });

        btnPhysics.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intentPhysics = new Intent(MainActivity.this, Physics.class);
                startActivity(intentPhysics);
            }
        });
    }
}
