//package com.rit.assignment.C;

import java.util.Arrays;
import java.util.List;

public class Player {

	 private String superHeroName;
	 private  List<String> playerImage;
	 private String displayName;
	 private String playerGuess;
	 private String name;
	 private int[][] visibilityArray;
	 private String playerInfo;

	 public String getSuperHeroName() {
		return superHeroName;
	}
	public void setSuperHeroName(String superHeroName) {
		this.superHeroName = superHeroName;
	}
	public List<String> getPlayerImage() {
		return playerImage;
	}
	public void setPlayerImage(List<String> playerImage) {
		this.playerImage = playerImage;
	}
	public int[][] getVisibilityArray() {
		return visibilityArray;
	}
	public void setVisibilityArray(int[][] visibilityArray) {
		this.visibilityArray = visibilityArray;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getPlayerGuess() {
		return playerGuess;
	}
	public void setPlayerGuess(String playerGuess) {
		this.playerGuess = playerGuess;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlayerInfo() {
		return playerInfo;
	}
	public void setPlayerInfo(String playerInfo) {
		this.playerInfo = playerInfo;
	}
	
	@Override
	public String toString() {
		return "Player [superHeroName=" + superHeroName + ", playerImage=" + playerImage + ", displayName="
				+ displayName + ", playerGuess=" + playerGuess + ", name=" + name + ", visibilityArray="
				+ Arrays.toString(visibilityArray) + ", playerInfo=" + playerInfo + "]";
	}
	
	
}
