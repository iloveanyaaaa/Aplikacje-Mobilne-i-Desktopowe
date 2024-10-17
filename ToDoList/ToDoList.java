import java.util.ArrayList;
import java.util.Scanner;
public class ToDoList {
    String imie;
    String opis;
    boolean zrobione;

    ToDoList(String name, String description) {
        this.imie = name;
        this.opis = description;
        this.zrobione = false;
    }
}
