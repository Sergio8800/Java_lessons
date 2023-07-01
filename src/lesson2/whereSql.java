package lesson2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
public class whereSql {
    public static void main(String[] args) {
        String numbers = "select * from students where ";
        String data_where  = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

        try {
            File file = new File(".\\src\\file.txt");
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
                String  el = subStr[i];

                if (el.length()>2){
                    count++;

                    if (count%2!=0){
                        numbers = numbers.concat("(").concat(el).concat(" = ");
                        summa_chars1 = el.length();
                    } else  {
                        numbers = numbers.concat("\"").concat(el).concat("\"").concat(") ").concat(" and ");
                        summa_chars2 = el.length();
                        if (el.equals("null")){
                            StringBuilder sb = new StringBuilder(numbers);
                            numbers = sb.substring(0, sb.length()-summa_chars1 -summa_chars2 - 17);

                        }
                    }

//                    получаем строку с лишним AND
                }

            }
            System.out.println(numbers);
//            while (line != null) {
//                System.out.println(line);
//                // считываем остальные строки в цикле, если они есть
//                line = reader.readLine();
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
