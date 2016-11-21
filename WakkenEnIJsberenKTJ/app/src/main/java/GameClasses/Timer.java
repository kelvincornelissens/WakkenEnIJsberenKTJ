package GameClasses;

/**
 * Created by Kelvin on 21-11-2016.
 */

public class Timer {
    private int aantalSeconden;
    private ITimer listener;


    public int getAantalseconden() {
        return aantalSeconden;
    }

    public void setAantalseconden(int aantalseconden) {
        this.aantalSeconden = aantalseconden;
    }

    public ITimer getListener() {
        return listener;
    }

    public void setListener(ITimer listener) {
        this.listener = listener;
    }

    public void startTimer(){

    }
}
