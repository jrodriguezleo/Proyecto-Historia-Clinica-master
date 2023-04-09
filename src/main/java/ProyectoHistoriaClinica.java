import Menus.MainMenu;
import java.util.Scanner;

public class ProyectoHistoriaClinica {
    public static void main(String[] args) {
        /* Uso el mismo scanner para casi todo , pasandolo por los menus */
        Scanner scanner = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu(scanner);
        mainMenu.run();
    }
}
