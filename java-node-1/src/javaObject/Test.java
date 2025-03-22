package javaObject;
public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        eat(dog);
    }
    public static void eat(Animal animal) {
        animal.eat();
    }
}

abstract class Animal {
    public abstract void eat();
}

class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
}