
public class Game {
	
	private int[] rolls = new int[21];
	private int currentRoll = 0;

	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}
	
	private boolean isSpare(int frameindex) {
		return rolls[frameindex] + rolls[frameindex] == 10;
	}

	public int score() {
		int score = 0;
		int frameindex = 0;
		for( int frame=0; frame< 10; ++frame ) {
			if(isSpare(frameindex)) score += (10 + rolls[frameindex+2]);
			else score += (rolls[frameindex] + rolls[frameindex+1]);
			frameindex += 2;
		}
		return score;
	}

}
