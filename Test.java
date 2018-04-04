
public class Test {
	
	public static void main(String[] args) {
		Kasutajaliides kasutajaliides = new Kasutajaliides();
        	kasutajaliides.kysimepoolt();
        	int kasutajapool = kasutajaliides.getValitudpool(); /* küsime kasutajalt soovitud poolt (valge 1,must 2) */
        	/* kasutajaliides.nupuvalimine();
        	int nupuvalik = kasutajaliides.getNupuvalik();uue nupu voi olemasoleva valimine*/
		Täring täring = new Täring();
		System.out.println(täring.getViseTäringud());
		
		Mängulaud laud = new Mängulaud();
		laud.käiLauale(2);
		laud.käiLauale(1);
		laud.nupuKäik(4, 0);
		
		laud.laudJoonista();
	}
}
