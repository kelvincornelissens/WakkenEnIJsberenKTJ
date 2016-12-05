package GameClasses;

import android.app.Activity;

import java.util.Calendar;

/**
 * Created by Kelvin on 21-11-2016.
 */

public class Timer {
    private int aantalSeconden;
    private ITimer listener;
    private int timeLeft;
    private Activity context;

    public int getTimeLeft(){
        return timeLeft;
    }


    public Timer(Activity context){
        this.context = context;


    }

    public int getAantalseconden() {
        return aantalSeconden;
    }

    public void setAantalseconden(int aantalseconden) {
        this.aantalSeconden = aantalseconden;
    }


    public ITimer getListener() {
        return listener;
    }

    //this listener will be called
    public void setListener(ITimer listener) {
        this.listener = listener;
    }


    //Starts the timer
    public void startTimer(){



        long currentTime = Calendar.getInstance().getTimeInMillis();
        final long endTime     = currentTime + (aantalSeconden*1000);


        while (currentTime < endTime){
            final long currentTimeT = currentTime;
            try {
                this.timeLeft = (int)(endTime - currentTime);
                if(listener != null){
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            listener.OnTimeLeftChange((int)(endTime - currentTimeT));
                        }
                    });

                }




                Thread.sleep(1000);
                currentTime = Calendar.getInstance().getTimeInMillis();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }



}
