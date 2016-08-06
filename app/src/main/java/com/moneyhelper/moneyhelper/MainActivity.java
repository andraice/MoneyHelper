package com.moneyhelper.moneyhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.moneyhelper.moneyhelper.models.MoneyHelperService;

public class MainActivity extends AppCompatActivity {

    Button newAccountButton;
    Button newOperationButton;
    TextView totalAmount;
    Button deleteOperationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        newAccountButton = (Button) findViewById(R.id.newAccountButton);
        newOperationButton = (Button) findViewById(R.id.newOperationButton);
        deleteOperationButton = (Button) findViewById(R.id.deleteOperationButton);
        totalAmount = (TextView) findViewById(R.id.totalAmount);

        newAccountButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), NewAccountActivity.class);
                startActivity(i);
            }
        });
        newOperationButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), NewOperationActivity.class);
                startActivity(i);
            }
        });
        deleteOperationButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MoneyHelperService service = ((MoneyHelperApplication) getApplication()).getMoneyHelperService();
                service.deleteAllOperations();
            }
        });

        refreshDashboard();
    }



    private void refreshDashboard() {
        MoneyHelperService service = ((MoneyHelperApplication) getApplication()).getMoneyHelperService();
        this.totalAmount.setText(String.valueOf(service.getTotalAmount()));
    }
}
