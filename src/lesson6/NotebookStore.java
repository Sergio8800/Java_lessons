package lesson6;

//    Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//            Создать множество ноутбуков.
//            Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
//            отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию:
//            Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
//            Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Notebook {
    String model;
    String processor;
    Integer ram;
    Integer hardDisk;
    String systemOS;
    Integer price;

    public Notebook(String model, String processor, Integer ram, Integer hardDisk, String systemOS, Integer price) {
        this.model = model;
        this.processor = processor;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.systemOS = systemOS;
        this.price = price;
    }

    public String getModel() {
        return model;
    }
    @Override
    public String toString(){
        return "NoteBook:{"+"model: " + model + " processor: " + processor + " Price: " + price + " euro}";
    }
    public Integer ramOut(){
        return this.ram;
    }


    public int getPrice() {
        return price;
    }

}

public class NotebookStore {
    static Scanner scanner = new Scanner(System.in);
    private static HashMap<Integer, Notebook> nbMemory= new HashMap<Integer,Notebook>();
    public static void main(String[] args) {
        Notebook nb1 = new Notebook("Dell XPS 13 9300 TOUCH", "Intel Core i5 1035G1", 32, 2000, "Windows 11", 850);
        Notebook nb2 = new Notebook("LENOVO Laptop IdeaPad 5 ", "IIntel Core i5-1135G7", 16, 512, "Windows 10", 460);
        Notebook nb3 = new Notebook("DELL Vostro 3510 i5-1135G7", "Intel i5-1135G7", 8, 1024, "Windows 11", 730);
        Notebook nb4 = new Notebook("HP EliteBook 840 G5", "Intel® Core™ i5-8350U", 32, 256, "Windows 11", 550);
        Notebook nb5 = new Notebook("Apple MacBook Air 13", "Intel® i5 1.8GHz", 8, 256, "MacOS 10.12 Sierra", 650);
        Notebook nb6 = new Notebook("MacBook Air (2022) MLY33N/A", "Apple M2 8-core", 8, 256, "MacOS 10.12 Sierra", 1200);
        nbMemory.put(1, nb1);
        nbMemory.put(2, nb2);
        nbMemory.put(3, nb3);
        nbMemory.put(4, nb4);
        nbMemory.put(5, nb5);
        nbMemory.put(6, nb6);
        System.out.println(FindNB(nbMemory));

    }
    public static Object FindNB(HashMap<Integer,Notebook> hm){
        System.out.println("Введите объем оперативной памяти: ");
        Integer memory = scanner.nextInt();
        HashMap<Integer, Notebook> hs = hm;
//        Object result = hs.get(memory);
        Object result = new Object();
        Notebook res;
        ArrayList<Notebook> resArr = new ArrayList<>();

        for (int i = 1; i < hs.size(); i++) {
            res = hs.get(i);
            if (memory == res.ram){
                result = res;
                resArr.add(res);
            }
        }
        if (result == null) return "не найден с такими параментрами ";
        return resArr.toString();
    }
}
