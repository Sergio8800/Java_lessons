package lesson2;

import java.io.*;

//3) Дана json-строка (можно сохранить в файл и читать из файла)
//        [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//        Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//        Пример вывода:
//        Студент Иванов получил 5 по предмету Математика.
//        Студент Петрова получил 4 по предмету Информатика.
//        Студент Краснов получил 5 по предмету Физика.
public class jsonSring {
    public static void main(String[] args) {
        String numbers = "";
        try {
            File file = new File(".\\src\\lesson2\\file.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            String delimeter = "\""; // Разделитель
            String[] subStr = line.split(delimeter);

            int count = 0;
            int summa_chars1=0;
            int summa_chars2=0;
            for(int i = 0; i < subStr.length; i++) {
                String el = subStr[i];


                if (el.equals("фамилия")) {
                    numbers += "Студент ";
//                    StringBuilder sb = new StringBuilder(numbers);
//                    numbers = sb.substring(0, sb.length() - 1);
                } else if (el.equals(":")) {
                    numbers += " - ";
                } else if (el.equals("оценка")) {
                    numbers += "получитл оценку ";
                } else if (el.equals("предмет")) {
                    numbers += "по предменту ";
                } else if (el.equals(",")) {
                    numbers += " ";
                }else {
                    numbers += el;
                }



           }
            String[] subStrNew = numbers.split(",");
            for (int i = 0; i < subStrNew.length; i++) {
                System.out.println(subStrNew[i]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

