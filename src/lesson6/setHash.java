package lesson6;

import java.util.*;

public class setHash {
    public static void main(String[] args) {
        int[] arr = randomArr(20);
        for (int el: arr){
            System.out.print(el + " ");
        }
        System.out.println(" - ");
        System.out.println(Arrays.toString(arr));
        System.out.println(uniqSum(arr));
    }
    public static int[] randomArr(int a){
        int[] result = new int[a];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int)(Math.random()*100);
        }
        return result;
    }
    public static double uniqSum(int[] arr){
        HashSet<Integer> intHash = new HashSet<>();
        int summ = 0;

        for (int el: arr){
            summ = summ + el;
            intHash.add(el);
        }
        double result = intHash.size()*100/arr.length;
        return result;
    }
}
