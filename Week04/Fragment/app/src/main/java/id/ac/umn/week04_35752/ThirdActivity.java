package id.ac.umn.week04_35752;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
//    private TextView tvtulisans;
//    private Button btnGantiTulisans;
//    private EditText etTulisans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment firstFragment = new FirstFragment();
        fragmentTransaction.replace(R.id.third_activity_fragment_1, firstFragment);

        Fragment secondFragment = new SecondFragment();
        fragmentTransaction.replace(R.id.third_activity_fragment_2, secondFragment);
        fragmentTransaction.commit();

//        btnGantiTulisans = findViewById(R.id.fragment_first_button_berubah);
//        etTulisans = findViewById(R.id.fragment_first_edittext_tulisan);
//        tvtulisans = findViewById(R.id.fragment_second_textview_tulisan);
//
//        btnGantiTulisans.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String inputTulisan = etTulisans.getText().toString();
//                tvtulisans.setText(inputTulisan);
//            }
//        });

    }
}