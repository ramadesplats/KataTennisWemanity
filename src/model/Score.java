package model;

/**
* <h1>The Score enumeration</h1>
*
* @author  Rama DESPLATS
* @version 1.0
* @since   2018-06-04
*/
public enum Score {

	Love(0), 
    Fifteen(15),
    Thirty(30),
    Forty(40),
    Advantage(60)
    ;

    private int score;

    Score(int score) {
        this.score = score;
    }

    public int getScore() { 
        return score;
    }
}
