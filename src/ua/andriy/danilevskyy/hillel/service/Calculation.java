package ua.andriy.danilevskyy.hillel.service;

public class Calculation {

    public static void calculateInThreads(float[] a1, float[] a2) throws InterruptedException {
        Thread t1 = new Replacer(a1);
        Thread t2 = new Replacer(a2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
