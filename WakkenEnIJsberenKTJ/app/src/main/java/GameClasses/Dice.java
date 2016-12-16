package GameClasses;

import java.util.Random;

/**
 * Created by Kelvin on 21-11-2016.
 *
 */

public class Dice {
    private int wakken;
    private int ijsberen;
    private int pinguins;
    private int aantalOgen;





    //Gooit een random nummer op basis van dit nummer worden de velden berekent
    public void roll(){
        Random random = new Random();

        int number = random.nextInt(6)+1;
        this.aantalOgen = number;

        if(aantalOgen%2 != 0) {
            pinguins = 7 - number;
        }else{
            pinguins = 0;
        }

        switch (number){
            case 1:
                wakken = 1;
                ijsberen = 0;

                break;

            case 2:
                wakken = 0;
                ijsberen = 0;

                break;

            case 3:
                wakken = 1;
                ijsberen = 2;
                break;

            case 4:
                wakken = 0;
                ijsberen = 0;
                break;


            case 5:
                wakken = 1;
                ijsberen = 4;
                break;


            case 6:
                wakken = 0;
                ijsberen = 0;
                break;



        }



    }

    public int getWakken() {
        return wakken;
    }

    public void setWakken(int wakken) {
        this.wakken = wakken;
    }

    public int getIjsberen() {
        return ijsberen;
    }

    public void setIjsberen(int ijsberen) {
        this.ijsberen = ijsberen;
    }

    public int getPinguins() {
        return pinguins;
    }

    public void setPinguins(int pinguins) {
        this.pinguins = pinguins;
    }

    public int getAantalOgen() {
        return aantalOgen;
    }

    public void setAantalOgen(int aantalOgen) {
        this.aantalOgen = aantalOgen;
    }
}
