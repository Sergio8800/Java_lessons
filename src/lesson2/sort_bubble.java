package lesson2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class sort_bubble {
    static Logger logger = Logger.getLogger(sort_bubble.class.getName());

    public static void main(String[] args) {
        try {
            FileHandler fh = new FileHandler(".\\src\\lesson2\\log2.txt");
            SimpleFormatter sFormator = new SimpleFormatter();
            fh.setFormatter(sFormator);
            logger.log(Level.INFO, "lesson2/log2.txt");
        }catch (Exception e){
            logger.log(Level.WARNING, e.getMessage());
        }

        int[] mas = {11, 3, 14, 16, 7, 2, 23, 5, 16, 9};
        mas = sortBubl(mas);
        System.out.println(Arrays.toString(mas));
        writeToFile(".\\src\\lesson2\\log.txt", mas);
    }


   public static int[] sortBubl(int[] mas) {
        boolean isSorted = false;

        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] > mas[i + 1]) {
                    isSorted = false;

                    buf = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = buf;
                    }
                }
            }
        return mas;
    }
    static void writeToFile(String file, int[] data){
        try (BufferedWriter writer = new BufferedWriter( new FileWriter(file))){
            for (int integer : data){
                writer.write(integer + "\n");
            }

        }catch(IOException e){
            System.out.println("Error" + e.getMessage());
            logger.log(Level.WARNING, e.getMessage());

        }
    }
}


