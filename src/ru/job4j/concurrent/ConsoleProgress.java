package ru.job4j.concurrent;

public class ConsoleProgress implements Runnable {
    public static void main(String[] args) {
        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        progress.interrupt();
    }

    @Override
    public void run() {
        boolean isEvil = false;
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(500);
                if (isEvil) {
                    System.out.print("\r load: " + " |/");
                } else {
                    System.out.print("\r load: " + "\\|");
                }
                isEvil = !isEvil;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
