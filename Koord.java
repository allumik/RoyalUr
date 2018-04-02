
public class Koord {
	private int x;
	private int y;
	
	Koord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setKoord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String getKoord(int x, int y) { // et Mängulaud saaks nupu liigutamisel mugavamalt koordinaate muuta. (loodan et sellega ei muudeta ka jäädavalt)
		int xo = this.x;
		int yo = this.y;
		return (xo+x) + " " + (yo+y);
	}
	
	public String getKoord() {
		return this.x + " " + this.y;
	}
}
