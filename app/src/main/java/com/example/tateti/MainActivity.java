package com.example.tateti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText editTextIngreseSuNombre;
    private RadioGroup radioGroupSymbols;
    private Button buttonComenzar;
    private String name;
    private Integer idRadio;
    private RadioButton radioGropSymbol;
    private String symbol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextIngreseSuNombre = findViewById(R.id.editTextIngreseSuNombre);
        radioGroupSymbols = findViewById(R.id.radioGroupSymbols);
        buttonComenzar = findViewById(R.id.buttonComenzar);


        buttonComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editTextIngreseSuNombre.getText().toString();
                idRadio = radioGroupSymbols.getCheckedRadioButtonId();
                radioGropSymbol= findViewById(idRadio);
                symbol = radioGropSymbol.getText().toString();

                if(!name.isEmpty()){
                    Intent i = new Intent(MainActivity.this, GameActivity.class);
                    i.putExtra("name",name);
                    i.putExtra("symbol",symbol);
                    startActivity(i);
                }
                else{
                    Log.d("myTag", "error");
                }

            }
        });
    }
}