package com.jga.jumper.common;

public class GameManager {

    public static final GameManager INSTANCE = new GameManager();

    private int score;
    private int displayScore;
    private int highScore;
    private int displayHighScore;

    private GameManager() {

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
