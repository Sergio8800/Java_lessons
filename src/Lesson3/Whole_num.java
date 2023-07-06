package Lesson3;
//Пусть дан произвольный список целых чисел, удалить из него четные числа

import java.util.ArrayList;
import java.util.Random;

public class Whole_num {
    public static void main(String[] args) {
     ArrayList<Integer> list = random_arr(100);
     System.out.println(list);
     System.out.println(return_arr(list));
    }

    public static ArrayList<Integer> random_arr(int count) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int x = r.nextInt(count);
            list.add(x);
        }
        return list;
    }
    public static ArrayList<Integer> return_arr(ArrayList<Integer> arr) {
        ArrayList<Integer> list = arr;
        list.removeIf(el -> (el%2 == 0));
        return list;
    }
}
