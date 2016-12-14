package com.kelvin.wakkenenijsberenktj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import GameClasses.Game;
import GameClasses.ITimer;
import GameClasses.Level;
import GameClasses.Result;

public class LevelActivity extends AppCompatActivity {

    DiceFragment diceFragment;
    DiceLevelFragment levelFragment;
    TextView textViewTimeLeft;
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);


        textViewTimeLeft = (TextView)findViewById(R.id.LeveltextViewTimeLeft);
        diceFragment = new DiceFragment();
        levelFragment = new DiceLevelFragment();
        getFragmentManager().beginTransaction().replace(R.id.topPanelLevel,diceFragment).commit();
        getFragmentManager().beginTransaction().replace(R.id.downPanelLevel,levelFragment).commit();
        final Level level = (Level) getIntent().getExtras().getSerializable("level");
        game = new Game(level,this);
        TextView lvlText = (TextView)findViewById(R.id.LeveltextViewLevel);
        lvlText.setText("Level " + level.getLvlNr());

        levelFragment.setDiceLevelListener(new DiceLevelFragment.DiceLevelListener() {
            @Override
            public void OnAnswer(Result result) {
                int goed = game.answer(result);
                int fout = 3 - goed;
                //levelFragment.setGoedEnFout(goed,fout);

                if(fout == 0) {
                    Intent intent = new Intent(getApplicationContext(), LevelComplete.class);
                    intent.putExtra("level", level);
                    startActivity(intent);
                }

                if(fout > 0){
                    String wrongAnswer = "De volgende antwoorden zijn fout: " + game.wrongAnswer(result);
                    Toast.makeText(getApplicationContext(), wrongAnswer, Toast.LENGTH_SHORT).show();

                }


            }
        });




        game.getTimer().setListener(new ITimer() {
            @Override
            public void OnTimeLeftChange(int secondsLeft) {
                textViewTimeLeft.setText(String.valueOf(secondsLeft));
            }
        });

        game.start();
    }


    @Override
    protected void onResume() {
        super.onResume();
        diceFragment.setDice(game.getDices());


    }
}
