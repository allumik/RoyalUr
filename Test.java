

public class Test {

    public static void main(String[] args) {

        Mängukaart mängukaart = new Mängukaart();

        Kasutajaliides kasutaja = new Kasutajaliides();

        Täring täring = new Täring();

        System.out.println("Teretulemast mängima iidset sumerite kõrgklassi mängu! \nMängulaud on selline, eesmärk on jõuda lõppu (alumine ☐) \nValge alustab");

        while (mängukaart.getValgedLõpus().size() != 7 || mängukaart.getMustadLõpus().size() != 7) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            int nupuvalik;
            String olek = "";
            while (true) {
                if (!olek.equals("-")) {
                    System.out.println("Valge viskab täringu.");
                    täring.täringuvise();
                } else {
                    System.out.println("Nurjutud liigutus");
                }
                System.out.println(täring.getViseTäringud() + "\nJa liigub edasi " + täring.getVise() + " käiku.");
                System.out.println("Nuppude seis mängus  -->" + mängukaart.getValgedTeel());
                System.out.println("Nuppude seis alguses -->" + mängukaart.getValgedAlguses());
                System.out.println("Nuppude seis lõpus   -->" + mängukaart.getValgedLõpus());

                System.out.println("Mängu seis:");
                for (String[] tähised : Kujutaja.kujuta(mängukaart)) {
                    System.out.println(tähised[0] + tähised[1] + tähised[2]);
                }

                System.out.println("\n:Valge Käik:");
                nupuvalik = kasutaja.nupuvalimine();
                if (nupuvalik == -1) {
                    System.out.println();
                    break;
                }
                olek = mängukaart.liigu(täring.getVise(), 1, nupuvalik);

                System.out.println(olek);
                if (!olek.equals("+") && !olek.equals("-")) {
                    break;
                }
            }
            while (true) {
                if (!olek.equals("-")) {
                    System.out.println("Must viskab täringu.");
                    täring.täringuvise();
                } else {
                    System.out.println("Nurjutud liigutus");
                }
                System.out.println(täring.getViseTäringud() + "\nJa liigub edasi " + täring.getVise() + " käiku.");
                System.out.println("Nuppude seis mängus  --> " + mängukaart.getMustadTeel());
                System.out.println("Nuppude seis alguses --> " + mängukaart.getMustadAlguses());
                System.out.println("Nuppude seis lõpus   --> " + mängukaart.getMustadLõpus());

                System.out.println("Mängu seis:");
                for (String[] tähised : Kujutaja.kujuta(mängukaart)) {
                    System.out.println(tähised[0] + tähised[1] + tähised[2]);
                }

                System.out.println("\n:Musta Käik:");
                nupuvalik = kasutaja.nupuvalimine();
                if (nupuvalik == -1) {
                    break;
                }
                olek = mängukaart.liigu(täring.getVise(), 2, nupuvalik);

                if (!olek.equals("+") && !olek.equals("-")) {
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
