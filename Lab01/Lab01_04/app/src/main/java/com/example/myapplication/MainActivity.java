package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUSD, editTextEuro, editTextVND;
    private Button btnConvert, btnClear;
    private final double USD_TO_EURO = 0.92; // 1 USD = 0.92 EUR
    private final double USD_TO_VND = 24000; // 1 USD = 24,000 VND

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ View từ XML
        editTextUSD = findViewById(R.id.editTextUSD);
        editTextEuro = findViewById(R.id.editTextEuro);
        editTextVND = findViewById(R.id.editTextVND);
        btnConvert = findViewById(R.id.btnConvert);
        btnClear = findViewById(R.id.btnClear);

        // Căn lề trái cho EditText
        editTextEuro.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
        editTextVND.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);

        // Xử lý sự kiện khi nhấn nút Convert
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrency();
            }
        });

        // Xử lý sự kiện khi nhấn nút Clear
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });
    }

    // Chuyển đổi tiền tệ và định dạng số theo "#.###,##"
    private void convertCurrency() {
        String usdInput = editTextUSD.getText().toString().trim();
        if (usdInput.isEmpty()) {
            Toast.makeText(this, "Please enter a valid amount in USD", Toast.LENGTH_SHORT).show();
            return;
        }

        double usdAmount = Double.parseDouble(usdInput);
        double euroAmount = usdAmount * USD_TO_EURO;
        double vndAmount = usdAmount * USD_TO_VND;

        // Định dạng số "#.###,##"
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");

        editTextEuro.setText(decimalFormat.format(euroAmount));
        editTextVND.setText(decimalFormat.format(vndAmount));
    }

    // Xóa dữ liệu trong EditText
    private void clearFields() {
        editTextUSD.setText("");
        editTextEuro.setText("");
        editTextVND.setText("");
    }
}
