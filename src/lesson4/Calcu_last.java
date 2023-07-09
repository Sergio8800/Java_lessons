package lesson4;
// В калькулятор добавьте возможность отменить последнюю операцию.

import java.util.ArrayList;
import java.util.Scanner;

public class Calcu_last {
    double [] arr;
    int top;
    public Calcu_last(){
        top = -1;
        arr = new double[100];
    }
    public void push_num(Double num){
        top++;
        arr[top]=num;

    }
    public double del_last_numb(){
        if (top == -1) {
            throw new IllegalStateException("is empty");
        }
        top--;

        return arr[top];
    }
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Calcu_last stack = new Calcu_last();
        stack.push_num(getInt());
        stack.push_num(getInt());
        char operation = getOperation();
        double result = calc(stack.arr[0],stack.arr[1],operation);
        System.out.println("Результат операции: "+result);
        if (yes_no() == false){
            stack.del_last_numb();
            stack.push_num(getInt());
            double result2 = calc(stack.arr[0],stack.arr[1],operation);
            System.out.println("Результат операции: "+result2);
        }


    }

    public static double getInt(){
        System.out.println("Введите число:");
        double num;
        if(scanner.hasNextDouble()){
            num = scanner.nextDouble();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
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
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
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
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());//рекурсия
        }
        return result;
    }
    public static boolean yes_no(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число 1 для отмены последнего ввода числа: ");
        int number = sc.nextInt();
        if (number != 1){
            System.out.println("OK, результат операции не изменился");
            System.exit(0);
        }
        return false;
    }
    public static double cancel(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите число 1 для отмены последнего ввода числа: ");
        int number = sc.nextInt();
        if (number != 1){
            System.out.println("OK, результат операции не изменился");
            System.exit(0);
        }
        return getInt();
    }

}
