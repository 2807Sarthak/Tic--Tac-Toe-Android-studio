package com.example.tictactoegame;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.FeatureInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

//        0 -> X
//        1 -> O
//        2 -> NULL/Blank space
    TextView textView;


    int activeplayer = 0;
    int[] gamestate = {2,2,2,2,2,2,2,2,2};

    int[][] win_positions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6} , {1,4,7} , {2,5,8} , {0,4,8} , {2,4,6}};

    public void playertap(View view)
    {
        ImageView img = (ImageView) view;
        int tappedimg = Integer.parseInt(view.getTag().toString());
        if(gamestate[tappedimg] == 2)
        {
             gamestate[tappedimg] = activeplayer;
             img.setTranslationY(-1000f);

             if (activeplayer == 0) {
                 textView = findViewById(R.id.textView);
                 textView.setText("O's turn");
                 img.setImageResource(R.drawable.cross);
                 activeplayer = 1;
             }
             else
             {
                 textView = findViewById(R.id.textView);
                 textView.setText("X's turn");
                 img.setImageResource(R.drawable.zero);
                 activeplayer = 0;
             }
             img.animate().translationYBy(1000f).setDuration(300);
        }

        //check for any player won:

        for(int[] winpos : win_positions){
            if(gamestate[winpos[0]] == gamestate[winpos[1]] && gamestate[winpos[1]] == gamestate[winpos[2]] && gamestate[winpos[0]] != 2 )
            {
                // Finding out who is won:
                String res;
                        if(gamestate[winpos[0]] == 0)
                        {
                            res = " X has won";
                            textView = findViewById(R.id.textView);
                            textView.setText(res);
                        }
                        else{
                            res = "O has won";
                            textView = findViewById(R.id.textView);
                            textView.setText(res);
                        }
            }
        }

    }

    public void reset(View view)
    {
//        ImageView img = (ImageView) view;
        textView = findViewById(R.id.textView);
        textView.setText(" ");

         activeplayer = 0;
         for (int i=0; i < gamestate.length; i++){
             gamestate[i] = 2;
         }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}