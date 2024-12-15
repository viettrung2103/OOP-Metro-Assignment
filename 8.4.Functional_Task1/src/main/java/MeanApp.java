import java.util.ArrayList;
import java.util.Arrays;

public class MeanApp {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 3, 2, 5, 6, 7, 10, 15));

        double result = findMean(numbers);
        System.out.println(result);
    }

    public static double findMean(ArrayList<Integer> numbers) {
        double result = numbers.stream().reduce(0, (subtotal, element) -> subtotal + element);
        result = result / numbers.size() * 1.0;
//        System.out.println(result);

        return result;
    }
}
