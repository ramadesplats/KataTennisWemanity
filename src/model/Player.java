package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
* <h1>The base class for a Player object</h1>
*
* @author  Rama DESPLATS
* @version 1.0
* @since   2018-06-04
*/
public class Player {

	/**
    * Player internal identifier
    */
	private UUID playerId;
	
	/**
    * Player's first name
    */
	private String firstName;
	
	/**
    * Player's last name
    */
	private String lastName;
	
	/**
    * Player's played games
    */
	private List<Game> games;
	
	/**
    * A constructor for the player object
    */
	public Player(String _firstName, String _lastName){
		this.playerId = UUID.randomUUID();
		this.firstName = _firstName;
		this.lastName = _lastName;
		this.games = new ArrayList<Game>();
	}

	/**
     * {@link Player#playerId}
     */
	public UUID getPlayerId() {
		return playerId;
	}

	/**
     * {@link Player#playerId}
     */
	public void setPlayerId(UUID playerId) {
		this.playerId = playerId;
	}

	/**
     * {@link Player#firstName}
     */
	public String getFirstName() {
		return firstName;
	}

	/**
     * {@link Player#firstName}
     */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
     * {@link Player#lastName}
     */
	public String getLastName() {
		return lastName;
	}

	/**
     * {@link Player#lastName}
     */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
     * {@link Player#computedName}
     */
	public String getComputedName() {
		return firstName + " " + lastName;
	}
	
	/**
     * {@link Player#games}
     */
	public void addGame(Game game){
		this.games.add(game);
	}

}
