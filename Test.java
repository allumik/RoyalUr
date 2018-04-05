
public class Test {
	
	public static void main(String[] args) {
	    Mängukaart mängukaart = new Mängukaart();
	    mängukaart.liigu(0,2,3);
        for (String[] tähised : Kujutaja.kujuta(mängukaart)) {
            System.out.println(tähised[0] + tähised[1] + tähised[2]);
        }
	}
}
