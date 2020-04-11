package ch.pearcenet.tui;

import ch.pearcenet.tui.input.Input;
import ch.pearcenet.tui.input.menu.Menu;

public class Main {

    public static void main(String[] args) {

        Input.openScanner();

        Menu firstMenu = new Menu("First Menu");
        Menu secondDoubleMenu = new Menu("Second Double Menu");
        Menu secondMenu = new Menu("Second Menu")
                .addOption("Second Double Menu").addMenu(secondDoubleMenu);

        Menu mainMenu = new Menu("Main Menu")
                .addOption("First Menu").addMenu(firstMenu)
                .addOption("Second Menu").addMenu(secondMenu);

        mainMenu.showMenu();
        Input.closeScanner();
    }

}
