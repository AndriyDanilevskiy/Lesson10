package ua.andriy.danilevskyy.hillel;

import java.util.Arrays;

import static ua.andriy.danilevskyy.hillel.service.Calculation.calculateInThreads;

public class ValueCalculator {

    private final int size = 1000000;
    private final int halfSize = size / 2;
    private float[] arr = new float[size];

    public void doCalc() throws InterruptedException {
        long start = System.currentTimeMillis();

        Arrays.fill(arr, 10);

        float[] a1 = new float[halfSize];
        float[] a2 = new float[halfSize];

        System.arraycopy(arr, 0, a1, 0, halfSize);
        System.arraycopy(arr, halfSize, a2, 0, halfSize);

        calculateInThreads(a1, a2);

        System.arraycopy(a1, 0, arr, 0, halfSize);
        System.arraycopy(a2, 0, arr, halfSize, halfSize);

        long finish = System.currentTimeMillis();

        System.out.println("Duration time: " + (finish - start));
    }
}
