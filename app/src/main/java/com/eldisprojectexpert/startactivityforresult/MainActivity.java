package com.eldisprojectexpert.startactivityforresult;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editTextFirstOperand, editTextSecondOperand;
    TextView textViewResult;
    Button buttonOpenNewActivity;

    String firstOperand;
    String secondOperand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        
    }

    private void initUI(){
        editTextFirstOperand = findViewById(R.id.edt_first_operand);
        editTextSecondOperand = findViewById(R.id.edt_second_operand);
        textViewResult = findViewById(R.id.txt_result);
        buttonOpenNewActivity = findViewById(R.id.btn_open_next_activity);
        buttonOpenNewActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_open_next_activity){
            firstOperand = editTextFirstOperand.getText().toString().trim();
            secondOperand = editTextSecondOperand.getText().toString().trim();

            if (firstOperand.equals("") || secondOperand.equals("")){
                Toast.makeText(this, "This field cannot be blank", Toast.LENGTH_LONG).show();
            }else{
                int firstOperandInNumber = Integer.parseInt(firstOperand);
                int secondOperandInNumber = Integer.parseInt(secondOperand);


                Intent nextIntent = new Intent(this, Activity2.class);
                nextIntent.putExtra(Activity2.NUMBER_1_KEY, firstOperandInNumber);
                nextIntent.putExtra(Activity2.NUMBER_2_KEY, secondOperandInNumber);
                startActivityForResult(nextIntent, 1);
            }


        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                int result = data.getIntExtra("result", 0);
                textViewResult.setText(String.valueOf(result));
            }

            if (resultCode == RESULT_CANCELED){
                textViewResult.setText("Nothing selected");
            }
        }
    }
}
