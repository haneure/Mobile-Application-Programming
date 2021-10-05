package id.ac.umn.sfxlibraryandpreviewer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class SFXLibrary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfxlibrary);

        //Tombol Back
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Get Intent String Extra
        Intent loginIntent = getIntent();
        String inputLogin = loginIntent.getStringExtra("nama");
        //Set title
        setTitle(inputLogin);
        //Toast
        Toast.makeText(SFXLibrary.this, "Selamat datang, " + inputLogin, Toast.LENGTH_SHORT).show();
        //RecyclerView



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
        //Alert Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(SFXLibrary.this);

        builder.setCancelable(true);
        builder.setTitle("Kamu yakin untuk logout?");
        builder.setMessage("See you soon!");

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intentLogout = new Intent(SFXLibrary.this, LoginPage.class);
                intentLogout.removeExtra("nama");
                startActivity(intentLogout);
            }
        });
        builder.show();
    }
}