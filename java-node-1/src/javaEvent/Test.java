package javaEvent;

public class Test extends Animal{
    int num = 0;
    public Test() {
        show(this);
    }
    public Test(int num) {
        this.num = num;
        show(this);
    }

    public static void show (Animal a) {
        a.eat();
    }
    @Override
    public void eat() {
        if (num == 0) {
            System.out.println("A");
        }
        else if (num == 1) {
            System.out.println("B");
        }
    }
    
}
