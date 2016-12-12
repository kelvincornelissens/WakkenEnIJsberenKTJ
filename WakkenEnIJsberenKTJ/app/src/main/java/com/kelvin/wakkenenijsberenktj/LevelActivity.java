package com.kelvin.wakkenenijsberenktj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

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

        levelFragment.setDiceLevelListener(new DiceLevelFragment.DiceLevelListener() {
            @Override
            public void OnAnswer(Result result) {
                int goed = game.answer(result);
                int fout = 3 - goed;
             //  levelFragment.setGoedEnFout(goed,fout);


                Intent intent = new Intent(getApplicationContext(),LevelComplete.class);
                startActivity(intent);

            }
        });


        Level level = (Level) getIntent().getExtras().getSerializable("level");
        game = new Game(level,this);

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
