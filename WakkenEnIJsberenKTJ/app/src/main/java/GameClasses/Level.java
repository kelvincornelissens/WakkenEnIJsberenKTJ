package GameClasses;

/**
 * Created by Kelvin on 21-11-2016.
 */

public class Level {

    int pogingenVoorHint;
    boolean pinguins;
    int aantalSeconden;
    int aantalDice;

    public int getAantalSeconden() {
        return aantalSeconden;
    }

    public void setAantalSeconden(int aantalSeconden) {
        this.aantalSeconden = aantalSeconden;
    }

    public boolean isPinguins() {
        return pinguins;
    }

    public void setPinguins(boolean pinguins) {
        this.pinguins = pinguins;
    }

    public int getPogingenVoorHint() {
        return pogingenVoorHint;
    }

    public void setPogingenVoorHint(int pogingenVoorHint) {
        this.pogingenVoorHint = pogingenVoorHint;
    }

    public int getAantalDice(){

        return  aantalDice;

    }

    public void setAantalDice(int aantalDice){
        this.aantalDice = aantalDice;
    }

    public Level(int pogingenVoorHint, boolean pinguins, int aantalSeconden,int aantalDice){
        this.pogingenVoorHint = pogingenVoorHint;
        this.pinguins = pinguins;
        this.aantalSeconden = aantalSeconden;
        this.aantalDice = aantalDice;
    }


}
