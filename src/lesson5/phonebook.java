package lesson5;

import java.util.*;

public class phonebook {
    static Scanner scanner = new Scanner(System.in);
    private static HashMap<String, ArrayList<Integer>> phName= new HashMap<String,ArrayList<Integer>>();
    public static void main(String[] args) {
        inputName();
        printPhonebook();
        System.out.println(FindSurname());
    }
    public static void inputName() {
        while (true) {
            System.out.println("Введите имя или 1: ");
            String name = scanner.next();
            if (name.equals("1")) {
                System.out.println("ввод закончен...");
                break;
            }
            System.out.println("Введите номер: ");
            int phone;

            if (scanner.hasNextInt()) {
                phone = scanner.nextInt();
            } else {
                System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
                phone = 0;

            }
            if (phone > 0) {
                ArrayList<Integer> phoneNum = new ArrayList<Integer>();
                if (phName.containsKey(name)) {
                    phoneNum = phName.get(name);
                    phoneNum.add(phone);
                    phName.put(name, phoneNum);
                }else {
                    phoneNum.add(phone);
                    phName.put(name, phoneNum);
                }

            }
        }
    }

    /* вывод справочника в консоль */
    public static void printPhonebook(){
        Map<Integer, Integer> result = new LinkedHashMap<>();
        System.out.println("Телефонный справочник: ");
        for(Map.Entry<String,ArrayList<Integer>> k: phName.entrySet()){
            System.out.println(k.getValue()+": "+ k.getKey());
        }
    }
    //    поиск по имени
    public static ArrayList<Integer> FindSurname(){
        System.out.println("Введите имя или 1: ");
        String name = scanner.next();
        ArrayList<Integer> result = phName.get(name);
        if (result == null) {
            System.out.println("Not find");
        }
        return result;
    }

}
