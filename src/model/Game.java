package model;

import java.util.NoSuchElementException;

/**
* <h1>The base class for the Game object</h1>
*
* @author  Rama DESPLATS
* @version 1.0
* @since   2018-06-04
*/
public class Game {

	/**
    * Player one internal identifier
    */
	private Player player1;
	
	/**
    * Player two internal identifier
    */
	private Player player2;
	
	/**
    * The winner identifier
    */
	private Player winner;
		
	/**
    * True if the game is over, false else
    */
	private boolean isOver;
	
	/**
    * Player one score
    */
	private Score playerOneScore;
	
	/**
    * Player two score
    */
	private Score playerTwoScore;
	
	/**
    * A constructor for the player object
    */
	public Game(Player _player1Id, Player _player2Id){
		this.player1 = _player1Id;
		this.player2 = _player2Id;
		this.playerOneScore = Score.Love;
		this.playerTwoScore = Score.Love; 
		this.isOver = false;
	}

	/**
     * {@link Game#player1}
     */
	public Player getPlayer1() {
		return player1;
	}

	/**
     * {@link Game#player1}
     */
	public void setPlayer1Id(Player player1) {
		this.player1 = player1;
	}

	/**
     * {@link Game#player2}
     */
	public Player getPlayer2() {
		return player2;
	}

	/**
     * {@link Game#player2}
     */
	public void setPlayer2Id(Player player2) {
		this.player2 = player2;
	}

	/**
     * {@link Game#winner}
     */
	public Player getWinner() {
		return winner;
	}

	/**
     * {@link Game#winner}
     */
	public void setWinner(Player winner) {
		this.winner = winner;
		this.isOver = true;
	}

	/**
     * {@link Game#isOver}
     */
	public boolean isOver() {
		return isOver;
	}

	/**
     * {@link Game#isOver}
     */
	public void setOver(boolean isOver) {
		this.isOver = isOver;
	}
	
	/**
     * Get one player Score
     */
	public Score getPlayerScore(Player player) {
		if(!(player1.equals(player) || player2.equals(player))){
			throw new NoSuchElementException();
		}
		return (player1.equals(player)) ? playerOneScore : playerTwoScore;
	}
	
	/**
     * Set one player Score
     */
	public void setPlayerScore(Player player, Score playerScore) {
		if(!(player1.equals(player) || player2.equals(player))){
			throw new NoSuchElementException();
		}  
	
		if (player1.equals(player)){
			playerOneScore = playerScore;
		}
		else{
			playerTwoScore = playerScore;
		}
	}

	/**
     * {@link Game#gameScore}
     */
	public String getGameScore() {
		return ComputeScore(this.playerOneScore, this.playerTwoScore);
	}
	
	/**
    * Compute the game score as a String for display purpose
    */
	private String ComputeScore(Score playerOne, Score playerTwo){
		if(playerOne.getScore() == Score.Forty.getScore() && playerTwo.getScore() == Score.Forty.getScore()){
			return "Deuce";
		}
		else if(playerOne.getScore() == Score.Advantage.getScore() && playerTwo.getScore() == Score.Forty.getScore()){
			return "Adv - 40";
		}
		else if(playerOne.getScore() == Score.Forty.getScore() && playerTwo.getScore() == Score.Advantage.getScore()){
			return "40 - Adv";
		}
		else{
			return String.valueOf(playerOne.getScore()) + " - " + String.valueOf(playerTwoScore.getScore());
		}
	}
}
