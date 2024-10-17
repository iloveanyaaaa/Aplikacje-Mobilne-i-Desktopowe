import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<ToDoList> zadania = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcja;

        do {
            wybor();
            opcja = scanner.nextInt();
            scanner.nextLine();

            switch (opcja) {
                case 1 -> dodawanie();
                case 2 -> koniec();
                case 3 -> kasacja();
                case 4 -> wyswie();
                case 5 -> System.out.println("bye bye");
                default -> System.out.println("złą opcja, spróbuj jeszcze raz :)");
            }
        } while (opcja != 5);
    }

    private static void wybor() {
        System.out.println("1 Dodaj nowe zadanie");
        System.out.println("2 Oznacz zadanie jako zakończone");
        System.out.println("3 Usuń zadanie");
        System.out.println("4 Wyświetl listę zadań");
        System.out.println("5 Wyjście");
        System.out.print("Wybierz ");
    }

    private static void dodawanie() {
        System.out.print("Podaj nazwę zadania: ");
        String imie = scanner.nextLine();
        System.out.print("Podaj opis zadania: ");
        String description = scanner.nextLine();
        zadania.add(new ToDoList(imie, description));
        System.out.println("Zadanie \"" + imie + "\" zostało dodane do listy");
    }

    private static void koniec() {
        wyswie();
        System.out.print("które zadanie chcesz ukończyć?");
        int numer = scanner.nextInt();
        scanner.nextLine();

        if (isValidTaskNumber(numer)) {
            ToDoList misja = zadania.get(numer - 1);
            misja.zrobione = true;
            System.out.println("Zadanie \"" + misja.imie + "\" zostało zakończone");
        } else {
            System.out.println("zły numer.");
        }
    }

    private static void kasacja() {
        wyswie();
        System.out.print("Które usuwamy?");
        int numer = scanner.nextInt();
        scanner.nextLine();

        if (isValidTaskNumber(numer)) {
            ToDoList misja = zadania.remove(numer - 1);
            System.out.println("Zadanie \"" + misja.imie + "\" zostało usunięte");
        } else {
            System.out.println("źle");
        }
    }

    private static boolean isValidTaskNumber(int numer) {
        return numer > 0 && numer <= zadania.size();
    }

    private static void wyswie() {
        System.out.println("Lista zadań:");
        if (zadania.isEmpty()) {
            System.out.println("(brak zadań)");
        } else {
            for (int i = 0; i < zadania.size(); i++) {
                ToDoList misja = zadania.get(i);
                String status = misja.zrobione ? "[x]" : "[ ]";
                System.out.println(status + " " + misja.imie + ": " + misja.opis);
            }
        }
    }
}