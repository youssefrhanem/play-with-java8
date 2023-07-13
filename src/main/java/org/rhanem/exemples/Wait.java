package org.rhanem.exemples;

public class Wait {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("One");
        synchronized (args) {
            System.out.println("Tow");
            args.wait(1000);
            System.out.println("Tree");
        }
    }
}
