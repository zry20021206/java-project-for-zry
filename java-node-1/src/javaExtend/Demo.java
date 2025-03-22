package javaExtend;
public class Demo {
    public static void main(String[] args) {
        Animal.name = "Animal";
        Animal dog = new Dog();
        eat(dog);
        Animal cat = new Cat();
        eat(cat);
    }
    public static void eat(Animal animal) {
        animal.eat();
    }
}

abstract class Animal{
    static String name;
    public abstract void eat();
}

class Dog extends Animal{
    public void eat(){
        System.out.println("Dog eat bone");
        System.out.println(name);
    }
}

class Cat extends Animal{
    public void eat(){
        System.out.println("Cat eat fish");
        System.out.println(name);
    }
}
