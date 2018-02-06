package tw.kaiyeee.android.android_lab01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        heightET = findViewById(R.id.heightET);
        weightET = findViewById(R.id.weightET);
        bmiTV = findViewById(R.id.bmiTV);
        suggestionTV = findViewById(R.id.suggestionTV);
    }

    public void calculateButtonClicked(View v) {
        boolean isNull = checkIsNull();
        if(isNull) {
            Toast.makeText(MainActivity.this, R.string.empty_noti, Toast.LENGTH_SHORT).show();
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
