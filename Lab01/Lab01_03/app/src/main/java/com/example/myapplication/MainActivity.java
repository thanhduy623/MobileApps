package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber;
    private TextView textPercent, textTips, textTotal;
    private Button btnIncrease, btnDecrease;
    private int tipPercent = 10; // Phần trăm mặc định là 10%

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.editTextNumber);
        textPercent = findViewById(R.id.textPercent);
        textTips = findViewById(R.id.textTips);
        textTotal = findViewById(R.id.textTotal);
        btnIncrease = findViewById(R.id.btnIncrease);
        btnDecrease = findViewById(R.id.btnDecrease);

        // Lắng nghe sự kiện nhập số tiền
        editTextNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculateTip();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Nút tăng %
        btnIncrease.setOnClickListener(v -> {
            if (tipPercent < 100) {
                tipPercent += 1;
                updatePercent();
                calculateTip();
            }
        });

        // Nút giảm %
        btnDecrease.setOnClickListener(v -> {
            if (tipPercent > 5) {
                tipPercent -= 1;
                updatePercent();
                calculateTip();
            }
            if (tipPercent == 5) {
                btnDecrease.setEnabled(false);
            }
        });

        // Cập nhật ban đầu
        updatePercent();
        calculateTip();
    }

    // Cập nhật phần trăm hiển thị
    private void updatePercent() {
        textPercent.setText(tipPercent + "%");
        btnDecrease.setEnabled(tipPercent > 5); // Nếu bằng 5%, vô hiệu hóa nút giảm
    }

    // Tính toán Tip và Tổng tiền
    private void calculateTip() {
        String billAmountStr = editTextNumber.getText().toString();
        if (!billAmountStr.isEmpty()) {
            double billAmount = Double.parseDouble(billAmountStr);
            double tipAmount = billAmount * tipPercent / 100.0;
            double totalAmount = billAmount + tipAmount;

            DecimalFormat df = new DecimalFormat("0.00");
            textTips.setText(df.format(tipAmount));
            textTotal.setText(df.format(totalAmount));
        } else {
            textTips.setText("0.00");
            textTotal.setText("0.00");
        }
    }
}
