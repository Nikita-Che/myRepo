package GameField;

import Entity.Animal;
import Entity.implimentation.Volf;
import Resourses.GameFieldResource;

public class GameField {
    Cell[][] gameFields = new Cell[GameFieldResource.HEIGHT][GameFieldResource.WEIGHT];

    public void addAnimal() {
        Volf volf = new Volf();
        volf.bith();

    }

    public void initialize () {
        for (int i = 0; i < gameFields.length; i++) {
            for (int j = 0; j < gameFields[i].length; j++) {
                gameFields[i][j] = new Cell();
            }
        }
    }

    public void print () {
        for (int i = 0; i < gameFields.length; i++) {
            for (int j = 0; j < gameFields[i].length; j++) {
                System.out.print(gameFields[i][j]);
            }
            System.out.println();
        }
    }


}

