
public class Game {
	
	private int[] rolls = new int[21];
	private int currentRoll = 0;

	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}
	
	private boolean isSpare(int frameindex) {
		return rolls[frameindex] + rolls[frameindex] == 10;
	}
	
	private int strikeBonus(int frameindex) {
		return rolls[frameindex + 1] + rolls[frameindex+ 2];
	}
	
	private boolean isStrike(int frameindex) {
		return rolls[frameindex] == 10;
	}

	public int score() {
		int score = 0;
		int frameindex = 0;
		for( int frame=0; frame< 10; ++frame ) {
			// strike
			if(isStrike(frameindex)) {
				score += (10 + strikeBonus(frameindex));
				frameindex += 1;
			}
			// spare
			else if(isSpare(frameindex)) {
				score += (10 + rolls[frameindex+2]);
				frameindex += 2;
			}
			else {
				score += (rolls[frameindex] + rolls[frameindex+1]);
				frameindex += 2;
			}
		}
		return score;
	}

}
