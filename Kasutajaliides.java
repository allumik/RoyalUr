import java.util.Scanner;

public class Kasutajaliides {

    private Scanner sc = new Scanner(System.in);
    private int nupuvalik;

    public int nupuvalimine() {
        System.out.println("Kui soovid liigutada oma nuppu, sisesta nupule vastav number. ");
        System.out.println("Kui ei saa käia, sisesta -1 et oma käigu vahele jätta");
        System.out.print(">");
        nupuvalik = sc.nextInt();
        return nupuvalik;
    }

    public int getNupuvalik() {
        return nupuvalik;
    }
}