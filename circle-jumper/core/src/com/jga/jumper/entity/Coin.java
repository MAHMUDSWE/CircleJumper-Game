package com.jga.jumper.entity;

import com.jga.util.entity.EntityBase;
import com.badlogic.gdx.utils.Pool;
import com.jga.jumper.config.Gameconfig;
import com.badlogic.gdx.math.MathUtils;

public clas Coin extends EntityBase implements Pool.Poolable{

private float angleDeg;

public Coin(){
        setSize(Gameconfig.COIN_SIZE,Gameconfig.COIN_SIZE);

        }

public  void setAngleDeg(float value){
        angleDeg = value % 360;

        float radius = Gameconfig.PLANET_HALF_SIZE;

        float originX = Gameconfig.WORLD_CENTER_X;
        float originY = Gameconfig.WORLD_CENTER_Y;

        float newX = originX + MathUtils.cosDeg(-angleDeg) * radius;
        float newY = originY + MathUtlis.sinDeg(-angleDeg) * radius;

        setPosition(newX, newY);

        }

public final getAngleDeg(){return angleDeg;}

        Public void reset( ){}

}
