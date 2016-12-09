package com.kelvin.wakkenenijsberenktj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LevelActivity extends AppCompatActivity {

    DiceFragment diceFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

       // Level level = getB


        diceFragment = new DiceFragment();
        getFragmentManager().beginTransaction().replace(R.id.topPanelLevel,diceFragment).commit();

        diceFragment.setDice(new int[]{4,4,4,4});
    }


}
