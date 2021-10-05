package id.ac.umn.sfxlibraryandpreviewer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    private Button btnLogin;
    private EditText inputLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        //Back Button
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        btnLogin = findViewById(R.id.btnLogin);
        inputLogin = findViewById(R.id.inputLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(inputLogin.getText().toString())) {
                    inputLogin.setError("Harap Diisi!");
                } else {
                    Intent intentLogin = new Intent(LoginPage.this, SFXLibrary.class);
                    intentLogin.putExtra("nama", inputLogin.getText().toString());
                    startActivity(intentLogin);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        //Alert Dialog
        Intent intentBack = new Intent(LoginPage.this, MainActivity.class);
        startActivity(intentBack);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}