package ua.andriy.danilevskyy.hillel;

import ua.andriy.danilevskyy.hillel.service.Replacer;

import java.util.Arrays;

public class ValueCalculator {

    int size = 1000000;
    int halfSize = size / 2;
    float[] arr = new float[size];

    public void doCalc() throws InterruptedException {
        long start = System.currentTimeMillis();

        Arrays.fill(arr, 10);

        float[] a1 = new float[halfSize];
        float[] a2 = new float[halfSize];

        System.arraycopy(arr, 0, a1, 0, halfSize);
        System.arraycopy(arr, halfSize, a2, 0, halfSize);

        Thread t1 = new Replacer(a1);
        Thread t2 = new Replacer(a2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.arraycopy(a1, 0, arr, 0, halfSize);
        System.arraycopy(a2, 0, arr, halfSize, halfSize);

        long finish = System.currentTimeMillis();

        System.out.println("Duration time: " + (finish - start));
    }
}
