package Entity.implimentation;

import Entity.Herbivore;
import Entity.Predator;
import Utils.Randomizer;

public class Volf implements Predator {
    public int x;
    public int y;

    @Override
    public void bith() {
        x = Randomizer.getRandomNumber();
        y = Randomizer.getRandomNumber();
    }

    @Override
    public void move() {

    }

    @Override
    public void fucking() {

    }

    @Override
    public void deathByHungry() {

    }

    @Override
    public void eat(Herbivore herbivore) {

    }
}
