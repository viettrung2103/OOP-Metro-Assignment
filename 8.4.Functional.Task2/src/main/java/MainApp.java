import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface SumEven {
    int mySum(int sum, int element);
}


public class MainApp {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 35, 7, 8, 3, 5, 10));
        System.out.println("Odd List: ");
        System.out.println(filterEven(numbers));
        System.out.println("Double Odd List:");
        System.out.println(doubleEven(numbers));
        System.out.println("sum of Double Odd List:");
//        SumEven func = (0, element)->0 + element;
        System.out.println(sumDoubleEven(numbers));

    }

    public static List<Integer> filterEven(ArrayList<Integer> numbers) {
        List<Integer> result = numbers.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());

        return result;
    }

    public static List<Integer> doubleEven(ArrayList<Integer> numbers) {
        List<Integer> result = numbers.stream().filter(number -> number % 2 == 0).map(number -> number * number).collect(Collectors.toList());
//        List<Integer> result = numbers.stream().filter(number -> number % 2 == 0).map(number -> number * number);
        return result;
    }

    public static double sumDoubleEven(ArrayList<Integer> numbers) {
        SumEven sumEvenImpl = (currentSum, element) -> currentSum + element;

//        double result = numbers.stream().filter(num -> num % 2 == 0).mapToInt(num -> num * num).sum();
//        double result = numbers.stream().filter(num -> num % 2 == 0).mapToInt(num -> num * num).reduce(0, (currentSum, element) -> currentSum + element);
        int result = numbers.stream()
                .filter(num -> num % 2 == 0)
                .map(num -> num * num)
                .reduce(0, sumEvenImpl::mySum);
//        double result = numbers.stream().filter(num -> num % 2 == 0).mapToInt(num -> num * num).mapToDouble(num -> sumEvenImpl.mySum(0, num)).sum();

        return (double) result;
    }

}


