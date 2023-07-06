package Lesson3;
import java.util.ArrayList;
import java.util.Collections;

import static Lesson3.Whole_num.random_arr;
//Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
public class Min_max {
    public static void main(String[] args) {
        ArrayList<Integer> list = random_arr(100);
        System.out.println(list);
        System.out.println("min = " + minimum(list));
        System.out.println("max = " + Collections.max(list));
        System.out.println("среднее = " + midle(list));
    }
    public static int minimum(ArrayList<Integer> arr){
        int min = 100_000;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i)<min) {
                min = arr.get(i);
            }
        }return min;
    }
    public static int midle(ArrayList<Integer> arr){
        int summ = 0;
        int size_arr = arr.size();
        for (int i = 0; i < arr.size(); i++) {
                summ+=arr.get(i);
            }
        int midle = summ/size_arr;

        return midle;
    }
}
