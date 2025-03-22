package javaMath;
public class Demo {
    public static void main(String[] args) {
        Animal animal = Animal.getInstance();
        Animal animal1 = Animal.getInstance();
        System.out.println(animal == animal1);//true
    }
}

class Animal{
    private static final Animal animal = new Animal();
    public static Animal getInstance() {
        return animal;
    }
    private Animal() {  
    }
}
