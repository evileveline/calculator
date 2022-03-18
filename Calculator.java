import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        startCalc();

        while (true) {

            System.out.print("Введите арифметическую операцию: ");
            String line = scanner.nextLine();

            if (line.equals("exit")) {
                exitCalc();
                break;
            }

            if (line.contains("IIII")) {
                System.out.print("Ошибка: неверное написание римского числа (чисел).");
                break;
            }

            try {
                String[] symbols = line.split(" ");
                if (symbols.length != 3) throw new Exception("Ошибка: неверный формат математической операции. Попробуйте заново.");

                Number firstNumber = NumberService.parseAndValidate(symbols[0]);
                Number secondNumber = NumberService.parseAndValidate(symbols[2], firstNumber.getType());
                String result = ActionService.calculate(firstNumber, secondNumber, symbols[1]);
                System.out.println(result);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                exitCalc();
                break;
            }
        }

        scanner.close();
    }

    private static void startCalc() {

        System.out.println("Добро пожаловать в примитивный калькулятор на Java.");
        System.out.println("Калькулятор умеет работать с целыми числами от 0 до 10 в римской или арабской системе счисления.");
        System.out.println("Выполняет только простейшие операции - сложение (+), вычитание (-), умножение (*) и деление (/).");
        System.out.println("Пример ввода данных: x + y");
        System.out.println("Если Вы хотите покинуть программу, введите 'exit'");
    }

    private static void exitCalc() {

        System.out.println("Завершение работы.");

    }
}