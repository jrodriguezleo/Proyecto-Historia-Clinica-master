package Menus;

import Register.EPS;
import Register.Engine;
import Users.Admin;
import Users.Doctor;
import Users.Patient;

import javax.print.Doc;
import java.util.*;

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
            System.out.println("3-test insertion tree");
            System.out.println("4-test  queue");
            System.out.println("5-test stack");
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
                    case 3 -> {
                        test3();
                    }
                    case 4 -> {
                        test4();
                    }
                    case 5 -> {
                        test5();
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
        for(int j = 1; j<7;j++) {
            int n = (int) Math.pow(10,j);//scanner.nextInt();

            System.out.println("Adding items to the list");
            long startTime = System.nanoTime();
            for (int i = 0; i < n; i++) {
                EPS new_eps = new EPS("EPS" + i, "calle" + i, "phone" + i);
                engine.testAddEps(new_eps);
            }

            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            // convert to milliseconds
            //timeElapsed /= 1000000;

            System.out.println("Execution time for adding " + n + " items to the list: " + timeElapsed + " nanoseconds");


            System.out.println("Searching last in the list");
            startTime = System.nanoTime();
            engine.testSearchEps("EPS" + n);
            endTime = System.nanoTime();

            timeElapsed = endTime - startTime;
            // convert to milliseconds

            //timeElapsed /= 1000000;
            System.out.println("Execution time for searching last item in a list of " + n + " items: " + timeElapsed + " nanoseconds");

            System.out.println("Searching first in the list");
            startTime = System.nanoTime();
            engine.testSearchEps("EPS0");
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            // convert to milliseconds
            //timeElapsed /= 1000000;
            System.out.println("Execution time for searching first item in a list of " + n + " items: " + timeElapsed + " nanoseconds");

            System.out.println("Searching at a random position in the list");
            int poistion = (int) (Math.random() * n);

            startTime = System.nanoTime();
            engine.testSearchEps("EPS" + poistion);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            // convert to milliseconds
            //timeElapsed /= 1000000;
            System.out.println("Execution time for searching random item (" + poistion + ") in a list of " + n + " items: " + timeElapsed + " nanoseconds");
            System.out.println("---------------------");
        }
    }

    void test2(){
        //Add 100^i patients to the patients list, for m=10 times and averaged each result, for 1<=i<=nTest

        int nTest = 6; // Con 10^8 datos ya se rompe la memoria
        double amount = 10;
        long time = 0;
        int timesToAverage = 10;

        EPS epsHolder = new EPS("EPS for testing","Fake Address 123", "123 456 7890");

        for (int i = 0; i <  nTest; i++) {
            time = 0;   //Reset the time

            for (int j = 0; j < timesToAverage; j++) {
                //Create the list
                LinkedList<Patient> patientsList = new LinkedList<>();

                //Start Timer
                long start = System.nanoTime();

                //Run for an amount of times
                for(int k =0; k < amount; k++){
                    patientsList.add(new Patient(k,"patient0","password123",
                            "My Name", "My Last Name","1-1-2000","M",
                            "Calle 123","300 123 9900","correo@gmail.com",epsHolder));
                }
                //End timer
                long finish = System.nanoTime();

                time += finish-start;
            }
            //Calculate the average
            time = time/timesToAverage;
            //Print the result of each iteration
            System.out.println("Add n="+(int) amount+" patients to a list tooks "+time+" nanoseconds");



            //Increment the amount of additions
            amount *= 10;
        }
    }
    
    void test3(){
        //Add 100^i patients to the doctors tree, for m=10 times and averaged each result, for 1<=i<=nTest

        int nTest = 6; // Con 10^8 datos ya se rompe la memoria
        double amount = 10;
        long time = 0;
        int timesToAverage = 10;

        EPS epsHolder = new EPS("EPS for testing","Fake Address 123", "123 456 7890");

        for (int i = 0; i <  nTest; i++) {
            time = 0;   //Reset the time

            for (int j = 0; j < timesToAverage; j++) {
                //Create the tree
                Set<Doctor> Listdoctors = new TreeSet<>();

                for(int k =0; k < amount; k++){
                    Listdoctors.add(new Doctor("Pediatra",epsHolder,k,"doctor"+k,"password123",
                            "My Name", "My Last Name","1-1-2000","M",
                            "Calle 123","300 123 9900","correo@gmail.com"));
                }

                int n = (int) Math.rint(amount) - 1;
                Doctor doctor = new Doctor("Pediatra",epsHolder,n,"doctor"+n,"password123",
                        "My Name", "My Last Name","1-1-2000","M",
                        "Calle 123","300 123 9900","correo@gmail.com");
                //Start Timer
                long start = System.nanoTime();

                //Run for an amount of times
                Listdoctors.remove(doctor);

                //End timer
                long finish = System.nanoTime();

                time += finish-start;
            }
            //Calculate the average
            time = time/timesToAverage;
            //Print the result of each iteration
            System.out.println("Add n="+(int) amount+" doctors to a tree tooks "+time+" nanoseconds");



            //Increment the amount of additions
            amount *= 10;
        }
    }
    void test4(){
        //Add 100^i patients to the patients list, for m=10 times and averaged each result, for 1<=i<=nTest

        int nTest = 6; // Con 10^8 datos ya se rompe la memoria
        double amount = 10;
        long time = 0;
        int timesToAverage = 10;

        EPS epsHolder = new EPS("EPS for testing","Fake Address 123", "123 456 7890");

        for (int i = 0; i <  nTest; i++) {
            time = 0;   //Reset the time

            for (int j = 0; j < timesToAverage; j++) {
                //Create the list
                Queue<Patient> patientQueue = new LinkedList<>();
                Patient patient;

                //Run for an amount of times
                for(int k =0; k < amount; k++){
                    patientQueue.add(new Patient(k,"patient0","password123",
                            "My Name", "My Last Name","1-1-2000","M",
                            "Calle 123","300 123 9900","correo@gmail.com",epsHolder));
                }
                int n = (int) Math.rint(amount) - 1;
                patient = new Patient(n,"patient0","password123",
                        "My Name", "My Last Name","1-1-2000","M",
                        "Calle 123","300 123 9900","correo@gmail.com",epsHolder);

                //Start Timer
                long start = System.nanoTime();

                //Thing to be measured
                if(patientQueue.contains(patient)) System.out.print("");

                //End timer
                long finish = System.nanoTime();

                time += finish-start;
            }
            //Calculate the average
            time = time/timesToAverage;
            //Print the result of each iteration
            System.out.println("Queue n="+(int) amount+" patients to a doctor schedule tooks "+time+" nanoseconds");



            //Increment the amount of additions
            amount *= 10;
        }
    }
    void test5(){
        //Add 100^i patients to the patients list, for m=10 times and averaged each result, for 1<=i<=nTest

        int nTest = 6; // Con 10^8 datos ya se rompe la memoria
        double amount = 10;
        long time = 0;
        int timesToAverage = 10;
        Engine engine;

        EPS epsHolder = new EPS("EPS for testing","Fake Address 123", "123 456 7890");

        for (int i = 0; i <  nTest; i++) {
            time = 0;   //Reset the time

            for (int j = 0; j < timesToAverage; j++) {
                //Create the list
                Queue<Patient> patientQueue = new LinkedList<>();
                Patient patient;

                //Run for an amount of times
                for(int k =0; k < amount; k++){
                    patientQueue.add(new Patient(k,"patient0","password123",
                            "My Name", "My Last Name","1-1-2000","M",
                            "Calle 123","300 123 9900","correo@gmail.com",epsHolder));
                }
                int n = (int) Math.rint(amount) - 1;
                patient = new Patient(n,"patient0","password123",
                        "My Name", "My Last Name","1-1-2000","M",
                        "Calle 123","300 123 9900","correo@gmail.com",epsHolder);

                //Start Timer
                long start = System.nanoTime();

                //Thing to be measured
                if(patientQueue.contains(patient)) System.out.print("");

                //End timer
                long finish = System.nanoTime();

                time += finish-start;
            }
            //Calculate the average
            time = time/timesToAverage;
            //Print the result of each iteration
            System.out.println("Queue n="+(int) amount+" patients to a doctor schedule tooks "+time+" nanoseconds");



            //Increment the amount of additions
            amount *= 10;
        }
    }
}
