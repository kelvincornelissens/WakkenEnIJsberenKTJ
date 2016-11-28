package GameClasses;

import java.util.Calendar;

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




        long currentTime = Calendar.getInstance().getTimeInMillis();
        long endTime     = currentTime + (aantalSeconden*1000);

        while (currentTime < endTime){

            try {

                if(listener != null){

                    listener.OnTimeLeftChange((int)(endTime - currentTime));
                }




                Thread.sleep(1000);
                currentTime = Calendar.getInstance().getTimeInMillis();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }



}
