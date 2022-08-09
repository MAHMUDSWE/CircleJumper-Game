package com.jga.jumper.screen.game;

import com.badlogic.gdx.utils.Logger;

public class GameController {

    private static final Logger log = new Logger(GameController.class.getName(), Logger.DEBUG);
    private Planet planet;
    //==constructors==
    public gameController()
    {
        init();

    }
       private void init()
       {
           planet= new Planet();
           planet.setPosition(GameConfing.WORLD_CENTER_X,GameConfig.WORLD_CENTER_Y);
       }
    public void update(float delta){}

    public Planet getPlanet() {
        return planet;
    }
}
