package Homework.chapter10;

/**
 * @author 唐钰渤
 * @version 1.0
 */
public class homework05 {
    public static void main(String[] args) {
        new A().f1();
    }
}


class A {
    private String NAME = "tom";

    public void f1() {
        class B {
            private final String NAME = "marry";

            public void show() {
                System.out.println("A name = " + A.this.NAME + " B name = " + NAME);
            }
        }
        B b = new B();
        b.show();
    }

}