package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần trong layout
        editText = findViewById(R.id.editTextText);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        // Xử lý sự kiện click button
        button.setOnClickListener(view -> {
            String inputText = editText.getText().toString().trim();

            if (inputText.isEmpty()) {
                Toast.makeText(MainActivity.this, "Vui lòng nhập thông tin", Toast.LENGTH_SHORT).show();
            } else {
                textView.setText(inputText); // Hiển thị nội dung ở TextView
                editText.setText(""); // Xóa nội dung của EditText
            }
        });

        // Lắng nghe sự kiện nhập liệu trong EditText
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Không cần xử lý
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Kiểm tra nội dung nhập vào EditText
                String input = s.toString().trim();
                if (input.equalsIgnoreCase("OFF")) {
                    button.setEnabled(false); // Tắt button
                } else if (input.equalsIgnoreCase("ON")) {
                    button.setEnabled(true); // Bật button
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Không cần xử lý
            }
        });
    }
}
