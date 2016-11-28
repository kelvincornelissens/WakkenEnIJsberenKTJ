package GameClasses;

/**
 * Created by Kelvin on 21-11-2016.
 */

public class Level {

    int pogingenVoorHint;
    boolean pinguins;
    int aantalSeconden;

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

    public Level(int pogingenVoorHint, boolean pinguins, int aantalSeconden){
        this.pogingenVoorHint = pogingenVoorHint;
        this.pinguins = pinguins;
        this.aantalSeconden = aantalSeconden;

    }


}
