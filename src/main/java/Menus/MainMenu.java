package Menus;
import Register.Engine;
import java.util.Scanner;

public class MainMenu {
    /**
     * Menu principal donde se diferencia si se hace la ejecución normal(ingresar como
     * usuario para hacer visualizaciones y/o modificaciones) , o para hacer test sobre el
     * rendimiento en las estructuras de datos
     */
    Scanner scanner;
    Engine engine;
    public MainMenu(Scanner scanner,Engine engine){
        this.scanner = scanner;
        this.engine = engine;
    }

    public void run(){
        int option = -1;
        while(option!= 0){
            System.out.println("----MAIN MENU----");
            System.out.println("Choose one option:");
            System.out.println("1-Normal execution");
            System.out.println("2-Running tests");
            System.out.println("0-Exit");
            try {
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> {
                        normalExecution();
                    }
                    case 2 -> {
                        testExecution();
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
    public void normalExecution(){
        NormalMenu normalMenu = new NormalMenu(this.scanner,this.engine);
        normalMenu.run();
    }
    public void testExecution(){
        TestMenu testMenu = new TestMenu(scanner);
        testMenu.run();
    }
}