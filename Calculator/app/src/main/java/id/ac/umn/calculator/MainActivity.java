package id.ac.umn.calculator;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    TextView inputTV;
    TextView hasilTV;

    String kalkulasi = "";
    String formula = "";
    String tempFormula = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }

    private void initTextViews() {
        inputTV = (TextView)findViewById(R.id.input);
        hasilTV = (TextView)findViewById(R.id.hasil);
    }

    public void plusMinus(View view) {
        if(isNumeric(kalkulasi.charAt(0))){
            String temp = kalkulasi;
            inputTV.setText("");
            kalkulasi = "";
            setKalkulasi("-"+temp);
        }

    }

    private void setKalkulasi(String input) {
        kalkulasi = kalkulasi + input;
        inputTV.setText(kalkulasi);
    }

    public void samadengan(View view) {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        checkForPowerOf();

        try {
            result = (double)engine.eval(formula);
        } catch (ScriptException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if(result != null)
            hasilTV.setText(String.valueOf(result.doubleValue()));
    }

    private void checkForPowerOf() {
        ArrayList<Integer> indexOfPowers = new ArrayList<>();
        for(int i = 0; i < kalkulasi.length(); i++){
            if(kalkulasi.charAt(i) == '^')
                indexOfPowers.add(i);
        }

        formula = kalkulasi;
        tempFormula = kalkulasi;
        for(Integer index: indexOfPowers){
            changeFormula(index);
        }
        formula = tempFormula;
    }

    private void changeFormula(Integer index){
        String numberLeft = "";
        String numberRight = "";

        for(int i = index + 1; i < kalkulasi.length(); i++){
            if(isNumeric(kalkulasi.charAt(i)))
                numberRight = numberRight + kalkulasi.charAt(i);
            else
                break;
        }

        for(int i = index - 1; i >= 0; i--){
            if(isNumeric(kalkulasi.charAt(i)))
                numberLeft = numberLeft + kalkulasi.charAt(i);
            else
                break;
        }

        String original = numberLeft + "^" + numberRight;
        String changed = "Math.pow("+numberLeft+","+numberRight+")";
        tempFormula = tempFormula.replace(original,changed);
    }

    private boolean isNumeric(char c){
        if((c <= '9' && c >= '0') || c == '.')
            return true;

        return false;
    }

    public void deleteOnClick(View view) {
        if(kalkulasi.length() > 0){
            kalkulasi = kalkulasi.substring(0, kalkulasi.length()-1);
            inputTV.setText(kalkulasi);
        }
    }

    boolean leftBracket = true;
    public void bracketsOnClick(View view) {
        if(leftBracket) {
            setKalkulasi("(");
            leftBracket = false;
        } else {
            setKalkulasi(")");
            leftBracket = true;
        }

    }

    public void powerOfOnClick(View view) {
        setKalkulasi("^");
    }

    public void clearOnClick(View view) {
        inputTV.setText("");
        kalkulasi = "";
        hasilTV.setText("");
        boolean leftBracket = true;
        boolean rightBracket = true;
    }

    public void divideOnClick(View view) {
        setKalkulasi("/");
    }

    public void tujuh(View view) {
        setKalkulasi("7");
    }

    public void delapan(View view) {
        setKalkulasi("8");
    }

    public void sembilan(View view) {
        setKalkulasi("9");
    }

    public void timesOnClick(View view) {
        setKalkulasi("*");
    }

    public void empat(View view) {
        setKalkulasi("4");
    }

    public void lima(View view) {
        setKalkulasi("5");
    }

    public void enam(View view) {
        setKalkulasi("6");
    }

    public void minusOnClick(View view) {
        setKalkulasi("-");
    }

    public void satu(View view) {
        setKalkulasi("1");
    }

    public void dua(View view) {
        setKalkulasi("2");
    }

    public void tiga(View view) {
        setKalkulasi("3");
    }

    public void plusOnClick(View view) {
        setKalkulasi("+");
    }

    public void desimal(View view) {
        setKalkulasi(".");
    }

    public void nol(View view) {
        setKalkulasi("0");
    }

}