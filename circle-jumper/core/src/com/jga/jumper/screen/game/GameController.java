package com.jga.jumper.screen.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.Logger;
import com.jga.jumper.config.GameConfig;
import com.jga.jumper.entity.Monster;
import com.jga.jumper.entity.Planet;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;

public class GameController {

    private static final Logger log = new Logger(GameController.class.getName(), Logger.DEBUG);
    // == attributes ==
    private Planet planet;
    private Monster monster;

    private final Array<Coin> coins= new Array<Coin>();
    private final Pool<Coin> coinPool = Pools.get(Coin.class,10);
    private final coinTimer;

    private float monsterStartX;
    private float monsterStartY;

    private boolean calledUpdate = false;

    //==constructors==
    public GameController() {
        init();

    }

    private void init() {
        planet = new Planet();
        planet.setPosition(GameConfig.WORLD_CENTER_X, GameConfig.WORLD_CENTER_Y);

        monsterStartX = GameConfig.WORLD_CENTER_X - GameConfig.MONSTER_HALF_SIZE;
        monsterStartY = GameConfig.WORLD_CENTER_Y + GameConfig.PLANET_HALF_SIZE;

        monster = new Monster();
        monster.setPosition(
                monsterStartX, monsterStartY

        );
    }

    public void update(float delta) {

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && monster.isWalking()) {
            monster.jump();
        }

        monster.update(delta);
        spawnCoins(delta);

    }

    public Planet getPlanet() {
        return planet;
    }

    public Monster getMonster() {
        return monster;
    }

    private Array<Coin>getcoins()
    {
        return coins;

    }

    private void spawnCoins(float delta)
    {
        coinTimer+=delta;

        if(coins.size >= gameconfig.MAX_COINS)
        {
            coinTimer=0;
            return;

        }


        if(coinTimer >= Gameconfig.COIN_SPAWN_TIME)
        {
           coinTimer=0;
           Coin coin = CoinPool.obtain();
           float  randomAngle = MathUtlis.random(360);
           coin.setAngleDeg(randomAngle);
           coins.add(coin);


        }
    }
}
