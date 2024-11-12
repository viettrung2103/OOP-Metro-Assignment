package Week3.A34.Task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FibonacciWriter {
    private final static String FILENAME = "fibonaci.csv";

    public static void main(String[] args) {
        writeFibonaciFile(FILENAME);


    }


    public static void writeFibonaciFile(String fileName) {
        List<Double> fiboList = createFibonaciList();
        String line;
        try (Writer writer = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            bufferedWriter.write("index; value\n");
            int i = 1;
            for (Double num : fiboList) {
                bufferedWriter.write(i + ";" + num + "\n");
                i++;
            }
            bufferedWriter.flush();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Double> createFibonaciList() {
        double number = 0;
        List<Double> fiboList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            if (i == 0) {
                number = 1;

            }
            if (i == 1) {
                number = 2;

            }
            if (i > 1) {
                number = fiboList.get(i - 2) + fiboList.get(i - 1);
            }

            fiboList.add(number);
        }
        return fiboList;
    }
}
