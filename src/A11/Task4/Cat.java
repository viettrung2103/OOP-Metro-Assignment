package A11.Task4;

public class Cat {
    private String name;
    public Cat (String name) {
        this.name = name;

    }
    public void meow(){
        System.out.println("The cat named "+this.name+" says: Meow!");
    }
    public static void main(String[] args){
        // Create an instance of the Cat class with a name
        Cat cat1 = new Cat("Whiskers");
        Cat cat2 = new Cat("Rex");
        // Call the meow method on the cat1 instance
        cat1.meow();
        cat1.meow();
        cat2.meow();
        cat1.meow();

    }

}
