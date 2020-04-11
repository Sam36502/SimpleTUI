package ch.pearcenet.tui.input.menu;

import ch.pearcenet.tui.input.Input;
import ch.pearcenet.tui.output.Output;

import java.util.ArrayList;
import java.util.List;

/**
 * Menu Class
 * The menu object for the menu systems
 *
 * @author Samuel Pearce <sam @ aepearce.com>
 * @version 2.2
 */
public class Menu implements Optionable {

    private String title;

    private List<String> options;

    private List<Optionable> menus;

    /*
     * Constructors
     */

    public Menu() {
        this.title = null;
        this.options = new ArrayList<>();
        this.menus = new ArrayList<>();
    }

    public Menu(String title) {
        this.title = title;
        this.options = new ArrayList<>();
        this.menus = new ArrayList<>();
    }

    /*
     * Getters & Setters
     */

    /**
     * Gets the title of this menu
     * @return This menu's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of this menu
     * @param title The new title of this menu
     */
    public Menu setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Adds an option title to the array
     * @param option The new option to add to the list
     */
    public Menu addOption(String option) {
        this.options.add(option);
        return this;
    }

    /**
     * Gets the option titles array
     * @return This menu's option title array
     */
    public List<String> getOptions() {
        return options;
    }

    /**
     * Adds an optionable to the list of menus
     * @param menu The menu to add to the list
     */
    public Menu addMenu(Optionable menu) {
        this.menus.add(menu);
        return this;
    }

    /**
     * Gets the option menus array
     * @return This menu's option menu array
     */
    public List<Optionable> getMenus() {
        return menus;
    }

    /*
     * Optionable Methods
     */

    /**
     * Displays the options and retrieves the result
     */
    @Override
    public void showMenu() {
        int exitOption = options.size() + 1;
        boolean inMenu = true;

        while (inMenu) {
            Output.clearScreen();
            System.out.println(Output.underline(this.title, 1));

            for (int i = 0; i<options.size(); i++) {
                System.out.println((i+1) + ") " + options.get(i));
            }
            System.out.println(exitOption + ") Return/Exit");

            int choice = Input.getInt(1, exitOption) - 1;
            if (choice == exitOption - 1) {
                inMenu = false;
                continue;
            }

            menus.get(choice).showMenu();
        }
    }
}
