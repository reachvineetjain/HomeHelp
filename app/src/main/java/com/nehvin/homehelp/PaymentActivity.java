package com.nehvin.homehelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    RadioGroup paymentGrp;
    Spinner bankSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        paymentGrp = findViewById(R.id.paymentGrp);
        bankSpinner = findViewById(R.id.netBanking_spinner);

        paymentGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {
                    Toast.makeText(getApplicationContext(), rb.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        bankSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    String str = (String)parent.getItemAtPosition(position);
                    Toast.makeText(getApplicationContext(), str , Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void goPrevPage(View view) {
        onBackPressed();
    }





    public void makePayment(View view) {
        Intent intRating = new Intent(getApplicationContext(), RatingActivity.class);
        startActivity(intRating);
    }
}
