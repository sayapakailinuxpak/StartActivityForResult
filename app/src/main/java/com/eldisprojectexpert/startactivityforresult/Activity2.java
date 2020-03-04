package com.eldisprojectexpert.startactivityforresult;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Activity2 extends AppCompatActivity implements View.OnClickListener{
    public static final String NUMBER_1_KEY = "number_1_key";
    public static final String NUMBER_2_KEY = "number_2_key";

    TextView textViewNumber;
    Button buttonAdd, buttonSubstract;
    int number1, number2;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        initUI();

        Intent intent = getIntent();
        number1 = intent.getIntExtra(NUMBER_1_KEY, 0);
        number2  = intent.getIntExtra(NUMBER_2_KEY, 0);

        String comma = ", ";
        textViewNumber.setText(String.format("%d%s%d", number1, comma, number2));

        buttonAdd.setOnClickListener(this);
        buttonSubstract.setOnClickListener(this);


    }

    private void initUI(){
        textViewNumber = findViewById(R.id.txt_view_number);
        buttonAdd = findViewById(R.id.btn_add);
        buttonSubstract = findViewById(R.id.btn_substract);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_add :
                int result = number1 + number2;

                //back to previous activity and bring the value
                Intent resultIntent = new Intent(this, MainActivity.class);
                resultIntent.putExtra("result", result);
                setResult(RESULT_OK, resultIntent);
                finish();
                break;

            case R.id.btn_substract :
                int resultSubstract = number1 - number2;

                //back to previous activity and bring the value
                Intent resultIntentSub = new Intent(this, MainActivity.class);
                resultIntentSub.putExtra("result", resultSubstract);
                setResult(RESULT_OK, resultIntentSub);
                finish();
                break;
        }
    }
}
