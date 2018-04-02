
public class Test {
	
	public static void main(String[] args) {
		Täring täring = new Täring();
		System.out.println(täring.getViseTäringud());
		
		Mängulaud laud = new Mängulaud();
		laud.käiLauale(2);
		laud.käiLauale(1);
		laud.nupuKäik(4, 0);
		
		laud.laudJoonista();
	}
}
