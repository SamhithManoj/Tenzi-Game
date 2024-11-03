import java.util.ArrayList;
public class TenziPlayer{

	private ArrayList<Die> dice;
	private int targetNum;
	private int compTargetNum;
	private int numSavedDice;
	private String name;

	public TenziPlayer(int numDice, String n) {
		name = n;
		dice = new ArrayList<Die>();
		for (int i = 0; i < numDice; i++) {
			dice.add(new Die(6));
		}
		numSavedDice = 0;
	}

	// Initialize dice, add numDice to list, set numSavedDice to zero
	public TenziPlayer(int numDice){
		dice = new ArrayList<Die>();
		for (int i = 0; i < numDice; i++) {
			dice.add(new Die(6)); //add a new 6 sided die to the list
		}
		numSavedDice = 0;
	}

	// Initialize to start with the default 10 dice
	public TenziPlayer(){
		this(10); // Calls the int constructor with 10
	}

	// Get the Target Number
	public int getTargetNum(){
		return targetNum;
	}

	public String getName() {
		return name;
	}

	public int CompTargetNum(){
		int count = 0;
		int maxCt = 0;
		int maxCtNum = 0;
		ArrayList<Integer> diceVal = new ArrayList<Integer>();
		for (Die d : dice) {
			diceVal.add(d.getLastRoll());
		}
		for (int i = 0; i < diceVal.size(); i++) {
			count = 0;
			for (int j = i + 1; j < diceVal.size(); j++) {
				if (diceVal.get(i) == diceVal.get(j)) {
					diceVal.remove(j);
					j--;
					count++;
				}
			}
			if (count > maxCt) {
				maxCt = count;
				maxCtNum = diceVal.get(i);
			}
			diceVal.remove(i);
			i--;
		}
		compTargetNum = maxCtNum;
		return compTargetNum;
	}

	// Get the Number of saved dice (those removed from dice)
	public int getNumSavedDice(){
		return numSavedDice;
	}

	// Set the Target Number
	public void setTargetNum(int num){
		targetNum = num;
	}

	// Roll all Die in dice arraylist
	public void roll(){
		for (Die d : dice) {
			d.roll();
		}
	}

	// Remove all dice that have a last roll matching Target
	// print out how many were removed this round and
	// update overall number of saved dice
	public void removeTargetDice(){
		int count = 0;
		for (int i = dice.size() - 1; i >= 0; i--) {
			Die d = dice.get(i);
			if (d.getLastRoll() == targetNum) {
				dice.remove(i);
				numSavedDice++;
				count++;
			}
		}
		System.out.println(count + " " + targetNum + "'s removed");

		//loop through and remove dice with last roll matching target number
		//print out how many removed
		//update numSavedDice
	}

	public void print(){
		System.out.println(dice); // Simple print for now.  Can be enhanced later
	}

	// return true if ArrayList dice is empty.
	public boolean done(){
		if (numSavedDice == 10) {
			return true;
		}
		return false;
	}

}