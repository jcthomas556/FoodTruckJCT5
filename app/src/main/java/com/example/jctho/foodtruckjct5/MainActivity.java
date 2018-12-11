package com.example.jctho.foodtruckjct5;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Point;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.sdk.pos.ChargeRequest;
import com.squareup.sdk.pos.CurrencyCode;
import com.squareup.sdk.pos.PosClient;
import com.squareup.sdk.pos.PosSdk;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //public static ArrayList<Item> order = new ArrayList<>();//JCT uncomment when buttons are put here instead
    private long animationDuration = 500;
    private static final String APPLICATION_ID = "sq0idp-1OcBrfMiihiS4krzlGJ2HQ";
    private ConstraintLayout sandView = null;
    private ConstraintLayout drinksView = null;
    private ConstraintLayout sidesView = null;
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

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

        sandView = findViewById(R.id.sandWhichView);
        drinksView = findViewById(R.id.drinkView);
        sidesView = findViewById(R.id.sideView);


        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        sandView.setX(size.x);
        drinksView.setX(size.x);
        sidesView.setX(size.x);


        Button sides = findViewById(R.id.button);
        Button drinks = findViewById(R.id.button2);
        Button sandwich = findViewById(R.id.button3);
        Button sandBack = findViewById(R.id.sandback);
        Button drinkBack = findViewById(R.id.drinkback);
        Button sidesBack = findViewById(R.id.sidesback);
        Button addReuben = findViewById(R.id.button16);/////////////jct
        Button plusButtonReuben = findViewById((R.id.button15));/////////////jct

        sandBack.setOnClickListener(this);
        sandwich.setOnClickListener(this);
        sides.setOnClickListener(this);
        drinks.setOnClickListener(this);
        drinkBack.setOnClickListener(this);
        sidesBack.setOnClickListener(this);


        plusButtonReuben.setOnClickListener(this);/////////////jct
        addReuben.setOnClickListener(this);///////////////////////jct



    }

    public void hideSandwhich(View view) {
        sandView.animate().x(sandView.getWidth()).setDuration(animationDuration);
    }

    public void nothing(View view) {
    }

    public void showSandwhich(View view) {
        sandView.animate().x(0).setDuration(animationDuration);
    }

    public void hideDrinks(View view) {
        drinksView.animate().x(drinksView.getWidth()).setDuration(animationDuration);
    }

    public void showDrinks(View view) {
        drinksView.animate().x(0).setDuration(animationDuration);
    }

    public void hideSides(View view) {
        sidesView.animate().x(sidesView.getWidth()).setDuration(animationDuration);
    }

    public void showSides(View view) {
        sidesView.animate().x(0).setDuration(animationDuration);
    }

    public void openSandwich_select() {
        Intent intent = new Intent(this, TestActivity1.class);
        startActivity(intent);
    }

    public void openSide_select() {
        Intent intent = new Intent(this, TestActivity1.class);
        startActivity(intent);
    }

    public void openDrink_select() {
        Intent intent = new Intent(this, TestActivity1.class);
        startActivity(intent);
    }


    //@Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button3:
                showSandwhich(sandView);
                break;
            case R.id.button:
                showSides(sidesView);
                break;
            case R.id.button2:
                showDrinks(drinksView);
                break;
            case R.id.sandback:
                hideSandwhich(sandView);
                break;
            case R.id.sidesback:
                hideSides(sidesView);
                break;
            case R.id.drinkback:
                hideDrinks(drinksView);
                break;
            case R.id.button16:
                addReubon(sandView);//added sandView
                break;
            case R.id.button15:
                plusButtonOne(sandView);//keep putting sandView
                break;
        }


    }


    /////////////////////////////////////////////////////////////////////////////////plus and minus buttons

    int countButton14and15 = 0;

    public void plusButtonOne(View view) {
        countButton14and15++;

        TextView sandwichIncrementer = findViewById(R.id.textView9);
        sandwichIncrementer.setText("" + countButton14and15);
    }




















    ////////////////JCT
    class Item {
        private String name = "default";
        private float price = 0;
    }

    private ArrayList order = new ArrayList<>();

    public void addReubon(View view) {
        TextView reubenCounter = findViewById(R.id.textView9);//this is the increasing 0 // this works
        int itemQuantity = Integer.valueOf(reubenCounter.getText().toString());//this should turn the number in ^ to an int
        TextView menuItemOne = findViewById(R.id.textView10);//this is the view that should be in the main menu



        Item reubenOne = new Item();//make a new reuben
        reubenOne.name = "Reuben";
        reubenOne.price = 500;///vs "$500"?

        if (order.contains(reubenOne)) {//if the order list has a reuben already it will clear it out completely
            order.remove(reubenOne);//^
        }

        for (int x = 0; x < itemQuantity; x++) {//add's however many reubens are added to the list so far
            order.add(reubenOne);


            //menuItemOne.setText(order.indexOf(itemQuantity-1));//this probably wouldn't work

            String theOrder = order.toString();//theOrder is never turning into a string


        }





    }




}
