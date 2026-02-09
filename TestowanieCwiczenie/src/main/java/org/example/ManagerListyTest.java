package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManagerListyTest {

    private ManagerListy managerListy;

    @BeforeEach
    void setUp() {
        managerListy = new ManagerListy();
    }

    @Test
    void testPustaListaNaPoczatku() {
        assertEquals(0, managerListy.pobierzRozmiar());
    }

    @Test
    void testDodajElementPoprawnie() {
        managerListy.dodajElement("A");
        managerListy.dodajElement("B");
        managerListy.dodajElement("C");

        assertEquals(3, managerListy.pobierzRozmiar());
    }
}
