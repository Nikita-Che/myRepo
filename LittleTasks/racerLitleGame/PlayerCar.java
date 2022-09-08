package com.javarush.games.racer;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Key;

public class PlayerCar extends GameObject{
    private static int playerCarHeight = ShapeMatrix.PLAYER.length;
    public int speed =1;
    private Direction direction;



    public void move (){
        if(direction==Direction.LEFT){
            this.x = super.x - 1;
        }
        if(direction==Direction.RIGHT){
            this.x = super.x + 1;
        }
    }



    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public PlayerCar() {
        super(RacerGame.WIDTH / 2 + 2, RacerGame.HEIGHT - playerCarHeight - 1, ShapeMatrix.PLAYER);
    }
}
