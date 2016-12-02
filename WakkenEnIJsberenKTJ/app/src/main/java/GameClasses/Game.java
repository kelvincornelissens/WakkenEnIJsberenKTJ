package GameClasses;

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

    public Dice[] getDices(){

        return dices;
    }

    public Game(){
        this.timer = new Timer();

    }

    public Game(Level level){
        this();
        setLevel(level);
    }

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

    public void start(){

        throwDice();
        timer.startTimer();




    }


    private void throwDice(){

        for(Dice dice : dices){
            dice.roll();
        }
    }


}
