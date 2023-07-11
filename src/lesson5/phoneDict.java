package lesson5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class phoneDict {
    static Scanner scanner = new Scanner(System.in);
    private static HashMap<String, String> phName= new HashMap<String,String>();
    public static void main(String[] args) {
        inputName();
        printPhonebook();
        System.out.println(FindSurname());
    }
    public static void inputName(){
        while (true) {
            System.out.println("Введите имя или 1: ");
            String name = scanner.next();
            if (name.equals("1")){
                System.out.println("ввод закончен...");
                break;
            }
            System.out.println("Введите номер: ");
            String phone = scanner.next();
//            добавляем новый телефон к имени
            if (phName.containsKey(name)){
               String savePhone = phName.get(name);
               phone += ", " + savePhone;

            }
            phName.put(name,phone);

        }

    }
  /* вывод справочника в консоль */
    public static void printPhonebook(){
        System.out.println("Телефонный справочник: ");
        for(Map.Entry<String,String> k: phName.entrySet()){
            System.out.println(k.getValue()+": "+ k.getKey());
        }
    }
//    поиск по имени
    public static String FindSurname(){
        System.out.println("Введите имя или 1: ");
        String name = scanner.next();
        String result = phName.get(name);
        if (result == null) return "абонент не найдей";
        return result;
    }


}
