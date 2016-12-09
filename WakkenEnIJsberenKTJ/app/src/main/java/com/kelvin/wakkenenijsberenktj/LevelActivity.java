package com.kelvin.wakkenenijsberenktj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import GameClasses.Game;
import GameClasses.Level;

public class LevelActivity extends AppCompatActivity {

    DiceFragment diceFragment;
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        Level level = (Level) getIntent().getExtras().getSerializable("level");
        game = new Game(level,this);
        game.start();

        diceFragment = new DiceFragment();
        getFragmentManager().beginTransaction().replace(R.id.topPanelLevel,diceFragment).commit();


    }


    @Override
    protected void onResume() {
        super.onResume();
        diceFragment.setDice(game.getDices());


    }
}
