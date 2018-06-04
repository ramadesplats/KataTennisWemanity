package controller;

import model.Player;

import java.util.NoSuchElementException;

import model.Game;
import model.Score;

/**
* <h1>The Game repository</h1>
* 
* i.e. Methods called to play the Game
*
* @author  Rama DESPLATS
* @version 1.0
* @since   2018-06-04
*/
public class GameRepository {
	
	//Process a winning play from player
	public static void winningPlay(Player player, Game game){
		//Can't play a game that has already ended
		if(game.isOver()){
			throw new NoSuchElementException();
		}
		Player otherPlayer = (game.getPlayer1().equals(player)) ? game.getPlayer2() : game.getPlayer1();
		switch(game.getPlayerScore(player)){
		case Love:
			game.setPlayerScore(player, Score.Fifteen);
			break;
		case Fifteen:
			game.setPlayerScore(player, Score.Thirty);
			break;
		case Thirty:
			game.setPlayerScore(player, Score.Forty);
			break;
		case Forty:
			if(game.getPlayerScore(otherPlayer) == Score.Advantage){
				game.setPlayerScore(otherPlayer, Score.Forty);
			}
			else if(game.getPlayerScore(otherPlayer) == Score.Forty){
				game.setPlayerScore(player, Score.Advantage);
			}
			else{
				game.setWinner(player);
			}
			break;
		case Advantage:
			game.setWinner(player);
			break;
		default:
			throw new NoSuchElementException();
		}
	}
}
