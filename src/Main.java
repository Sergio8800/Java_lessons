import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input num: ");
        int num = in.nextInt();
        int summ = 1;
//        System.out.printf("Name: %s  Age: %d  Height: %.2f \n", name, age, height);
        while (num > 0){
            summ *=num;
            num--;
        }
        System.out.printf("Summa: %d", summ);
        in.close();
    }
}