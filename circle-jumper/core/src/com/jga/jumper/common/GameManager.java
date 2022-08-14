package com.jga.jumper.common;

public class GameManager {

    public static final GameManager INSTANCE = new GameManager();
    private static final String HIGH_SCORE_KEY = "highScore";
    private int score;
    private int displayScore;
    private int highScore;
    private int displayHighScore;
    private Preferences prefs;

    private GameManager() {

        prefs =  Gdx.app.getPreferences(CircleJumperGame.class.getSimpleName());
        highScore = prefs.getInterger(HIGH_SCORE_KEY, 0);
        displayHighScore = highScore ;

    }

    public void reset() {
        score = 0;
        displayScore = 0;
    }

    public void addScore(int amount) {
        score += amount;

        if (score > highScore) {
            highScore = score;
        }
    }
        public void updateHighScore(){
         if(score<highScore)
         {
             return ;
         }
         highScore = score;
         prefs.putInterger(HIGH_SCORE_KEY, highScore);
         prefs.flush();
        }
    public void updateDisplayScore(float delta) {
        if (displayScore < score) {
            displayScore = Math.min(score, displayScore + (int) (100 * delta));
        }
        if (displayHighScore < highScore) {
            displayHighScore = Math.min(highScore, displayHighScore + (int) (100 * delta));
        }
    }

    public int getDisplayScore() {
        return displayScore;
    }

    public int getDisplayHighScore() {
        return displayHighScore;
    }
}
