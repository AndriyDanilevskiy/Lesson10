package ua.andriy.danilevskyy.hillel.service;

public class Replacer extends Thread {

    private final float[] arr;

    public Replacer(float[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        replaceAll(arr);
    }

    public void replaceAll(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
