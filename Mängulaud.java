import java.util.*;

public class Mängulaud {
	
	/* mängulaud, kus on laua piirded, koordinaadid mängunuppudel ja nende piirangud, ... */
	/* tiimi nupu tähised näiteks, võib küsida mängu alguses ka kasutajalt: valge-"◆"-int 1, kes alustab vasakult, ja must-"◇"- int 2, kes alustab paremalt  */
	/* laud:   
▐✩│✦│✩▌
▐✦│✦│✦▌
▐✦│✦│✦▌
▐✦│✩│✦▌
|☐│✦│☐| <-- nuppude vaikeasukoht on siin (luua sinna 7 Nupp isendit).
|☐│✦│☐| <-- nuppude lõppasukoht on siin (mäng võidetud kui seal 7 isendit).
▐✩│✦│✩▌
▐✦│✦│✦▌
	 */
	/* laud on programmis koordinaatides x = [0-7]; y = [0-2] ja ! = ei ole kasutatav ehk
(x, y)
(0, [0*,1,2*])
(1, [0,1,2])
(2, [0,1,2])
(3, [0,1*,2])
(4, [!,1,!])
(5, [!,1,!])
(6, [*0,1,2*])
(7, [0,1,2])
	 * ehk kui valge täringuvise on 2 siis Nupp nupp = (2, 0, valge(ehk 2)).
	 * on meetod käik, mis prindib välja mänguvälja, asetades õigesse kohta õige sümboli:
System.out.println("▐" + laudJoonista(0,0) + "│" + laudJoonista(0,1) + "│" + laudJoonista(0,2) + " ▌");
System.out.println("▐" + laudJoonista(1,0) + "│" + laudJoonista(1,1) + "│" + laudJoonista(1,2) + " ▌");
System.out.println("▐" + laudJoonista(2,0) + "│" + laudJoonista(2,1) + "│" + laudJoonista(2,2) + " ▌");
jne...
	 */
	/* vaja teha ka sättijad mänguvälja sümbolite tarvis, neid saab kõiki muuta */
	
	private String valge = "◆";
	private String must = "◇";
	
	private Map<String, Ruut> mänguväli = new HashMap<>();
	private List<Nupp> algusvalge = new ArrayList<>();
	private List<Nupp> algusmust = new ArrayList<>();
	private List<Nupp> finvalge = new ArrayList<>();
	private List<Nupp> finmust = new ArrayList<>();
		
	Mängulaud() {
		for (int i = 0; i < 8; i++) {
			algusvalge.add(new Nupp(1)); // valge mängija nupud
			algusmust.add(new Nupp(2)); // musta mängija nupud
			for (int n = 0; n < 3; n++) {
				Koord koord = new Koord(i,n);
				mänguväli.put(koord.getKoord(), new TühiRuut());
				kontrolliLauda(i,n);
			}
		}
	}
	
	public void kontrolliLauda(int x, int y) {
		Koord koord = new Koord(x,y);
		if (x == 4 && y == 0 || x == 5 && y == 0 || x == 4 && y == 2 || x == 5 && y == 2) {
			mänguväli.replace(koord.getKoord(), new TühiRuut());
		} else {
			mänguväli.replace(koord.getKoord(), new TavalineRuut());
			if (x == 0 && y == 0 || x == 0 && y == 2 || x == 3 && y == 1 || x == 6 && y == 0 || x == 6 && y == 2) {
				mänguväli.replace(koord.getKoord(), new Rosett());
			}
		}
	}
	
	public void käiLauale(int pool) {
		if (pool == 1) {
			Koord koord = new Koord(3,0);
			Nupp nupp = algusvalge.get(algusvalge.size()-1);
			mänguväli.replace(koord.getKoord(), nupp);
		} else {
			Koord koord = new Koord(3,2);
			Nupp nupp = algusmust.get(algusmust.size()-1);
			mänguväli.replace(koord.getKoord(), nupp);
		}
	}
	
	public void nupuKäik(int x, int y) { // ei tööta
		Koord koord = new Koord(x, y);
		mänguväli.replace(koord.getKoord(-1,0), mänguväli.get(koord.getKoord()));
		kontrolliLauda(x, y);
	}
	
	public void laudJoonista() {
		for (int i = 0; i < 8; i++) {
			String rida = "";
			Koord koord1 = new Koord(i,0);
			Koord koord2 = new Koord(i,1);
			Koord koord3 = new Koord(i,2);
			System.out.println("->" + (i+1) +"  ▐ " + mänguväli.get(koord1.getKoord()).toString() + "│" + mänguväli.get(koord2.getKoord()).toString() + "│" + mänguväli.get(koord3.getKoord()).toString() + "  ▌");
		}
	}
	
}