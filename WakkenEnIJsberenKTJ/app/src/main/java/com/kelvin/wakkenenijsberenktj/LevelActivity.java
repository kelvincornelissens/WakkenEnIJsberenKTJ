package com.kelvin.wakkenenijsberenktj;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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

                int fout = -1;

                if(level.isPinguins()){
                    fout = 3 - goed;

                }else {
                    fout = 2 - goed;

                }

                //levelFragment.setGoedEnFout(goed,fout);

                if(fout == 0) {
                    Intent intent = new Intent(getApplicationContext(), LevelComplete.class);
                    intent.putExtra("level", level);
                    int time_left = (game.getTimer().getTimeLeft()/1000)*3;
                    intent.putExtra("score",time_left);
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


                if(secondsLeft < 0){
                    if(secondsLeft == -1) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(LevelActivity.this);

                        builder.setMessage(getString(R.string.TimeOut)).setTitle(getString(R.string.TimeTitle));
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {




                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getApplicationContext(), LevelActivity.class);
                                intent.putExtra("level", (Level) getIntent().getExtras().getSerializable("level"));
                                startActivity(intent);
                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();

                    }
                }else {
                    textViewTimeLeft.setText(String.valueOf(secondsLeft));


                }

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
