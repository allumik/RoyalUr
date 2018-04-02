
public class TavalineRuut implements Ruut {

	private String tähis;
	
	TavalineRuut() {
		this.tähis = "✦";
	}
	
	TavalineRuut(String tähis) {
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
