package Menus;

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
            System.out.println("1-test");
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

    }

    void test2(){

    }
}
