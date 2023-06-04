package Menus;

import Register.EPS;
import Register.Engine;
import Users.Admin;
import Users.Doctor;
import Users.Patient;
import Users.User;

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
            System.out.println("6-test  6");
            System.out.println("7-test 7");
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
                    case 6 -> {
                        test6();
                    }
                    case 7 -> {
                        test7();
                    }
                    case 8 -> {
                        test8();
                    }
                    case 9 -> {
                        test9();
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

    void test8(){
        //Add 100^i patients to the patients hashtable, for m=10 times and averaged each result, for 1<=i<=nTest

        int nTest = 7; // Con 10^8 datos ya se rompe la memoria
        double amount = 10;
        long time = 0;
        int timesToAverage = 10;
        EPS epsHolder = new EPS("EPS for testing","Fake Address 123", "123 456 7890");

        for (int i = 0; i <  nTest; i++) {
            time = 0;   //Reset the time

            for (int j = 0; j < timesToAverage; j++) {
                //Create the list
                HashMap<Integer,Patient> patientsList = new HashMap<>();

                //Start Timer
                long start = System.nanoTime();

                //Run for an amount of times
                for(int k =0; k < amount; k++){
                    patientsList.put(k,new Patient(k,"patient0","password123",
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

    void test9(){
        // test search

        System.out.println("----TEST SEARCH----");
        System.out.println("Type the amount of items to include in the tree: ");
        EPS epsHolder = new EPS("EPS for testing","Fake Address 123", "123 456 7890");
        HashMap<Integer,Patient> patientList = new HashMap<>();
        for(int j = 1; j<8;j++) {
            int n = (int) Math.pow(10,j);//scanner.nextInt();

            System.out.println("Adding items to the HashMap");
            long startTime = System.nanoTime();
            for (int i = 0; i < n; i++) {
                Patient p = new Patient(i,"patient"+i,"password123",
                        "My Name", "My Last Name","1-1-2000","M",
                        "Calle 123","300 123 9900","correo@gmail.com",epsHolder);
                patientList.put(i,p);
            }

            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            // convert to milliseconds
            //timeElapsed /= 1000000;

            System.out.println("Execution time for adding " + n + " items to the HashMap: " + timeElapsed + " nanoseconds");

            System.out.println("Searching last in the list");
            startTime = System.nanoTime();
            patientList.get(n-1);
            endTime = System.nanoTime();

            timeElapsed = endTime - startTime;
            // convert to milliseconds

            //timeElapsed /= 1000000;
            System.out.println("Execution time for searching last item in a HashMap of " + n + " items: " + timeElapsed + " nanoseconds");

            System.out.println("Searching first in the HashMap");
            startTime = System.nanoTime();
            patientList.get(0);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            // convert to milliseconds
            //timeElapsed /= 1000000;
            System.out.println("Execution time for searching first item in a HashMap of " + n + " items: " + timeElapsed + " nanoseconds");

            System.out.println("Searching a random ID in the HashMap");
            int position = (int) (Math.random() * n);

            startTime = System.nanoTime();
            patientList.get(position);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            // convert to milliseconds
            //timeElapsed /= 1000000;
            System.out.println("Execution time for searching random ID (" + position + ") in a HashMap of " + n + " items: " + timeElapsed + " nanoseconds");
            System.out.println("---------------------");
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
            engine.testSearchEpsLL("EPS" + n);
            endTime = System.nanoTime();

            timeElapsed = endTime - startTime;
            // convert to milliseconds

            //timeElapsed /= 1000000;
            System.out.println("Execution time for searching last item in a list of " + n + " items: " + timeElapsed + " nanoseconds");

            System.out.println("Searching first in the list");
            startTime = System.nanoTime();
            engine.testSearchEpsLL("EPS0");
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            // convert to milliseconds
            //timeElapsed /= 1000000;
            System.out.println("Execution time for searching first item in a list of " + n + " items: " + timeElapsed + " nanoseconds");

            System.out.println("Searching at a random position in the list");
            int poistion = (int) (Math.random() * n);

            startTime = System.nanoTime();
            engine.testSearchEpsLL("EPS" + poistion);
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
        User user = engine.login("admin0","admin01234");


        EPS epsHolder = new EPS("EPS for testing","Fake Address 123", "123 456 7890");

        for (int i = 0; i <  nTest; i++) {
            time = 0;   //Reset the time

            for (int j = 0; j < timesToAverage; j++) {

                //create users
                for (int k = 0; k < amount; k++) {
                    this.engine.patientAdd(new Patient(k, "patient"+k, "pass123",
                            "Name", "LastName", "1-1-2000", "M",
                            "Calle 123", "300 123 9900", "correo@gmail.com", epsHolder));
                }
                //remove users
                for (int k = 0; k < amount; k++) {
                    this.engine.removeUser(user,k);
                }



                //Start Timer
                long start = System.nanoTime();

                //Thing to be measured
                for (int k = 0; k < amount-1; k++) {
                    this.engine.cancel();
                }
                this.engine.cancel();

                //End timer
                long finish = System.nanoTime();

                time += finish-start;
            }
            //Calculate the average
            time = time/timesToAverage;
            //Print the result of each iteration
            System.out.println("Restoring n="+(int) amount+" patients that have been removed tooks "+time+" nanoseconds");



            //Increment the amount of additions
            amount *= 10;
        }
    }

    void test6(){
        int nTest = 6; // Con 10^8 datos ya se rompe la memoria
        double amount = 10;
        long time = 0;
        int timesToAverage = 10;
        EPS epsHolder = new EPS("EPS for testing","Fake Address 123", "123 456 7890");

        for (int i = 0; i <  nTest; i++) {
            time = 0;   //Reset the time
            for (int j = 0; j < timesToAverage; j++) {
                //Create the tree
                TreeMap<Integer,Patient> patientsTree = new TreeMap<>();

                //Start Timer
                long start = System.nanoTime();

                //Run for an amount of times
                for(int k = 0; k < amount; k++){
                    Patient p = new Patient(k,"patient"+k,"password123",
                            "My Name", "My Last Name","1-1-2000","M",
                            "Calle 123","300 123 9900","correo@gmail.com",epsHolder);
                    patientsTree.put(p.getId(),p);
                }
                //End timer
                long finish = System.nanoTime();

                time += finish-start;
            }
            //Calculate the average
            time = time/timesToAverage;
            //Print the result of each iteration
            System.out.println("Add n="+(int) amount+" patients to a tree tooks "+time+" nanoseconds");
            //Increment the amount of additions
            amount *= 10;
        }
    }
    void test7(){
        // test search

        System.out.println("----TEST SEARCH----");
        System.out.println("Type the amount of items to include in the tree: ");
        EPS epsHolder = new EPS("EPS for testing","Fake Address 123", "123 456 7890");

        for(int j = 1; j<6;j++) {
            int n = (int) Math.pow(10,j);//scanner.nextInt();

            System.out.println("Adding items to the tree");
            long startTime = System.nanoTime();
            for (int i = 5; i < n; i++) {
                Patient p = new Patient(i,"patient"+i,"password123",
                        "My Name", "My Last Name","1-1-2000","M",
                        "Calle 123","300 123 9900","correo@gmail.com",epsHolder);
                engine.testAddPatient(p);
            }

            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            // convert to milliseconds
            //timeElapsed /= 1000000;

            System.out.println("Execution time for adding " + n + " items to the tree: " + timeElapsed + " nanoseconds");

            System.out.println("Searching last in the list");
            startTime = System.nanoTime();
            engine.testSearchPatient(n-1);
            endTime = System.nanoTime();

            timeElapsed = endTime - startTime;
            // convert to milliseconds

            //timeElapsed /= 1000000;
            System.out.println("Execution time for searching last item in a tree of " + n + " items: " + timeElapsed + " nanoseconds");

            System.out.println("Searching first in the tree");
            startTime = System.nanoTime();
            engine.testSearchPatient(0);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            // convert to milliseconds
            //timeElapsed /= 1000000;
            System.out.println("Execution time for searching first item in a tree of " + n + " items: " + timeElapsed + " nanoseconds");

            System.out.println("Searching a random ID in the tree");
            int position = (int) (Math.random() * n);

            startTime = System.nanoTime();
            engine.testSearchPatient(position);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            // convert to milliseconds
            //timeElapsed /= 1000000;
            System.out.println("Execution time for searching random ID (" + position + ") in a tree of " + n + " items: " + timeElapsed + " nanoseconds");
            System.out.println("---------------------");
        }
    }


}
