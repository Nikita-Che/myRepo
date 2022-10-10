package Entity;

public interface Herbivore extends Animal {
    void eat (Plant plant);

    void deathByPredator(Predator predator);
}