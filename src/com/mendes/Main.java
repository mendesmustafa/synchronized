package com.mendes;

public class Main {

    public static void main(String[] args) {

        Printer printer = new Printer(5);
        Thread ali = new Ali(printer);
        ali.setName("Ali");
        Thread jack = new Jack(printer);
        jack.setName("Jack");

        ali.start();
        jack.start();
    }
}

class Printer {

    private int documentNumber;

    public Printer(int documentNumber) {
        this.documentNumber = documentNumber;
    }

    public synchronized void print() {
        for (int i = 1; i <= documentNumber; i++) {
            System.out.println("document no: " + i + " thread name: " + Thread.currentThread().getName());
        }
    }
}

class Ali extends Thread {

    private Printer printer;

    public Ali(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.print();
    }
}

class Jack extends Thread {

    private Printer printer;

    public Jack(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.print();
    }
}