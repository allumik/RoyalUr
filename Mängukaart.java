import java.util.ArrayList;
import java.util.List;

public class Mängukaart {
    private Rada valged = new Rada();
    private Rada mustad = new Rada();
    private List<Integer> valgedAlguses = new ArrayList<>();
    private List<Integer> valgedLõpus = new ArrayList<>();
    private List<Integer> valgedTeel = new ArrayList<>();
    private List<Integer> mustadAlguses = new ArrayList<>();
    private List<Integer> mustadLõpus = new ArrayList<>();
    private List<Integer> mustadTeel = new ArrayList<>();

    public Mängukaart() {
        for (int i = 1; i < 8; i++) {
            valgedAlguses.add(i);
            mustadAlguses.add(i);
        }
    }

    public Rada getValged() {
        return valged;
    }

    public Rada getMustad() {
        return mustad;
    }

    public List getValgedTeel() {
        return valgedTeel;
    }

    public List getMustadTeel() {
        return mustadTeel;
    }

    public List<Integer> getValgedAlguses() {
        return valgedAlguses;
    }

    public List<Integer> getMustadAlguses() {
        return mustadAlguses;
    }

    public List<Integer> getValgedLõpus() {
        return valgedLõpus;
    }

    public List<Integer> getMustadLõpus() {
        return mustadLõpus;
    }

    private void alusta(int värv, int kivi) {
        if (värv == 1) {
            if (valgedAlguses.contains(kivi)) {
                valgedAlguses.remove(Integer.valueOf(kivi));
                valged.setNupp(kivi, 1);
                valgedTeel.add(kivi);
            }
        } else {
            if (mustadAlguses.contains(kivi)) {
                mustadAlguses.remove(Integer.valueOf(kivi));
                mustad.setNupp(kivi, 1);
                mustadTeel.add(kivi);
            }
        }
    }

    // Oletusega, et samm ei tohi 0 olla seda kutsudes
    public String liigu(int samm, int värv, int kivi) {
        String väljund = "";
        List<Integer> alguses;
        List<Integer> teel;
        List<Integer> lõpus;
        List<Integer> vastasAlguses;
        List<Integer> vastasTeel;
        List<Integer> vastasLõpus;
        Rada valitudRada;
        Rada vastasRada;
        if (värv == 1) { // Teen sümmeetriliseks
            vastasAlguses = mustadAlguses;
            vastasTeel = mustadTeel;
            vastasLõpus = mustadLõpus;
            alguses = valgedAlguses;
            teel = valgedTeel;
            lõpus = valgedLõpus;
            valitudRada = valged;
            vastasRada = mustad;
        } else {
            vastasAlguses = valgedAlguses;
            vastasTeel = valgedTeel;
            vastasLõpus = valgedLõpus;
            alguses = mustadAlguses;
            teel = mustadTeel;
            lõpus = mustadLõpus;
            valitudRada = mustad;
            vastasRada = valged;
        }
        if (valitudRada.getNupud()[1] == 0) {
            alusta(värv, kivi);
        }


        int nuppIndex = -1;
        for (int i = 0; i < valitudRada.getNupud().length; i++) {
            if (valitudRada.getNupud()[i] == kivi) {
                nuppIndex = i;
            }
        }
        if (nuppIndex == -1) {
            return "-";
        }
        //System.out.println(nuppIndex + samm);
        if (nuppIndex + samm > 14) { // kui on lõpus
            valitudRada.setNupp(0, nuppIndex);
            teel.remove(Integer.valueOf(kivi));
            lõpus.add(kivi);
            return "!";
        }
        if (valitudRada.getNupud()[nuppIndex + samm] != 0) { // Enda nupp ei tohi ka ees olla
            return "-";
        }
        if (vastasRada.getNupud()[nuppIndex + samm] != 0 && nuppIndex + samm == 8) { // kui astud rosettile ja keegi on ees
            return "-"; // ei juhtu midagi
        }
        if (4 < (nuppIndex + samm) && (nuppIndex + samm) < 13) { // Kui on keskmises reas
            if (vastasRada.getNupud()[nuppIndex + samm] == 0 && valitudRada.getNupud()[nuppIndex + samm] == 0) { // Ja ees ei ole
                valitudRada.setNupp(0, nuppIndex);
                valitudRada.setNupp(kivi, nuppIndex + samm);
                if (nuppIndex + samm == 8) { // Ja satub rosettile
                    väljund += "+"; // siis anna teada et rosettile astusid
                }
            }
            if (vastasRada.getNupud()[nuppIndex + samm] != 0) { // kui vastane on ees ja ei ole rosettil
                int vastasKivi = vastasRada.getNupud()[nuppIndex + samm];
                vastasRada.setNupp(0, nuppIndex + samm);
                vastasTeel.remove(Integer.valueOf(vastasKivi));
                vastasAlguses.add(vastasKivi);
                valitudRada.setNupp(0, nuppIndex);
                valitudRada.setNupp(kivi, nuppIndex + samm);
            }
        } else if (nuppIndex + samm < 5) { // kui on alguse juures
            valitudRada.setNupp(0, nuppIndex);
            valitudRada.setNupp(kivi, nuppIndex + samm);
            if (nuppIndex + samm == 4) { // kui on rosettil
                väljund += "+";
            }
        } else if (nuppIndex + samm > 12) { // kui on lõpu juures
            valitudRada.setNupp(0, nuppIndex);
            valitudRada.setNupp(kivi, nuppIndex + samm);
            if (nuppIndex + samm == 14) { // kui on rosettil
                väljund += "+";
            }
        }
        return väljund;

    }
}
