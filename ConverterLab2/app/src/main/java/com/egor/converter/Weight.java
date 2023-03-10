package com.egor.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Weight extends AppCompatActivity implements TextView.OnEditorActionListener {

    private EditText inputNumber;
    private TextView tv1;
    private TextView tv2;

    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        inputNumber = findViewById(R.id.inputNumber);

        inputNumber.setInputType(InputType.TYPE_CLASS_NUMBER
                | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        inputNumber.setOnEditorActionListener(this);
        inputNumber.setOnEditorActionListener(this);
        inputNumber.requestFocus();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv = findViewById(R.id.tv);
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if(i == EditorInfo.IME_ACTION_DONE) {
            Spinner spinner = findViewById(R.id.spinner2);
            String text = spinner.getSelectedItem().toString();
            String input = inputNumber.getText().toString();
            if(input.equals("")){
                Toast.makeText(this, "Ошибка ввода", Toast.LENGTH_LONG).show();
                return true;
            }
            if(text.equals("Килограмм")){
                Double number = Double.parseDouble(inputNumber.getText().toString());
                tv2.setText(number.toString());
                number *= 1000;
                tv1.setText(number.toString());
                number /= 1000000;
                tv.setText(number.toString());
            }
            else if(text.equals("Грамм")) {
                Double number = Double.parseDouble(inputNumber.getText().toString());
                tv1.setText(number.toString());
                number /= 1000;
                tv2.setText(number.toString());
                number /= 1000;
                tv.setText(number.toString());

            }
            else{
                Double number = Double.parseDouble(inputNumber.getText().toString());
                tv.setText(number.toString());
                number *= 1000;
                tv2.setText(number.toString());
                number *= 1000;
                tv1.setText(number.toString());

            }
            return true;
        }
        return false;
    }
}