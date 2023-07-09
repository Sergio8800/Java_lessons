package lesson4;
// Реализуйте очередь с помощью LinkedList со следующими методами:enqueue() - помещает элемент в конец очереди, dequeue() -
//         возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.
import java.util.LinkedList;
import java.util.Scanner;

import static lesson4.ListLink.random_arr;
public class que {
    public static void main(String[] args) {
        LinkedList<Integer> list_test = random_arr(100, 20);
        System.out.println(list_test);
        while (!list_test.isEmpty()) {
           list_test.remove();
        }
        System.out.println(list_test);
        LinkedList<Integer> new_list = enqueue(list_test);
        System.out.println("удален элемент - " + dequeue(new_list));
        System.out.println(list_test);
        System.out.println("первый элемент из списка - "+first(list_test));
        System.out.println("список: "+list_test);
    }
    public static LinkedList<Integer> enqueue(LinkedList<Integer> arr){
        Scanner sc = new Scanner(System.in);
        boolean bl = true;
        while (bl)
        {
            System.out.println("Введите число для добавления в стек или символ для завершения:");
            int number = sc.nextInt();
            arr.addLast(number);
            System.out.println("элемент - " + number);
            System.out.println("добавлен в конец - " + arr);

            if (!sc.hasNextInt())
            {
                System.out.println("Finish...");
                sc.nextLine();
                bl  = false;

            }
        }return arr;

    }
    public static int dequeue(LinkedList<Integer> arr){
        int el_fist = arr.removeFirst();

        return el_fist;
        }
    public static int first(LinkedList<Integer> arr){
        int el_fist = arr.peekFirst();

        return el_fist;
    }
}

