package com.example.tictactoo_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imageButton1;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private ImageButton imageButton5;
    private ImageButton imageButton6;
    private ImageButton imageButton7;
    private ImageButton imageButton8;
    private ImageButton imageButton9;
    private TextView  result_display;
    private AppCompatButton reset_Button;
    public int[] gamestate={ 2, 2, 2, 2, 2, 2, 2, 2, 2} ;
    int activePlayer=0;
    int[][] winPosition={{0,1,2},{3,4,5},{6,7,8},
                         {0,3,6},{1,4,5},{2,5,8},
                         {0,4,8},{2,4,6}} ;
    private  Boolean gameActive=true;
    int count=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imageButton1=findViewById(R.id.tap1);
        imageButton2= findViewById(R.id.tap2);
        imageButton3=findViewById(R.id.tap3);
        imageButton4= findViewById(R.id.tap4);
        imageButton5=findViewById(R.id.tap5);
        imageButton6= findViewById(R.id.tap6);
        imageButton7= findViewById(R.id.tap7);
        imageButton8=findViewById(R.id.tap8);
        imageButton9= findViewById(R.id.tap9);
        reset_Button=findViewById(R.id.resetTap);

        result_display=findViewById(R.id.result);

        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);
        imageButton4.setOnClickListener(this);
        imageButton5.setOnClickListener(this);
        imageButton6.setOnClickListener(this);
        imageButton7.setOnClickListener(this);
        imageButton8.setOnClickListener(this);
        imageButton9.setOnClickListener(this);


        reset_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameRest(view);
            }
        });






    }

    @Override
    public void onClick(View view) {

        ImageButton img= (ImageButton) view;
        int tap=Integer.parseInt(img.getTag().toString());



        if(gamestate[tap]==2 && gameActive){

            gamestate[tap]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0){
                img.setImageResource(R.drawable.zero);
                activePlayer=1;
                String x="Player 2 trun (+)";
                count++;
                result_display.setText(x);
                Toast.makeText(this, ""+count, Toast.LENGTH_SHORT).show();
            }
            else if(activePlayer==1){
                img.setImageResource(R.drawable.add);
                activePlayer=0;
                String x="Player 1 trun (0)";
                count++;
                result_display.setText(x);

                Toast.makeText(this, ""+count, Toast.LENGTH_SHORT).show();

            }
            img.animate().translationYBy(1000f).setDuration(300);

        }

        for(int[] winPosition:winPosition) {
            if (gamestate[winPosition[0]] == gamestate[winPosition[1]]&&
            gamestate[winPosition[1]]==gamestate[winPosition[2]]&&
            gamestate[winPosition[0]]!=2) {
                gameActive=false;
                if(gamestate[winPosition[0]]==0){
                    result_display.setText("Player 1 win");
                }
                else {
                    result_display.setText("Player 2 win");
                }
            }
        }
        if(!gameActive){

            gameRest(view);

        }

    }
    public void gameRest(View view){
        count=0;
        gameActive=true;
        activePlayer=0;
        for(int i =0;i<gamestate.length;i++){
            gamestate[i]=2;
        }
        imageButton1.setImageResource(0);
        imageButton2.setImageResource(0);
        imageButton3.setImageResource(0);
        imageButton4.setImageResource(0);
        imageButton5.setImageResource(0);
        imageButton6.setImageResource(0);
        imageButton7.setImageResource(0);
        imageButton8.setImageResource(0);
        imageButton9.setImageResource(0);

    }
}