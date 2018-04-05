

public class Test {

    public static void main(String[] args) {

        Mängukaart mängukaart = new Mängukaart();

        Kasutajaliides kasutaja = new Kasutajaliides();

        Täring täring = new Täring();

        System.out.println("Teretulemast mängima iidset sumerite kõrgklassi mängu! \nMängulaud on selline, eesmärk on jõuda lõppu (alumine ☐) \nValge alustab");
        for (String[] tähised : Kujutaja.kujuta(mängukaart)) {
            System.out.println(tähised[0] + tähised[1] + tähised[2]);
        }
        while (mängukaart.getValgedLõpus().size() != 7 || mängukaart.getMustadLõpus().size() != 7) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            int nupuvalik;
            while (true) {
                System.out.println("Valge viskab täringu.");
                täring.täringuvise();
                System.out.println(täring.getViseTäringud() + "\nJa liigub edasi " + täring.getVise() + " käiku.");
                nupuvalik = kasutaja.nupuvalimine();
                String olek = mängukaart.liigu(täring.getVise(), 1, nupuvalik);

                System.out.println("Mängu seis:");
                for (String[] tähised : Kujutaja.kujuta(mängukaart)) {
                    System.out.println(tähised[0] + tähised[1] + tähised[2]);
                }
                System.out.println(olek);
                if (!olek.equals("+")) {
                    break;
                }
            }
            while (true) {
                System.out.println("Must viskab täringu.");
                täring.täringuvise();
                System.out.println(täring.getViseTäringud() + "\nJa liigub edasi " + täring.getVise() + " käiku.");
                nupuvalik = kasutaja.nupuvalimine();
                String olek = mängukaart.liigu(täring.getVise(), 2, nupuvalik);

                System.out.println("Mängu seis:");
                for (String[] tähised : Kujutaja.kujuta(mängukaart)) {
                    System.out.println(tähised[0] + tähised[1] + tähised[2]);
                }
                if (!olek.equals("+")) {
                    break;
                }
            }
        }
        if (mängukaart.getValgedLõpus().size() != 7) {
            System.out.println("Valged Võitsid");
        } else {
            System.out.println("Mustad Võitsid");
        }
    } // Praeguses seisus pead meeles hoidma mis oli kõige kaugema nupu index "nimi"
}
