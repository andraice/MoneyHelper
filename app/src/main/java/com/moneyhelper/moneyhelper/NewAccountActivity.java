package com.moneyhelper.moneyhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NewAccountActivity extends AppCompatActivity {

    Button addAccountButton;
    EditText nameAccountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);

        nameAccountText = (EditText) findViewById(R.id.nameAccounText);
        addAccountButton = (Button) findViewById(R.id.addAccountButton);

        addAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MoneyHelperApplication) getApplication())
                        .getMoneyHelperService()
                        .addAccount(
                                nameAccountText.getText().toString()
                        );
                Toast toast = Toast.makeText(getApplicationContext(), "Saved successfully!", Toast.LENGTH_LONG);
                toast.show();

                finish();
            }
        });
    }
}
