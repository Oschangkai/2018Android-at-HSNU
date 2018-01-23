package tw.kaiyeee.android.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Task 1.1: Declare objects to interface with layout components
    private TextView greetingTextView;
    private Button greetingButton;

    // Task 1.2: Indicates HELLO is currently displayed
    private boolean isHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Task 2: Establish references to the textview and button
        // 注意：在 SDK 26 (Android 8.0 Oreo) 中才不需要轉型
        //      在 SDK 26 以前，或是使用 Android Studio 3.0 以前的版本，需要改寫成以下
        //      greetingButton = （Button) findViewById(R.id.greetingBTN);
        //      greetingTextView = (TextView) findViewById(R.id.greetingTV);
        greetingButton = findViewById(R.id.greetingBTN);
        greetingTextView = findViewById(R.id.greetingTV);

        // Task 3.2: Initialize greetings
        initGreeting();

        // Task 4.2: Register the listener event for the button
        greetingButton.setOnClickListener(toggleGreeting);
    }

    // Task 3.1: Initialize greetings
    private void initGreeting() {
        isHello = true;
    }

    // Task 4.1: Create a onClick listener for the button
    private final View.OnClickListener toggleGreeting = new View.OnClickListener() {
        @Override
        public void onClick(View btn) {
            if(isHello) {
                isHello = false;
                greetingTextView.setText("Goodbye");
            } else {
                isHello = true;
                greetingTextView.setText("Hello");
            }
        }
    };
}
