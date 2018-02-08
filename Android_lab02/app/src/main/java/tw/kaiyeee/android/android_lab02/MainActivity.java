package tw.kaiyeee.android.android_lab02;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity {

    private EditText heightET;
    private EditText weightET;
    private TextView bmiTV;
    private TextView suggestionTV;
    private BMI bmi = new BMI();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(this, IntroPage.class);
        startActivity(i);

        heightET = findViewById(R.id.heightET);
        weightET = findViewById(R.id.weightET);
        bmiTV = findViewById(R.id.bmiTV);
        suggestionTV = findViewById(R.id.suggestionTV);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("離開")
                .setMessage("您確定要離開嗎？")
                .setPositiveButton("對拉", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finish();
                    }
                })
                .setNegativeButton("不要", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }

    public void calculateButtonClicked(View v) {
        boolean isNull = checkIsNull();
        if(isNull) {
//            Toast.makeText(MainActivity.this, R.string.empty_noti, Toast.LENGTH_SHORT).show();
            FancyToast.makeText(this, getString(R.string.empty_noti),FancyToast.LENGTH_LONG, FancyToast.WARNING,true).show();
            return;
        }
        showText();
    }
    private boolean checkIsNull() {
        if(heightET.getText().toString().equals(""))
            return true;
        if(weightET.getText().toString().equals(""))
            return true;
        if(heightET.getText().toString().equals("0"))
            return true;
        if(weightET.getText().toString().equals("0"))
            return true;
        return false;
    }
    private void showText() {
        double bmiVal;
        String suggestion;
        double height = Double.parseDouble(heightET.getText().toString());
        double weight = Double.parseDouble(weightET.getText().toString());

        bmi.setBmi(height, weight);
        bmiVal = bmi.getBmi();
        suggestion = bmi.getSuggestion();

        bmiTV.setText(String.format("%.1f", bmiVal));
        suggestionTV.setText(suggestion);
    }

}
