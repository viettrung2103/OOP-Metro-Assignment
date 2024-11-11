package Week3.A34.Task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    private final static String FILENAME = "temploki.csv";

    public static void main(String[] args) {
//        File f = new File(FILENAME);
        FileReader file;
        BufferedReader bufferedStream = null;
        String line;
        String[] columnNames = new String[0];
        boolean header = true;
        int dataCount = 0;
        double sum = 0;
        boolean canCount = false;

        try {
            file = new FileReader(FILENAME);
            bufferedStream = new BufferedReader(file);

            do {
                line = bufferedStream.readLine();
                if (line != null) {
                    if (header) {
                        columnNames = line.split(";");
                        header = false;
                    } else {
                        String[] columns = line.split(";");
                        String data;
                        for (int i = 0; i < columnNames.length; i++) {
//                            System.out.println(columnNames[i] + ": " + columns[i] + ", ");
                            data = columns[i];
                            if (data.contains("01.01.2023")){
                                canCount = true;
                            }
                            if (data.equals("*")){
                                continue;
                            }
                            if (columnNames[i].equals("UlkoTalo") && canCount) {

                                String convertedStr = data.replace(",", ".");
                                sum += Double.parseDouble(convertedStr);
                                dataCount++;
                                canCount = false;
                            }
                        }
                    }
                }
            } while (line != null);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            System.out.println("total data count: " + dataCount + " sum: " + sum);
            Double avg = sum * 1.0 / dataCount;
            System.out.printf("The average temperature for the 1st day of January 2023 %.1f oC\n",avg);
//            for (String name: columnNames){
//                System.out.println(name);
//            }
            try {
                if (bufferedStream != null) {
                    bufferedStream.close();
                }
            } catch (Exception e) {
                System.err.println("Error while closing the file " + FILENAME);
            }
        }
    }
}
