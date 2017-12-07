package MainPackage;

public class Player {
	protected String name;
	private int argent;

	public Player() {
		setArgent(10000);
		name="Lol";
	}

	public int getArgent() {
		return argent;
	}

	public void setArgent(int argent) {
		this.argent = argent;
	}
}
