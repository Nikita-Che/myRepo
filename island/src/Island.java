import GameField.GameField;

public class Island {
    public static void main(String[] args) {
        System.out.println("Hello Island");

        GameField gameField = new GameField();
        gameField.initialize();
        gameField.print();
    }
}
