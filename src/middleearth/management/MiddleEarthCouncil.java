package middleearth.management;

/**
 * Singleton class for MiddleEarthCouncil
 * The instance will hold a CharacterManager instance
 * Only one can be created
 */
public class MiddleEarthCouncil {
	/**
	 * Singleton instance
	 */
	private static MiddleEarthCouncil instance;
	/**
	 * Character manager the singleton will hold
	 */
	private CharacterManager charManager;
	
	/**
	 * Sets the character manager to a new CharacterManager when singleton is instantiated
	 */
	private MiddleEarthCouncil() {
		this.charManager = new CharacterManager();
	}
	
	/**
	 * Will create the singleton instance if it does not exist and return it, or will return the already created instance if it has been created
	 * @return council instance
	 */
	public static MiddleEarthCouncil getInstance() {
		if (instance == null) {
			instance = new MiddleEarthCouncil();
		}
		return instance;
	}
	
	/**
	 * Returns the characterManager held
	 * @return characterManager held by council
	 */
	public CharacterManager getCharacterManager() {
		return charManager;
	}
}
