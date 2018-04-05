public class Kujutaja {
    private static String VALGENUPP = "◇";
    private static String MUSTNUPP = "◆";
    private static String ALGUSRUUT = "☐";
    private static String LÕPPRUUT = "☐";
    private static String TAVALINERUUT = "✦";
    private static String ROSETTRUUT = "✩";

    public static Ruut[] koostaKõrvalRada(Rada rada, int värv) {
        Ruut[] ruudud = rada.getKoos(värv);

        return new Ruut[]{ruudud[4], ruudud[3], ruudud[2], ruudud[1], ruudud[0], ruudud[15], ruudud[14], ruudud[13]};
    }

    public static Ruut[] koosteKeskmineRada(Rada valgeRada, Rada mustRada) {
        Ruut[] valgedRuudud = valgeRada.getKoos(1);
        Ruut[] mustadRuudud = mustRada.getKoos(2);
        Ruut[] ajutisedRuudud = new Rada().getPõhi();

        for (int i = 0; i < 16; i++) {
            if (valgedRuudud[i] == Ruut.VALGENUPP) {
                ajutisedRuudud[i] = Ruut.VALGENUPP;
            } else if (mustadRuudud[i] == Ruut.MUSTNUPP) {
                ajutisedRuudud[i] = Ruut.MUSTNUPP;
            }
        }

        Ruut[] vastus = new Ruut[8];

        System.arraycopy(ajutisedRuudud, 5, vastus, 0, 8);
        return vastus;
    }

    public static String[][] kujuta(Mängukaart mängukaart) {
        String[][] vastus = new String[8][3];
        Ruut[][] ajutisedRuudud = new Ruut[3][8];

        ajutisedRuudud[0] = koostaKõrvalRada(mängukaart.getValged(), 1);
        ajutisedRuudud[1] = koosteKeskmineRada(mängukaart.getValged(), mängukaart.getMustad());
        ajutisedRuudud[2] = koostaKõrvalRada(mängukaart.getMustad(), 2);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 3; j++) {
                String tähis;
                switch (ajutisedRuudud[j][i]) {
                    case VALGENUPP:
                        tähis = VALGENUPP;
                        break;
                    case MUSTNUPP:
                        tähis = MUSTNUPP;
                        break;
                    case TAVALINE:
                        tähis = TAVALINERUUT;
                        break;
                    case ROSETT:
                        tähis = ROSETTRUUT;
                        break;
                    case ALGUS:
                        tähis = ALGUSRUUT;
                        break;
                    case LÕPP:
                        tähis = LÕPPRUUT;
                        break;
                    default:
                        tähis = LÕPPRUUT;
                }
                vastus[i][j] = tähis;
            }
        }
        return vastus;
    }
}
