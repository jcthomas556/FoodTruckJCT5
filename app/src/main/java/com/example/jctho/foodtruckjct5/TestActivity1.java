
package com.example.jctho.foodtruckjct5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jctho.foodtruckjct5.R;

import java.util.ArrayList;

public class TestActivity1 extends AppCompatActivity implements View.OnClickListener {//sandwiches activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sandwich_select);

        Button plusButton9 = findViewById(R.id.button9);//jct
        Button minusButton5 = findViewById(R.id.button5);
        Button plusButton10 = findViewById(R.id.button10);
        Button minusButton6 = findViewById(R.id.button6);
        Button plusButton12 = findViewById(R.id.button12);
        Button minusButton7 = findViewById(R.id.button7);
        Button plusButton13 = findViewById(R.id.button13);
        Button minusButton8 = findViewById(R.id.button8);

        Button reubonDone = findViewById(R.id.button16);


        plusButton9.setOnClickListener(this);//jct
        minusButton5.setOnClickListener((this));
        plusButton10.setOnClickListener((this));
        minusButton6.setOnClickListener((this));
        plusButton12.setOnClickListener(this);
        minusButton7.setOnClickListener(this);
        plusButton13.setOnClickListener(this);
        minusButton8.setOnClickListener(this);


        reubonDone.setOnClickListener(this);
    }


    //item class

    class Item {
        private String name;
        private float price;
    }


    /**
     * The code below is responsible for making incremental and decremental buttons.
     *
     * @param view
     */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button9:
                plusButtonOne(view);
                break;
            case R.id.button5:
                minusButtonOne(view);
                break;
            case R.id.button10:
                plusButtonTwo(view);
                break;
            case R.id.button6:
                minusButtonTwo(view);
                break;
            case R.id.button12:
                plusButtonThree(view);
                break;
            case R.id.button7:
                minusButtonThree(view);
                break;
            case R.id.button13:
                plusButtonFour(view);
                break;
            case R.id.button8:
                minusButtonFour(view);
                break;
            case R.id.button16:
                addReubon(view);
                break;
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////button 1
    int countButton9and5 = 0;

    public void plusButtonOne(View view) {
        countButton9and5++;

        TextView sandwichIncrementer1 = findViewById(R.id.textView5);
        sandwichIncrementer1.setText("" + countButton9and5);

    }

    public void minusButtonOne(View view) {//make sure the counter doesn't go negative
        if (countButton9and5 > 0) {
            countButton9and5--;
        } else {
            return;
        }

        TextView sandwichIncrementer1 = findViewById(R.id.textView5);
        sandwichIncrementer1.setText("" + countButton9and5);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////button 2
    int countButton10and6 = 0;

    public void plusButtonTwo(View view) {
        countButton10and6++;

        TextView sandwichIncrementer2 = findViewById(R.id.textView6);
        sandwichIncrementer2.setText("" + countButton10and6);

    }

    public void minusButtonTwo(View view) {//make sure the counter doesn't go negative
        if (countButton10and6 > 0) {
            countButton10and6--;
        } else {
            return;
        }

        TextView sandwichIncrementer2 = findViewById(R.id.textView6);
        sandwichIncrementer2.setText("" + countButton10and6);
    }

////////////////////////////////////////////////////////////////////////////////////////////////button 3

    int countButton12and7 = 0;

    public void plusButtonThree(View view) {
        countButton12and7++;

        TextView sandwichIncrementer3 = findViewById(R.id.textView7);
        sandwichIncrementer3.setText("" + countButton12and7);

    }

    public void minusButtonThree(View view) {//make sure the counter doesn't go negative
        if (countButton12and7 > 0) {
            countButton12and7--;
        } else {
            return;
        }

        TextView sandwichIncrementer3 = findViewById(R.id.textView7);
        sandwichIncrementer3.setText("" + countButton12and7);
    }


////////////////////////////////////////////////////////////////////////////////////////////////////button 4


    int countButton13and8 = 0;

    public void plusButtonFour(View view) {
        countButton13and8++;

        TextView sandwichIncrementer1 = findViewById(R.id.textView8);
        sandwichIncrementer1.setText("" + countButton13and8);

    }

    public void minusButtonFour(View view) {//make sure the counter doesn't go negative
        if (countButton13and8 > 0) {
            countButton13and8--;
        } else {
            return;
        }

        TextView sandwichIncrementer4 = findViewById(R.id.textView8);
        sandwichIncrementer4.setText("" + countButton13and8);
    }


////////////////jct end


    private ArrayList<Item> order = new ArrayList<>();//temporary use in this class

    public void addReubon(View view) {
        TextView sandwichIncrementer1 = findViewById(R.id.textView5);
        int itemQuantity = Integer.valueOf(sandwichIncrementer1.getText().toString());

        Item reubenOne = new Item();


        if (order.contains(reubenOne))
        {
            order.remove(reubenOne);
            for (int x = 0; x <= itemQuantity; x++) {
                order.add(reubenOne);
            }

        }
    }
//sandwichIncrementer1.setText("" + countButton9and5);


}