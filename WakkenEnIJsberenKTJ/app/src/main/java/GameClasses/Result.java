package GameClasses;

/**
 * Created by Kelvin on 21-11-2016.
 */

public class Result {
    private int wakken;
    private int ijsberen;
    private int pinguins;


    public Result(){}

    public Result(int wakken, int ijsberen, int pinguins){
        setWakken(wakken);
        setIjsberen(ijsberen);
        setPinguins(pinguins);
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


}
