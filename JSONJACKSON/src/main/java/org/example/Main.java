package org.example;
import javax.swing.SwingUtilities;
import org.example.MainFrame;
/* Dlaczego format JSON jest lepszy od zwykłego pliku tekstowego (.txt) przy zapisywaniu obiektów?
Format JSON jest bardziej uniwersalny, łatwiejszy w manipulacji oraz czytelniejszy zarówno dla ludzi, jak i maszyn.

        // Co się stanie, jeśli w klasie Student zabraknie pustego konstruktora podczas próby deserializacji przez bibliotekę Jackson?
        Jackson nie będzie w stanie utworzyć obiektu tej klasy, co spowoduje wystąpienie błędu podczas deserializacji.

        // Do czego służy słowo kluczowe transient w kontekście serializacji?
        Słowo kluczowe transient oznacza, że dane pole nie będzie zapisywane podczas serializacji obiektu.*/
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}