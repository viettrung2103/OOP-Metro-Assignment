import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(10, 5, 8, 20, 15, 3, 12));

        ArrayList<Integer> buffer1 = (ArrayList<Integer>) nums.clone();
        ArrayList<Integer> buffer2 = (ArrayList<Integer>) nums.clone();
        ArrayList<Integer> buffer3 = (ArrayList<Integer>) nums.clone();

        System.out.println("remove all even number");
        System.out.println(buffer1);
        buffer1.removeIf(num -> num % 2 == 0);
        System.out.println(nums);

        System.out.println("double all odd numbers");
        System.out.println(buffer2);
        buffer2.removeIf(num -> num % 2 == 0);
        buffer2.replaceAll(num -> num * num);
        System.out.println(nums);

        System.out.println("find sum");
        final int[] sum = {0};
        buffer3.forEach(num -> sum[0] += num);
        System.out.println("sum: " + sum[0]);

        System.out.println("Test my 8.3 Task 2");
    }
}
