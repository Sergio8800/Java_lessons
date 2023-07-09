package lesson4;

import java.util.LinkedList;
import java.util.Random;


// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
public class ListLink {
    public static void main(String[] args) {
        LinkedList<Integer> numb = new LinkedList<>();
        numb = random_arr(100, 20);
        System.out.println("список  " + "\n" + numb);
        System.out.println("список инверсионный  " + "\n" + invers(numb));

    }
    public static LinkedList<Integer> invers(LinkedList<Integer> arr){
        LinkedList<Integer> new_invers = new  LinkedList<Integer>();
        for (int i = 0; i < arr.size() ; i++) {
            int last_el = arr.get(arr.size()-i-1);
            new_invers.add(i, last_el);
        }
        return new_invers;
    }
    public static LinkedList<Integer> random_arr(int count, int cout_el) {
        LinkedList<Integer> list = new LinkedList<>();
        Random r = new Random();
        for (int i = 0; i < cout_el; i++) {
            int x = r.nextInt(count);
            list.add(x);
        }
        return list;
    }
}

