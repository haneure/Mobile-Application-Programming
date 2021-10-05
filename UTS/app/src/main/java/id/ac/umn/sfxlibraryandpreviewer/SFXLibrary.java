package id.ac.umn.sfxlibraryandpreviewer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class SFXLibrary extends AppCompatActivity {

    RecyclerView rvDaftarSfx;
    DaftarSfxAdapter mAdapter;
    LinkedList<SumberSfx> daftarSfx =new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfxlibrary);
        isiDaftarSfx();
        rvDaftarSfx = (RecyclerView)findViewById(R.id.recyclerView);
        mAdapter= new DaftarSfxAdapter(this, daftarSfx);
        rvDaftarSfx.setAdapter(mAdapter);
        rvDaftarSfx.setLayoutManager(new LinearLayoutManager(this));

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
    }

    public void isiDaftarSfx(){
        daftarSfx.add(new SumberSfx("Sheesh but beautiful",
                "Sheeeeeeeeeeeeeeeeeeeeeeeeeesh",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.sheeeesh));
        daftarSfx.add(new SumberSfx("Umapyoi Densetsu",
                "zukyun dokyun hashirideshi, bakyun bukyun kakete yuku yo, konna reesuu wa hajimete~",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.umapyoi));
        daftarSfx.add(new SumberSfx("Nijisanji ID- (Hana Macchia) Apue!",
                "Apue",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.apue));
        daftarSfx.add(new SumberSfx("Re.Zero: Whoaaayeeeaaayaaai~",
                "Whoaaayeeeaaayaaai!",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.whoaaayeeeaaayaaai));
        daftarSfx.add(new SumberSfx("AH↓HA↑HA↑HA↑HA↑",
                "AH↓HA↑HA↑HA↑HA↑AH↓HA↑HA↑HA↑HA↑AH↓HA↑HA↑HA↑HA↑",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.usadapekora));
        daftarSfx.add(new SumberSfx("PE↗️ KO↘️ PE↗️ KO↘️ PE↗️ KO↘️ PE ↗️ KO↘️\n",
                "PEKOPEKOPEKOPEKOPEKO",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.usadapekopekopeko));
        daftarSfx.add(new SumberSfx("Houshou Marine - Ahoy",
                "Ahoy!",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.houshoumarineahoy));
        daftarSfx.add(new SumberSfx("Everyone - Ahoy",
                "Ahoy",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.ahoy));
        daftarSfx.add(new SumberSfx("Shirakami Fubuki - Yabe",
                "Yabbe",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.yabe));
        daftarSfx.add(new SumberSfx("Pekora HOREE SHIIT",
                "Holy Sh*t",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.pekorahoreeshiit));
        daftarSfx.add(new SumberSfx("PekoOnetoucchi",
                "Ecchi Sukecchi Wantacchi, Anata no Pantsu nan Senchi",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.pekoraecchi));
        daftarSfx.add(new SumberSfx("Suisei's Tetris",
                "Tapapa Tapapa Tapapapapa, Tapapip popap popapip pop pip",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.suiseitetrisbgm));
        daftarSfx.add(new SumberSfx("Sakura Miko singing",
                "Tententeren dundundundun tententeren dundundundundun",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.sakuramikosingingcatchyark));
        daftarSfx.add(new SumberSfx("Usada Pekora - Pardun",
                "Pardun?",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.usadapekorapardun));
        daftarSfx.add(new SumberSfx("Minato Aqua - Starburst stream!",
                "STARBURST STREAM!",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.minatoaquastarburststream));
        daftarSfx.add(new SumberSfx("Nakiri Ayame - You dayo!",
                "Yo Dayo",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.nakiriayameyoudayo));
        daftarSfx.add(new SumberSfx("Minato Aqua - Aitai!",
                "Aitai",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.minatoaquaaitai));
        daftarSfx.add(new SumberSfx("Inugami Korone Rickroll",
                "Never gonna give you up, never gonna let you down",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.inugamikoronerickroll));
        daftarSfx.add(new SumberSfx("Kenmochi Toya Loli",
                "Lo-Li Lo-Li Lo-Li",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.touyaloli));
        daftarSfx.add(new SumberSfx("Watson Amelia - Her Time Machine",
                "RRRRRRRRRRRRRRRRRRRRREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.watsonamelia));
        daftarSfx.add(new SumberSfx("Kiryuu Coco - Hey motherfxxkers~\n",
                "Hey motherfxxkers~",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.heymotherfxxkers));
        daftarSfx.add(new SumberSfx("FF7 Victory Fanfare",
                "You got 777 EXP and 777 gald",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.victoryfanfare));
        daftarSfx.add(new SumberSfx("Kiniro Mosaic - Kujo Karen",
                "AYAYA AYAYA",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.ayayaayaya));
        daftarSfx.add(new SumberSfx("Kiniro Mosaic - Oh my gah!",
                "OHH MYY GAAAHH",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.ohmygah));
        daftarSfx.add(new SumberSfx("chuunibyou au",
                "au",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.au));
        daftarSfx.add(new SumberSfx("Century Tuturu",
                "Tuturu tututututututuru",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.tuturucenturyfox));
        daftarSfx.add(new SumberSfx("Lisa Climbing",
                "Don't ask",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.lisa));
        daftarSfx.add(new SumberSfx("hutao-yaho",
                "yahoooo",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.hutaoyahoo));
        daftarSfx.add(new SumberSfx("YEET",
                "Get YEETEEED",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.yeet));
        daftarSfx.add(new SumberSfx("Klee DaDaDa",
                "KLEE",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.dadada));
        daftarSfx.add(new SumberSfx("BAKA! OTANKONASU!",
                "おたんこなす！",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.otankonasu));
        daftarSfx.add(new SumberSfx("Nyaa",
                "nyaa",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.nyaa));
        daftarSfx.add(new SumberSfx("OH NO (Jojo)",
                "OHHH NOOOO!",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.ohno));
        daftarSfx.add(new SumberSfx("Ace Attorney - Objection!!",
                "Objection！",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.phoenixobjection));
        daftarSfx.add(new SumberSfx("EXPLOOOOOSION!",
                "エクスプロージョン！",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.explosion));
        daftarSfx.add(new SumberSfx("Kazuma STEEEAAAL",
                "STTEEEEEAAAALLL",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.kazumasteal));
        daftarSfx.add(new SumberSfx("Kazuma Shogeki",
                "Snipe!",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.konosubasnipe));
        daftarSfx.add(new SumberSfx("Kazuma Freeze",
                "Freeze!",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.kazumafhurreeezhu));
        daftarSfx.add(new SumberSfx("USSR Anthem",
                "SALUTE!",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.ussranthem));
        daftarSfx.add(new SumberSfx("running in the 90s",
                "KANSEI DORIFTOOO!!",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.running));
        daftarSfx.add(new SumberSfx("Shooting Stars Meme",
                "Big Brrraaain",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.shootingstarmeme));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.profile:
                Intent intentProfile = new Intent(SFXLibrary.this, Profile.class);
                startActivity(intentProfile);
                return true;
            case R.id.logout:
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
                Intent intentLogout = new Intent(SFXLibrary.this, MainActivity.class);
                intentLogout.removeExtra("nama");
                startActivity(intentLogout);
            }
        });
        builder.show();
    }
}