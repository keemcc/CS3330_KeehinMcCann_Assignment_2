package middleearth.management;

public class MiddleEarthCouncil {
	private static MiddleEarthCouncil instance;
	private CharacterManager charManager;
	
	private MiddleEarthCouncil() {
		this.charManager = new CharacterManager();
	}
	
	public static MiddleEarthCouncil getInstance() {
		if (instance == null) {
			instance = new MiddleEarthCouncil();
		}
		return instance;
	}
	
	public CharacterManager getCharacterManager() {
		return charManager;
	}
}
