package com.example.tateti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private TextView playerName;
    private TextView playerSymbol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        String name = getIntent().getStringExtra("name");
        playerName = findViewById(R.id.textViewPlayerName);
        playerName.setText("Bienvenido "+ name);

        String symbol = getIntent().getStringExtra("symbol");
        playerSymbol= findViewById(R.id.textViewPlayerSymbol);
        playerSymbol.setText("Juega con "+ symbol);

    }
}