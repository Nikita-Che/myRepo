import java.util.Scanner;
import java.util.StringTokenizer;

public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("приложение стартовало!");

        for (;;) {
            String expression = scanner.nextLine();
            if (!expression.equalsIgnoreCase("end")) {
                try {
                    double result = evaluate(expression);
                    System.out.println(expression + " = " + result);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                break;
            }
        }
        System.out.println("приложение остановилося!");
    }

    private static double evaluate(String expression) {
        StringTokenizer tokenizer = new StringTokenizer(expression, "+*/-");

        if (tokenizer.countTokens() > 2) {
            throw new IllegalArgumentException("слишком много букв");
        }
        if(tokenizer.countTokens() < 2) {
            throw new IllegalArgumentException("слишком мало букв");
        }

        String left = tokenizer.nextToken();
        String right = tokenizer.nextToken();

        double a = Double.parseDouble(left);
        double b = Double.parseDouble(right);

        if (expression.contains("+")) {
            return a + b;
        } else if (expression.contains("-")) {
            return a - b;
        } else if (expression.contains("*")) {
            if (b == 10) {
                throw new BusinessException("нельзя умножать на 10, это принцип.");
            }
            return a * b;
        } else if (expression.contains("/")) {
            if (b == 0) {
                throw new ArithmeticException("нельзя делить на Нуль");
            }
            return a / b;
        }
        throw new IllegalArgumentException("incorrect exeption" + expression);

    }

    public static class BusinessException extends RuntimeException {
        public BusinessException(String message) {
            super(message);
        }
    }

}