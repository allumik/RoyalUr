
public class Nupp implements Ruut{

	private int pool; // "valge", "must" vastavalt 1, 2
	private String tähised = "◆◇"; // eeldada et tulevad paaris valge-must e. "◆◇"
	
	public Nupp(int pool) {
		this.pool = pool;
	}
	
	public int getPool() {
		return pool;
	}

	@Override
	public String toString() {
		String[] tähi = tähised.split("");
		if (pool == 1) return tähi[0];
		return tähi[1];
	}
	
	@Override
	public void setTähis(String tähised) {
		this.tähised = tähised;
	}
}
