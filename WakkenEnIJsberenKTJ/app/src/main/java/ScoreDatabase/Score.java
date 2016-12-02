package ScoreDatabase;

/**
 * Created by Kelvin on 2-12-2016.
 */

public class Score {

    private int score;
    private String name;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String ToString(){
        String res;
        res = Integer.toString(score) + name;
        return res;
    }
}
