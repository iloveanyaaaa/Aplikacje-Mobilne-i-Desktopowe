class Student {
    private String imie;
    private String nazwisko;
    private double ocena;
    private char plec;
    private String kierunek;

    private static double sumaOcenZaWod = 0;
    private static int liczbaStudentow = 0;

    public Student(String imie, String nazwisko, double ocena, char plec, String kierunek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.ocena = ocena;
        this.plec = plec;
        this.kierunek = kierunek;

        sumaOcenZaWod += ocena;
        liczbaStudentow++;

        WyswietlInformacje();
    }

    public void WyswietlInformacje() {
        System.out.println("Imię: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Ocena: " + ocena);
        System.out.println("Płeć: " + plec);
        System.out.println("Kierunek: " + kierunek);
    }

    public void ZmienKierunek(String nowyKierunek) {
        this.kierunek = nowyKierunek;
        System.out.println("Zmieniono kierunek studiów na: " + nowyKierunek);
        WyswietlInformacje();
    }

    public void ZmienOcene(double nowaOcena) {
        sumaOcenZaWod = sumaOcenZaWod - this.ocena + nowaOcena;
        this.ocena = nowaOcena;
        System.out.println("Zmieniono ocenę.");
        WyswietlInformacje();
    }

    public void ZmienImie(String noweImie) {
        this.imie = noweImie;
        System.out.println("Zmieniono imię.");
    }

    public void ZmienNazwisko(String noweNazwisko) {
        this.nazwisko = noweNazwisko;
        System.out.println("Zmieniono nazwisko.");
    }

    public void UstawPlec(char nowaPlec) {
        this.plec = nowaPlec;
        System.out.println("Zmieniono płeć.");
    }

    public double ObliczSredniaOcen() {
        return this.ocena;
    }

    public boolean SprawdzZaliczenie() {
        return this.ocena >= 3.0;
    }

    public static void WyswietlSredniaOcena() {
        if (liczbaStudentow > 0) {
            double srednia = sumaOcenZaWod / liczbaStudentow;
            System.out.println("Średnia ocena wszystkich studentów: " + srednia);
        } else {
            System.out.println("Brak studentów.");
        }
    }
}