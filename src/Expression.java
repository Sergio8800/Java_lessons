import java.util.Scanner;

public class Expression {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        int num1 = getInt();
        int num2 = getInt();
        int num3 = getInt();
        int[] result = calc(num1, num2, num3);
        if (result[0]>0){
            System.out.println("Результат операции: " + result[0] + "+" + result[1] + "=" + result[2]);
        }
    }

    public static int getInt(){
        System.out.println("Введите число:");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getInt();
        }
        return num;
    }
    public static int[] calc(int num1, int num2, int res){
        int numNew1 = 0;
        int numNew2 = 0;
        if (res < num1*10+num2*10){
            System.out.println("Решения нет в натуральных числах ");
        } else {
            numNew1 = num1*10;
            numNew2 = res - numNew1;
        }
        int[] result = new int[]{numNew1, numNew2, res};

        return result;
    }

}