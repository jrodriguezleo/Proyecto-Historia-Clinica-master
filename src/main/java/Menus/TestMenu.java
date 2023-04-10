package Menus;

import Register.EPS;
import Register.Engine;
import Users.Admin;
import Users.Doctor;
import Users.Patient;

import java.util.Scanner;

public class TestMenu {
    private final Scanner scanner;
    Engine engine = new Engine();

    public TestMenu(Scanner scanner){
        this.scanner = scanner;
    }

    int askAmountIterations(){
        int n = 0;
        try {
            System.out.println("Type the amount of iterations to test");
            n = scanner.nextInt();
        }catch (Exception e){
            System.out.println("Invalid input");
        }
        return n;
    }
    public void run(){
        int option = -1;
        while(option != 0){
            System.out.println("----TEST MENU----");
            System.out.println("Choose one option:");
            System.out.println("1-test eps");
            System.out.println("2-test");
            System.out.println("0-Exit");
            try {
                option = scanner.nextInt();

                switch (option) {
                    case 1 -> {
                        test1();
                    }
                    case 2 -> {
                        test2();
                    }
                    case 0 -> {
                        System.out.println("Goodbye");
                    }
                }
            }catch (Exception e){
                System.out.println("Error " + e);
            }
        }
    }
    void test1(){
        // test search

        System.out.println("----TEST SEARCH----");
        System.out.println("Type the amount of items to include in the list: ");
        int n = scanner.nextInt();


        System.out.println("Adding items to the list");
        long startTime = System.nanoTime();
        for(int i = 0; i < n; i++){
            EPS new_eps = new EPS("EPS" + i, "calle" + i, "phone" + i);
            engine.testAddEps(new_eps);
        }

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        // convert to milliseconds
        timeElapsed /= 1000000;

        System.out.println("Execution time for adding " + n + " items to the list: " + timeElapsed + " milliseconds");


        System.out.println("Searching last in the list");
        startTime = System.nanoTime();
        engine.testSearchEps("EPS" + n);
        endTime = System.nanoTime();
    
        timeElapsed = endTime - startTime;
        // convert to milliseconds
        
        timeElapsed /= 1000000;
        System.out.println("Execution time for searching last item in a list of " + n + " items: " + timeElapsed + " milliseconds");

        System.out.println("Searching first in the list");
        startTime = System.nanoTime();
        engine.testSearchEps("EPS0");
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        // convert to milliseconds
        timeElapsed /= 1000000;
        System.out.println("Execution time for searching first item in a list of " + n + " items: " + timeElapsed + " milliseconds");

        System.out.println("Searching at a random position in the list");
        int poistion = (int) (Math.random() * n);

        startTime = System.nanoTime();
        engine.testSearchEps("EPS" + poistion);
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        // convert to milliseconds
        timeElapsed /= 1000000;
        System.out.println("Execution time for searching random item ("+ poistion + ") in a list of " + n + " items: " + timeElapsed + " milliseconds");
        
    }

    void test2(){
    }
}
