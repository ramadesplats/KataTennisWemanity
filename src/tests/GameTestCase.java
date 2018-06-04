package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.GameRepository;
import model.*;

public class GameTestCase {

	private Player player1;
	
	private Player player2;
	
	private Game myGame;
	
	@Before
	public void generateData() 
	{
	    player1 = new Player("Rafael", "Nadal");
	    player2 = new Player("Roger", "Federer");
	    myGame = new Game(player1, player2);
	}
	
	@Test
	public void initalGame() {
		assertEquals("Inital game should have 0 - 0", "0 - 0", myGame.getGameScore());
	}
	
	@Test
	public void PlayerOnePlay() {
		GameRepository.winningPlay(player1, myGame);
		assertEquals("Plyaer 1 should be 15 - 0", "15 - 0", myGame.getGameScore());
	}
	
	@Test
	public void DeuceTest() {
		myGame.setPlayerScore(player1, Score.Forty);
		myGame.setPlayerScore(player2, Score.Forty);
		assertEquals("Game should be deuce", "Deuce", myGame.getGameScore());
	}
	
	@Test
	public void DeuceTest2() {
		myGame.setPlayerScore(player1, Score.Forty);
		myGame.setPlayerScore(player2, Score.Advantage);
		GameRepository.winningPlay(player1, myGame);
		assertEquals("Game should be deuce", "Deuce", myGame.getGameScore());
	}
	
	@Test
	public void AdvantageTest() {
		myGame.setPlayerScore(player1, Score.Forty);
		myGame.setPlayerScore(player2, Score.Forty);
		GameRepository.winningPlay(player1, myGame);
		assertEquals("Game should be advantage for player 1", "Adv - 40", myGame.getGameScore());
	}
	
	@Test
	public void AdvantageTest2() {
		myGame.setPlayerScore(player1, Score.Forty);
		myGame.setPlayerScore(player2, Score.Forty);
		GameRepository.winningPlay(player2, myGame);
		assertEquals("Game should be advantage for player 2", "40 - Adv", myGame.getGameScore());
	}
	
	@Test
	public void WinCondition1() {
		myGame.setPlayerScore(player1, Score.Forty);
		myGame.setPlayerScore(player2, Score.Love);
		GameRepository.winningPlay(player1, myGame);
		assertEquals("Game should be won for player 1", player1, myGame.getWinner());
	}

	@Test
	public void WinCondition2() {
		myGame.setPlayerScore(player1, Score.Forty);
		myGame.setPlayerScore(player2, Score.Fifteen);
		GameRepository.winningPlay(player1, myGame);
		assertEquals("Game should be won for player 1", player1, myGame.getWinner());
	}
	
	@Test
	public void WinCondition3() {
		myGame.setPlayerScore(player1, Score.Forty);
		myGame.setPlayerScore(player2, Score.Thirty);
		GameRepository.winningPlay(player1, myGame);
		assertEquals("Game should be won for player 1", player1, myGame.getWinner());
	}
	
	@Test
	public void WinCondition4() {
		myGame.setPlayerScore(player1, Score.Advantage);
		myGame.setPlayerScore(player2, Score.Forty);
		GameRepository.winningPlay(player1, myGame);
		assertEquals("Game should be won for player 1", player1, myGame.getWinner());
	}

}
