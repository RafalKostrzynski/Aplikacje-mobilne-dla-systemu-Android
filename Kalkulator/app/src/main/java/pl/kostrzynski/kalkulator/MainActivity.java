package pl.kostrzynski.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("DefaultLocale")
    public void onClickCalculate(View view){
        TextView result= findViewById(R.id.result);
        Spinner firstNumber= findViewById(R.id.firstNumber);
        Spinner secondNumber= findViewById(R.id.secondNumber);
        Spinner sign= findViewById(R.id.sign);
        double resultOfCalculation=0;
        double firstDigit = Double.parseDouble(String.valueOf(firstNumber.getSelectedItem()));
        double secondDigit = Double.parseDouble(String.valueOf(secondNumber.getSelectedItem()));
        switch(String.valueOf(sign.getSelectedItem())){
            case "+":
                resultOfCalculation=firstDigit+secondDigit;
                break;
            case "-":
                resultOfCalculation=firstDigit-secondDigit;
                break;
            case "*":
                resultOfCalculation=firstDigit*secondDigit;
                break;
            case "/":
                if(secondDigit!=0) resultOfCalculation=firstDigit/secondDigit;
                else{
                    Toast.makeText(getApplicationContext(), "Cant divide by zero", Toast.LENGTH_SHORT).show();
                }
        }
        result.setText(String.format("%.2f",resultOfCalculation));
    }
}
