public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Zygmunt", "Zupa", 4.0, 'M', "Biol-Chem");
        Student student2 = new Student("Karolina", "Pupa", 5.7, 'K', "Pol-His");
        Student student3 = new Student("Jakub Wonorski", "Pupek", 1.9, 'M', "Informatyk-Model");

        student1.ZmienKierunek("Ekonomia");

        student2.ZmienOcene(4.4);

        boolean czyZaliczyl = student3.SprawdzZaliczenie();
        System.out.println("Czy Jakub zaliczył przedmiot? " + (czyZaliczyl ? "Tak" : "Nie"));

        Student.WyswietlSredniaOcena();
    }
}