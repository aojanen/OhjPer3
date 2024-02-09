/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.wordgame;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author ttakoj
 */
public class WordGame {
	
	private ArrayList<String> wordBin;
	private WordGameState gameState;
	private String targetWord;
	private boolean isGameActive;
	
	// Constructor
	public WordGame(String wordFileName) throws IOException{
		gameState = null;
		isGameActive = false;
		wordBin = new ArrayList();
		try(var input = new Scanner(new File(wordFileName))){
			while (input.hasNextLine()){
				String word = input.nextLine();
				wordBin.add(word);
			}		
		}
	}
	
	public class WordGameState {
		private String word;
		private int mistakeLimit;
		private int mistakes;
		private int missingChars;

		private WordGameState(String word, int mistakeLimit){
			this.word = "_".repeat(word.length());
			this.mistakeLimit = mistakeLimit;
			this.mistakes = 0;
			this.missingChars = word.length();
		}

		public String getWord(){
			return word;
		}
		
		public int getMistakes(){
			return mistakes;
		}
		
		public int getMistakeLimit(){
			return mistakeLimit;
		}
		
		public int getMissingChars(){
			return missingChars;
		}
		
/*		public void setWord(String word){
			this.word = word;
		}
		
		public void addMistake(){
			mistakes++;
		}
		
		public void decMissingChars(){
			missingChars--;
		}
		
		public void nulMissingChars(){
			missingChars = 0;
		} */
	}
	
	public void initGame(int wordIndex, int mistakeLimit){
		targetWord = wordBin.get(wordIndex % wordBin.size());
		gameState = new WordGameState(targetWord, mistakeLimit);
		isGameActive = true;
	}
	
	public boolean isGameActive(){
		return isGameActive;
	}
	
	public WordGameState getGameState() throws GameStateException {
		if (!isGameActive()){
			throw new GameStateException("There is currently no active word game!");
		}
		
		return gameState;
	}
	
	public WordGameState guess(char c) throws GameStateException{
		if (!isGameActive()){
			throw new GameStateException("There is currently no active word game!");
		}
		String g = Character.toString(c).toLowerCase();
		String tLow = targetWord.toLowerCase();
		if (tLow.contains(g) && !gameState.getWord().contains(g)) {
			StringBuilder guessState = new StringBuilder(gameState.getWord());
			for (int i = 0; i < targetWord.length(); i++){
				if (tLow.charAt(i) == g.charAt(0)){
					guessState.setCharAt(i, Character.toLowerCase(c));
					gameState.missingChars--;
				}
				gameState.word = guessState.toString();
			}
		} else {
			gameState.mistakes++;
		}
		
		if (gameState.getMissingChars() == 0 || gameState.getMistakes() > gameState.getMistakeLimit()){
			isGameActive = false;
			gameState.word = targetWord;
			
		}
		return gameState;
	}
	
	public WordGameState guess(String g) throws GameStateException{
		if (!isGameActive()){
			throw new GameStateException("There is currently no active word game!");
		}
		if (g.equals(targetWord)){
			gameState.word = g;
			gameState.missingChars = 0;
			isGameActive = false;
		} else {
			gameState.mistakes++;
			if (gameState.getMistakes() > gameState.getMistakeLimit()){
				isGameActive = false;
				gameState.word = targetWord;
			}
		}
		return gameState;
	}
}
	

