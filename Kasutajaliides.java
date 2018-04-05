import java.util.Scanner;

public class Kasutajaliides {

    private Scanner sc = new Scanner(System.in);
    private int nupuvalik;

    public int nupuvalimine() {
        System.out.println("Kui soovid tuua lauale uue nupu, sisesta 0. Kui soovid liigutada olemasolevat, sisesta selle number vastavalt mitmes ta laual on. ");
        nupuvalik = sc.nextInt();
        return nupuvalik;
    }

    public int getNupuvalik() {
        return nupuvalik;
    }
}