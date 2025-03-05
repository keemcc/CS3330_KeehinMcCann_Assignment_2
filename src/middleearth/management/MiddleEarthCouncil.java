package middleearth.management;

public class MiddleEarthCouncil {
	private static MiddleEarthCouncil instance;
	private CharacterManager charManager;
	
	private MiddleEarthCouncil() {}
	
	public static MiddleEarthCouncil getInstance() {
		if (instance == null) {
			instance = new MiddleEarthCouncil();
			instance.charManager = new CharacterManager();
		}
		return instance;
	}
	
	public CharacterManager getCharacterManager() {
		return charManager;
	}
}
