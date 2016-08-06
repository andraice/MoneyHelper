package com.moneyhelper.moneyhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.moneyhelper.moneyhelper.R;
import com.moneyhelper.moneyhelper.models.Account;
import com.moneyhelper.moneyhelper.models.Category;
import com.moneyhelper.moneyhelper.models.MoneyHelperService;

import java.util.ArrayList;
import java.util.List;

public class NewOperationActivity extends AppCompatActivity {

    Button addOperationButton;
    EditText amountText;
    Spinner accountSpinner;
    Spinner categorySpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_operation);


        amountText = (EditText) findViewById(R.id.amountText);
        addOperationButton = (Button) findViewById(R.id.addOperationButton);
        accountSpinner = (Spinner) findViewById(R.id.accountSpinner);
        categorySpinner = (Spinner) findViewById(R.id.categorySpinner);


        MoneyHelperService service = ((MoneyHelperApplication) getApplication()).getMoneyHelperService();


        ArrayAdapter<Account> adapterAccounts = new ArrayAdapter<Account>(getApplicationContext(), R.layout.spinner_item, service.getAccounts());
        adapterAccounts.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountSpinner.setAdapter(adapterAccounts);

        ArrayAdapter<Category> adapterCategories = new ArrayAdapter<Category>(getApplicationContext(), R.layout.spinner_item, service.getCategories());
        adapterCategories.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapterCategories);

        addOperationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MoneyHelperApplication) getApplication())
                        .getMoneyHelperService()
                        .addOperation(
                                amountText.getText().toString(),
                                ""
                        );
                finish();
            }
        });
    }
}
