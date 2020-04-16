package com.appzone.singletonjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.appzone.singletonjava.model.Coin;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvCoin, tvCoinLocation,tvCoin1Location;
    private Button btnAddMoreCoin;
    private Button btnDeductCoin;
    private Coin coin, coin1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        tvCoin = (TextView) findViewById(R.id.tvCoin);
        tvCoinLocation= (TextView) findViewById(R.id.tvCoinLocation);
        tvCoin1Location = (TextView) findViewById(R.id.tvCoin1Location);
        btnAddMoreCoin = (Button) findViewById(R.id.btnAddMore);
        btnDeductCoin = (Button) findViewById(R.id.btnDeductCoin);

        btnAddMoreCoin.setOnClickListener(this);
        btnDeductCoin.setOnClickListener(this);

        /*

        Created two variables but both variables will be pointing to only one value of the object

         */

        coin = Coin.getInstance();

        coin1 = Coin.getInstance();


    }

    private void setBtnAddMoreCoin() {
        // Adding coin in coin object
        updateCoinLocation();
        updateCoin1Location();
        coin.addMoreCoin();
        updateUI();
    }

    private void updateUI() {
        // getting coin values from coin1 object
        String msg = String.format(Locale.getDefault(), "%d coins left", coin1.getCoin());
        tvCoin.setText(msg);
    }

    private void updateCoinLocation(){
        String msg = String.format(Locale.getDefault(),"Location of   Coin: %d", coin.hashCode());
        tvCoinLocation.setText(msg);
    }

    private void updateCoin1Location(){
        String msg = String.format(Locale.getDefault(),"Location of 1 Coin: %d", coin1.hashCode());
        tvCoin1Location.setText(msg);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
        updateCoinLocation();
        updateCoin1Location();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddMore:
                setBtnAddMoreCoin();
                break;
            case R.id.btnDeductCoin:
                Intent intent = new Intent(MainActivity.this, DeductCoinActivity.class);
                startActivity(intent);
                break;
        }
    }
}
