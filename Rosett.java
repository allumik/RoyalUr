
public class Rosett implements Ruut {

	private String tähis;
	
	Rosett() {
		this.tähis = "✩";
	}
	
	Rosett(String tähis) {
		this.tähis = tähis;
	}
	
	@Override
	public String toString() {
		return tähis;
	}

	@Override
	public void setTähis(String tähis) {
		this.tähis = tähis;
	}
	
}
