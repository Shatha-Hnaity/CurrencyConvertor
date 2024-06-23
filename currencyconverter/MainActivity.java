package com.example.currencyconverter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
public class MainActivity extends AppCompatActivity {
    double USD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText currency = (EditText) findViewById(R.id.txtEdit);
        final RadioButton rdEuro = (RadioButton) findViewById(R.id.euroNum);
        final RadioButton rdMexico = (RadioButton) findViewById(R.id.mexNum);
        final RadioButton rdCanada = (RadioButton) findViewById(R.id.canadianNum);
        final TextView result = (TextView) findViewById(R.id.txtView);
        Button convert = (Button) findViewById(R.id.btnConvert);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(currency.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Enter an amount in US Dollars", Toast.LENGTH_LONG).show();
                } else {
                    USD = Double.parseDouble(currency.getText().toString());
                    DecimalFormat tenth = new DecimalFormat("##.#");
                    if (USD < 100000) {
                        if (rdEuro.isChecked()) {
                            double euro = 1.16*USD;
                            result.setText(tenth.format(USD) + " USD = " + tenth.format(euro) + " Euro");
                        }
                        if (rdMexico.isChecked()) {
                            double mexicanPeso = 0.05*USD;
                            result.setText(tenth.format(USD) + " USD = " + tenth.format(mexicanPeso) + " MXN");
                        }
                        if (rdCanada.isChecked()) {
                            double canadianDollar = 0.79*USD;
                            result.setText(tenth.format(USD) + " USD = " + tenth.format(canadianDollar) + " CAD");
                        }
                    } else {
                        result.setText("");
                        Toast.makeText(MainActivity.this, "US Dollars input should be < $100,000",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }

        });
    }}