
public class TühiRuut implements Ruut {

	private String tähis;
	
	TühiRuut() {
		this.tähis = "☐";
	}
	
	TühiRuut(String tähis) {
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
