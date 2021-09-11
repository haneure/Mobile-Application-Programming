package id.ac.umn.week04_35752;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView tvtulisan;
    private Button btnGantiTulisan;
    private EditText etTulisan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnGantiTulisan = findViewById(R.id.fragment_first_button_berubah);
        etTulisan = findViewById(R.id.fragment_first_edittext_tulisan);
        tvtulisan = findViewById(R.id.fragment_second_textview_tulisan);

        btnGantiTulisan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputTulisan = etTulisan.getText().toString();
                tvtulisan.setText(inputTulisan);
            }
        });
    }
}