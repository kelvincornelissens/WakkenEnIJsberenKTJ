package com.kelvin.wakkenenijsberenktj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import GameClasses.Game;
import GameClasses.ITimer;
import GameClasses.Level;

public class LevelActivity extends AppCompatActivity {

    DiceFragment diceFragment;
    TextView textViewTimeLeft;
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);


        textViewTimeLeft = (TextView)findViewById(R.id.LeveltextViewTimeLeft);
        diceFragment = new DiceFragment();
        getFragmentManager().beginTransaction().replace(R.id.topPanelLevel,diceFragment).commit();



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
