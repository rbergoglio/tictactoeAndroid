package com.example.tateti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[3][3];

    private boolean player1Turn = true;

    private int roundCount;

    private TextView playerName;
    private TextView playerSymbol;
    private TextView textTurn;
    private String player1Symbol;
    private String player2Symbol;

    private String playerName2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        String name = getIntent().getStringExtra("name");
        playerName = findViewById(R.id.textViewPlayerName);
        playerName.setText("Bienvenido "+ name);
        playerName2 = name;

        String symbol = getIntent().getStringExtra("symbol");
        playerSymbol= findViewById(R.id.textViewPlayerSymbol);
        playerSymbol.setText("Juega con "+ symbol);

        textTurn = findViewById(R.id.textViewTurn);
        textTurn.setText("Turno de" + playerName2);


        if(symbol == "Cruces"){
            player1Symbol= "X";
            player2Symbol = "O";
        }else{
            player1Symbol= "O";
            player2Symbol = "X";;
        }

        for (int i = 0; i<3; i++){
            for(int j=0; j<3; j++){
                String buttonID = "button_"+ i + j;
                int resID = getResources().getIdentifier(buttonID, "id",getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);

            }
        }

        Button buttonReset = findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j <3; j++){
                        buttons[i][j].setText("");
                    }

                }

            }
        });



    }

    @Override
    public void onClick(View v) {
        if(!((Button) v).getText().toString().equals("")){
            return;
        }
        if(player1Turn){
            ((Button) v).setText(player1Symbol);
        }else{
            ((Button) v).setText(player2Symbol);
        }

        roundCount++;

        player1Turn = !player1Turn;
        if(player1Turn){
            textTurn.setText("Turno de " + playerName2);
        }else{
            textTurn.setText("Turno de Computadora Android");
        }
        //la idea seria buscar algun
        //while()
        //buttons[0][0].callOnClick();
        //player1Turn = !player1Turn;
    }
}