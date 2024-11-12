package Week3.A34.Task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FibonacciWriter {
    private final static String FILENAME = "fibonaci.csv";

    public static void main(String[] args) {
        writeFibonaciFile(FILENAME);
        List<Double> fiboList = readFibonaciFile(FILENAME);
        System.out.println(fiboList);


    }

    public static List<Double> readFibonaciFile(String fileName) {
        FileReader file;
        BufferedReader bufferedstream = null;
        String line;
        String[] columnNames = new String[0];
        List<Double> fiboList = new ArrayList<>();
        boolean header = true;
        try {
            file = new FileReader(fileName);
            bufferedstream = new BufferedReader(file);

            do {
                line = bufferedstream.readLine();
                if (line != null) {
                    if (header) {
                        // first row of the file contains names of columns
                        columnNames = line.split(";");
                        header = false;
                    } else {
                        // just print data lines with column names
                        String[] columns = line.split(";");
                        for (int i = 0; i < columnNames.length; i++) {
                            double convertedData = Double.parseDouble(columns[i]);
                            System.out.print(columnNames[i] + ": " + convertedData + " -");
                            if (columnNames[i].equals("value")) {
                                fiboList.add(convertedData);
                            }

                        }
                        System.out.println();
                    }
                }
            }
            while (line != null);
        } catch (IOException e) {
            // Error output, will print to console even in case of output redirection
            System.err.println(e);
        } finally {
            try {
                // we will close the stream only if we were able to open it
                if (bufferedstream != null) bufferedstream.close();
            } catch (Exception e) {
                System.out.println("Error while closing the file " + fileName);
            }
        }
        return fiboList;
    }


    public static void writeFibonaciFile(String fileName) {
        List<Double> fiboList = createFibonaciList();
        String line;
        try (Writer writer = new FileWriter(fileName); BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            bufferedWriter.write("index;value\n");
            int i = 1;
            for (Double num : fiboList) {
                bufferedWriter.write(i + ";" + num + "\n");
                i++;
            }
            bufferedWriter.flush();
        } catch (IOException e) {
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
