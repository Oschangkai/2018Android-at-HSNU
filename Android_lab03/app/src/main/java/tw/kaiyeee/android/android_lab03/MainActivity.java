package tw.kaiyeee.android.android_lab03;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.shashank.sony.fancytoastlib.FancyToast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

        saveIntoFile(height, weight, bmiVal, suggestion);
    }

    private void saveIntoFile(double h, double w, double b, String s) {
        BmiData data = new BmiData(h, w, b, s);
        boolean isWritable = isExternalStorageWritable();
        if(!isWritable) {
            FancyToast.makeText(this, "External is Not Readable",FancyToast.LENGTH_LONG, FancyToast.WARNING,true).show();
            return;
        }
        try {
            String fileName = "BMI_Data.txt";
            String extPath = Environment.getExternalStorageDirectory().getAbsolutePath();
            String filePath = extPath + File.separator + fileName;

            FileWriter fw = new FileWriter(filePath, true);
            fw.write(data.getBmiDataString());
            fw.flush();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showBtnClicked(View v) {
        Intent i = new Intent(MainActivity.this, BmiDataListActivity.class);
        startActivity(i);
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

}
