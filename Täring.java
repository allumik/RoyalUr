import java.util.Random;

public class Täring {

    private int vise;
    private String visetäring;

    public Täring() {
        this.vise = 0;
        this.visetäring = "";
    }

    public void täringuvise() {
        System.out.println("Viskad täringu...");
        int vise = 0;
        String visetäring = "";
        for (int i = 0; i < 4; i++) {
            Random kipp = new Random();
            int suva = kipp.nextInt(2);
            vise = vise + suva;
            if (suva == 0) visetäring = visetäring + "△";
            if (suva == 1) visetäring = visetäring + "▲";
        }
        this.visetäring = visetäring;
        this.vise = vise;
    }

    public int getVise() {
        return vise;
    }

    public String getViseTäringud() {
        return visetäring;
    }
}