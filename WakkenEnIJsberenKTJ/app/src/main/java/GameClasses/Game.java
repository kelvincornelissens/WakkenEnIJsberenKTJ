package GameClasses;

import android.app.Activity;

/**
 * Created by Kelvin on 21-11-2016.
 */

public class Game {
    private Level level;
    private Timer timer;
    private Dice[] dices;
    private int pogingen;


    public Timer getTimer(){

        return this.timer;
    }

    //Een array met dice
    public Dice[] getDices(){

        return dices;
    }

    public Game(Activity context){
        this.timer = new Timer(context);

    }

    public Game(Level level, Activity context){
        this(context);
        setLevel(level);
    }


    //set een level
    public void setLevel(Level level){

        this.level = level;
        timer.setAantalseconden(level.aantalSeconden);
        this.dices = new Dice[level.getAantalDice()];

        for(int i = 0; i < dices.length; i++){
            dices[i] = new Dice();
        }

    }

    //calculates the points
    public int answer(Result result){
        this.pogingen++;
        int ijsberen = 0,pinguins =0,wakken =0, punten =0;

        for (Dice dice : dices){
            ijsberen += dice.getIjsberen();
            pinguins += dice.getPinguins();
            wakken   += dice.getWakken();

        }

        if(ijsberen == result.getIjsberen())
            punten++;

        if (pinguins == result.getPinguins())
            punten++;

        if(wakken == result.getWakken())
            punten++;

        return punten;
    }

    public String wrongAnswer(Result result){
        int ijsberen = 0,pinguins =0,wakken =0;

        String wrong =  "";

        for (Dice dice : dices){
            ijsberen += dice.getIjsberen();
            pinguins += dice.getPinguins();
            wakken   += dice.getWakken();

        }

        if(ijsberen != result.getIjsberen())
            wrong += "ijsberen,";

        if (pinguins != result.getPinguins())
           wrong += "pinguins,";

        if(wakken != result.getWakken())
            wrong += "wakken,";

        return wrong;
    }


    //start de game
    public void start(){

        throwDice();
        timer.startTimer();




    }

    //gooi met alle stenen
    private void throwDice(){

        for(int i = 0; i < dices.length; i++){
           Dice dice = this.dices[i];
            dice.roll();

            dices[i] = dice;
        }

    }


}
