package com.example.josem.convertidormoneda;

import android.annotation.SuppressLint;
import android.graphics.RadialGradient;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RadioButton crc_usd;
    private RadioButton usd_crc;



    public void onButtonConvertirClick(View view){

        EditText editText = findViewById(R.id.editTextValor);
        RadioGroup rgroup = findViewById(R.id.rgroup);
        rgroup.clearCheck();
        float resultado =  Float.parseFloat(editText.getText().toString());
        Log.d("resultado",String.format("%f",resultado));

        Boolean crcToUSD = crc_usd.isChecked();
        if(crcToUSD){
                resultado = resultado / 570f;
        }else{
                resultado = resultado * 570f;
        }

        Toast.makeText(this,String.format("%f",resultado),Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crc_usd = findViewById(R.id.rBtnCRCUSD);
        crc_usd.setOnClickListener(this);
        usd_crc = findViewById(R.id.rBtnUSDCRC);
        usd_crc.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rBtnUSDCRC:
                if(crc_usd.isChecked()){
                    crc_usd.setChecked(false);
                    crc_usd.setSelected(false);
                    break;
                }
            case R.id.rBtnCRCUSD:
                if(usd_crc.isChecked()){
                    usd_crc.setChecked(false);
                    usd_crc.setSelected(false);
                    break;
                }
        }
    }
}
