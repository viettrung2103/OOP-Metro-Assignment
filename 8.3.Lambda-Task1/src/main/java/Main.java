import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        Person person1 = new Person("Tom", 22, "Vanta");
        Person person2 = new Person("Adam", 25, "Helsinki");
        Person person3 = new Person("Eve", 10, "Espoo");
        Person person4 = new Person("George", 15, "New York");

        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);


        Comparator<Person> comparator = (personA, personB) -> {
            if (personA.getAge() > personB.getAge()) {
                return 1;
            } else if (personA.getAge() == personB.getAge()) {
                return 0;
            } else {
                return -1;
            }
        };
        System.out.println("Origin");
        for (Person person : people) {
            System.out.println(person);

        }
        System.out.println("Sorted");
        people.sort(comparator);
        for (Person person : people) {
            System.out.println(person);

        }
        System.out.println("Filtered");
        people.removeIf(person -> !person.getCity().equals("New York"));
        for (Person person : people) {
            System.out.println(person);
        }
    }


}
