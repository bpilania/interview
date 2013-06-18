package com.interview.algorithms.general;

/**
 * In a game, you bet using the following strategy. Whenever you lose a bet, 
 * you double the value of the bet for the next round. Whenever you win, the bet for the next round 
 * will be one dollar. You start the round by betting one dollar.
	For example, if you start with 20 dollars, and you win the bet in the first round, 
	lose the bet in the next two rounds and then win the bet in the fourth round, 
	you will end up with 20+1-1-2+4 = 22 dollars.
	
	You are expected to complete the function, getFinalAmount, which takes two arguments.
	The first argument is an integer initialAmount which is the initial money we amount we have 
	when we start the betting. The second argument is a string betResultsThe ith character of outcome 
	will be either 'W' (win) or 'L' (lose), denoting the result of the ith round.	
	
	Your function should return the amount of money you will have after all the rounds are played. 
	If at some point you don't have enough money in your account to cover the value of the bet, 
	you must stop and return the sum you have at that point.
	
	Sample Test Cases: 

Input #00:
12
WWWWWWWW

Output #00:
20

Explanation: 
The initial amount is 12, for every win, you gain 1 dollar.
There are totally 8 consecutive wins and no losses, hence total money gained = 12 + 8 = 20

Input #01:
15
LLLWLLLL

Output #01:
1

Explanation:
The initial amount is 15. As stated in the problem, the amount of bet doubles for every loss.
1st round - Loss: 15-1 = 14
2nd round - Loss: 14-2 = 12 (Bet doubles)
3rd round - Loss: 12-4 = 8
4th round - Win: 8 + 8 = 16
5th round - Loss:16-1 = 15 (Since the previous bet was a win, this bet has a value of 1 dollar)
6th round - Loss: 15-2 = 13
7th round - Loss: 13-4 = 9
8th round - Loss: 9-8 = 1
 * @author stefanie
 *
 */
public class BetProblem {
	static int getFinalAmount(int initialAmount , String betResults) {
		int betAmount = 1;
		int amount = initialAmount;
		char[] bets = betResults.toCharArray();
		for (char bet : bets) {
			switch (bet) {
			case 'W':
				amount += betAmount;
				betAmount = 1;
				break;
			case 'L':
				amount -= betAmount;
				betAmount *= 2;
				if (amount < betAmount)
					return amount;
			}
		}
		return amount;
	}
	
	public static void main(String[] args){
		int result = BetProblem.getFinalAmount(2, "LLLWLLLL");
		System.out.println(result);
	}
}
