package lesson2;
import java.util.Scanner;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Calcul_Log {
    static Scanner scanner = new Scanner(System.in);
    static Logger logger = Logger.getLogger(Calcul_Log.class.getName());

    public static void main(String[] args) {
        try {
            double num1 = getInt();
            double num2 = getInt();
            char operation = getOperation();
            double result = calc(num1,num2,operation);
            System.out.println("Результат операции: "+result);
        } catch (Exception e){
            logger.log(Level.WARNING, e.getMessage());
        }

    }

    public static double getInt(){
        System.out.println("Введите число:");
        double num;
        if(scanner.hasNextDouble()){
            num = scanner.nextDouble();
        } else {
//            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            logger.log(Level.WARNING, "Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getInt();
        }
        return num;
    }

    public static char getOperation(){
        System.out.println("Введите операцию:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
//            System.out.println();
            logger.log(Level.WARNING, "Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
            operation = getOperation();
        }
        return operation;
    }

    public static double calc(double num1, double num2, char operation){
        double result;
        switch (operation){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
            default:
//                System.out.println("Операция не распознана. Повторите ввод.");
                logger.log(Level.WARNING, "Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());//рекурсия
        }
        return result;
    }
}
