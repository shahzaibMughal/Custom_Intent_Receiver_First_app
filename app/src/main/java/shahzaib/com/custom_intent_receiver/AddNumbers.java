package shahzaib.com.custom_intent_receiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddNumbers extends AppCompatActivity {

    Button returnResultBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_numbers);

        returnResultBtn = findViewById(R.id.returnResultBtn);
        returnResultBtn.setEnabled(false);
    }

    public void calculateResult(View view) {

        Bundle data = getIntent().getExtras();
        if(data != null)
        {
            int firstNumber, secondNumber;
            firstNumber = data.getInt("FirstNumber",0);
            secondNumber = data.getInt("SecondNumber",0);

            final int result = firstNumber + secondNumber;
            TextView resultTV = findViewById(R.id.resultTV);
            resultTV.setText(String.valueOf(result));


            returnResultBtn.setEnabled(true);
            returnResultBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("Result",result);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            });

        }
        else
        {
            Toast.makeText(this, "Received Data is NULL", Toast.LENGTH_SHORT).show();
        }

    }
}
