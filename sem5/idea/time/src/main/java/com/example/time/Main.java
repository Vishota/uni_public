package com.example.time;

public class Main {
    public static void main(String[] args) {
        try {
            TimeInterval a = new TimeInterval(3600);
            TimeInterval b = new TimeInterval(33);

            System.out.println(a.compareTo(b));
            System.out.println(b.compareTo(a));

            System.out.println(a);
            System.out.println(b);
        }
        catch (BadTimeException e) {
            System.out.println("bad time");
        }


    }
}