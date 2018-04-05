public class Rada {

    private Ruut[] põhi = {Ruut.ALGUS, Ruut.TAVALINE, Ruut.TAVALINE, Ruut.TAVALINE, Ruut.ROSETT,
            Ruut.TAVALINE, Ruut.TAVALINE, Ruut.TAVALINE, Ruut.ROSETT, Ruut.TAVALINE, Ruut.TAVALINE,
            Ruut.TAVALINE, Ruut.TAVALINE, Ruut.TAVALINE, Ruut.ROSETT, Ruut.LÕPP};
    // ☐✦✦✦✩✦✦✦✩✦✦✦✦✦✩☐

    private Integer[] nupud = new Integer[16];

    public Rada() {
        for (int i = 0; i < nupud.length; i++) {
            nupud[i] = 0;
        }
    }

    public Ruut[] getPõhi() {
        return põhi;
    }

    public Integer[] getNupud() {
        return nupud;
    }

    public Ruut[] getKoos(int värv) {
        Ruut[] ruudud = new Ruut[16];
        for (int i = 0; i < 16; i++) {
            if (nupud[i] != 0) {
                if (värv == 1) {
                    ruudud[i] = Ruut.VALGENUPP;
                } else {
                    ruudud[i] = Ruut.MUSTNUPP;
                }
            } else {
                ruudud[i] = põhi[i];
            }
        }
        return ruudud;
    }

    public void setNupp(Integer nupp, int index) {
        this.nupud[index] = nupp;
    }
}
