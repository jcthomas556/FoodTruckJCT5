package com.example.jctho.foodtruckjct5;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.squareup.sdk.pos.ChargeRequest;
import com.squareup.sdk.pos.CurrencyCode;
import com.squareup.sdk.pos.PosClient;
import com.squareup.sdk.pos.PosSdk;

public class MainActivity extends AppCompatActivity {

    private static final String APPLICATION_ID = "sq0idp-1OcBrfMiihiS4krzlGJ2HQ";

    private PosClient posClient;

    // create a new charge request and initiate a Point of Sale transaction
    private static final int CHARGE_REQUEST_CODE = 1;
    public void startTransaction() {
        ChargeRequest request = new ChargeRequest.Builder(
                100,
                CurrencyCode.USD)
                .build();
        try {
            Intent intent = posClient.createChargeIntent(request);
            startActivityForResult(intent, CHARGE_REQUEST_CODE);

        } catch (ActivityNotFoundException e) {
           /* AlertDialogHelper.showDialog( // this is needed if it ever goes to production
                    this,
                    "Error",
                    "Square Point of Sale is not installed"
            );*/
            posClient.openPointOfSalePlayStoreListing();
        }
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Handle unexpected errors
        if (data == null || requestCode != CHARGE_REQUEST_CODE) {
            // AlertDialogHelper.showDialog(this,
            // "Error: unknown",
            //"Square Point of Sale was uninstalled or stopped working");
            return;
        }

        // Handle expected results
        if (resultCode == Activity.RESULT_OK) {
            // Handle success
            //ChargeRequest.Success success = posClient.parseChargeSuccess(data);
            //AlertDialogHelper.showDialog(this,
            //  "Success",
            // "Client transaction ID: "
            //    + success.clientTransactionId);
        } else {
            // Handle expected errors
            // ChargeRequest.Error error = posClient.parseChargeError(data);
            //AlertDialogHelper.showDialog(this,
            //  "Error" + error.code,
            //  "Client transaction ID: "
            //        + error.debugDescription);
        }
        return;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        posClient = PosSdk.createClient(this, APPLICATION_ID);//JCT SQUARE

        setContentView(R.layout.activity_main);

        Button sides = findViewById(R.id.button);
        Button drinks = findViewById(R.id.button2);
        Button sandwich = findViewById(R.id.button3);

        sandwich.setOnClickListener((View.OnClickListener) this);//not sure what's going on here
        sides.setOnClickListener((View.OnClickListener) this);
        drinks.setOnClickListener((View.OnClickListener) this);
    }

    public void openSandwich_select() {
        Intent intent = new Intent( this, TestActivity1.class);
        startActivity(intent);
    }

    public void openSide_select() {
        Intent intent = new Intent( this, TestActivity1.class);
        startActivity(intent);
    }

    public void openDrink_select() {
        Intent intent = new Intent( this, TestActivity1.class);
        startActivity(intent);
    }


    //@Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button3:
                openSandwich_select();
                break;
            case R.id.button:
                openSide_select();
                break;
            case R.id.button2:
                openDrink_select();
                break;

        }


    }
}
