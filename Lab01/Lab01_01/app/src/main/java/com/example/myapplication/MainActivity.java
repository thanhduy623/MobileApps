package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber;
    private Button buttonToast, buttonCount;
    private int count = 0; // Biến đếm số

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần giao diện
        editTextNumber = findViewById(R.id.editTextNumber);
        buttonToast = findViewById(R.id.button_toast);
        buttonCount = findViewById(R.id.button_count);

        // Nút TOAST hiển thị thông báo
        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Bấm count để đếm số", Toast.LENGTH_SHORT).show();
            }
        });

        // Nút COUNT tăng số trong EditText
        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++; // Tăng số đếm
                editTextNumber.setText(String.valueOf(count)); // Hiển thị lên EditText
            }
        });
    }
}
