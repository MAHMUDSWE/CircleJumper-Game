

package com.jga.jumper.common;
import com.badlogic.gdx.utils.Pool;



public class FloatingScore implements Pool.Poolable{

    // attributes
    private  Color color = color.WHITE;

    private int score;
    private  float startX;
    private  float startY;
    private  float timer;
    // constructors
    public FloatingScore()
    {

    }
    // public methods
    public void update(float delta){
        if(isFinished()) {
            return;
        }
        timer+=delta;
    }
    public boolean isFinished(){
        return timer>=GameXConfig.FLOATING_DURATION;
    }

    public void setStartPosition(float startX,float startY)
    {
        this.startX =startX;
        this.startY=startY;

    }

    public  void setScore(int score){
        this.score=score;

    }
    public  float getX(){
        return  startX;
    }
    public  float getY(){
        return startY;
    }
    public Color getColor(){
        return  color;

    }
    public  String getScoreString(){
        return.Interger.toString(score);
    }
    public void reset(){


    }

}