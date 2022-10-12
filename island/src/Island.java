import GameField.GameField;
import Utils.Randomizer;

public class Island {
    public static void main(String[] args) {
        System.out.println("Hello Island");

        GameField gameField = new GameField();
        gameField.initialize();
        gameField.print();
        System.out.println(Randomizer.getRandomNumber());
    }
}
