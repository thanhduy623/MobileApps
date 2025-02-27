package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button btnShowResults;
    private TextView txtResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các View từ XML
        radioGroup = findViewById(R.id.radioGroup);
        btnShowResults = findViewById(R.id.btnShowResults);
        txtResults = findViewById(R.id.txtResults);

        // Xử lý sự kiện khi nhấn nút "Click here to see Results"
        btnShowResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    Toast.makeText(MainActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                } else {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedText = selectedRadioButton.getText().toString();
                    txtResults.setText("You selected: " + selectedText);
                }
            }
        });
    }
}
