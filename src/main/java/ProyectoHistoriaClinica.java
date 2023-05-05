import Menus.MainMenu;
import Register.EPS;
import Register.Engine;
import Users.Doctor;
import Users.Patient;

import javax.swing.*;
import java.util.Scanner;

public class ProyectoHistoriaClinica {
    public static void main(String[] args) {
        EPS m = new EPS("salud","1","1");
        Doctor s = new Doctor("s",m,2,"lelo","mns","s","s","s","s","s","s","s");

        Patient ana = new Patient(1,"m","1","m","m","m","m","m","1","m",m);
        s.addPatient(ana);
        /* Uso el mismo scanner para casi todo , pasandolo por los menus */
        Scanner scanner = new Scanner(System.in);
        Engine engine = new Engine();
        MainMenu mainMenu = new MainMenu(scanner,engine);
        mainMenu.run();
    }
}
