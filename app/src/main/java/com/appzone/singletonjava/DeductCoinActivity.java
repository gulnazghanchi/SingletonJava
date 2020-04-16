package com.appzone.singletonjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.appzone.singletonjava.model.Coin;

import java.util.Locale;

public class DeductCoinActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvDeductCoin;
    private Button btnDeductCoin;
    private Coin coin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deduct_coin);

        initView();
    }

    private void initView(){
        tvDeductCoin = (TextView)findViewById(R.id.tvDeductedCoin);
        btnDeductCoin = (Button)findViewById(R.id.btnDeduct);

        coin = Coin.getInstance();

        btnDeductCoin.setOnClickListener(this);
    }

    private void updateUI(){
        String msg = String.format(Locale.getDefault(),"%d coin left", coin.getCoin());
        tvDeductCoin.setText(msg);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnDeduct:
                coin.deductCoin();
                updateUI();
                break;
        }
    }
}
