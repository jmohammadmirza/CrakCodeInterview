package com.something.anyting;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *Created by Mohammad Javed
 *Completed on 3 October
 */
class BattleShip {
	private static final String PLAYER_A = "A";
	private static final String PLAYER_B = "B";

	private static final String SHIP_Q = "Q";

	static  int M;
	static  int N;
	static List<String> frigateWithPlayerA=new ArrayList<String>();
	static  List<String> frigateWithPlayerB=new ArrayList<String>();

	private static void placeShipOnBoard(int row1, int col1, String locBattleShip1PlayerA, String typeBattleShip, String boardType) {
		//Adding the co-ordinates having the Ship  in  frigateWithPlayerA, frigateWithPlayerB List
		char firstA=locBattleShip1PlayerA.toUpperCase().charAt(0);
		char secondA=locBattleShip1PlayerA.charAt(1);
		for(int i=1;i<=row1;i++){
			for(int j=1;j<=col1;j++){
				int k=convertLetterToInt(firstA)-1+i;
				int l=secondA-49+j;
				if(boardType.equals(PLAYER_A)){
					frigateWithPlayerA.add(String.valueOf(convertInttoLetter(k))+String.valueOf(l));
					if(typeBattleShip.equalsIgnoreCase(SHIP_Q)){
						frigateWithPlayerA.add(String.valueOf(convertInttoLetter(k))+String.valueOf(l));
					}
				}
				else if(boardType.equals(PLAYER_B)){
					frigateWithPlayerB.add(String.valueOf(convertInttoLetter(k))+String.valueOf(l));	
					if(typeBattleShip.equalsIgnoreCase(SHIP_Q)){
						frigateWithPlayerA.add(String.valueOf(convertInttoLetter(k))+String.valueOf(l));
					}
				}
			}
		}

	}

	public static void main(String[] args) {

		Scanner sc=null;
		String s=null;
		final  int M;
		String typeBattleShip1,battleShip1Dim,typeBattleShip2,battleShip2Dim,locBattleShip1PlayerA,locBattleShip1PlayerB,locBattleShip2PlayerA,locBattleShip2PlayerB;
		int row1,col1,row2,col2;
		String[] MissileTargetPlayerA;
		String[] MissileTargetPlayerB;
		try{

			sc=new Scanner(System.in);//.useDelimiter("\\|");
			System.out.println("Fetching Input  : "+LocalDateTime.now());
			while(true){
				/*
				 * Sample Input used for Testing 
				 * Enter area boundaries: 5 E
			    		Type for battleship 1: Q
			    		Dimension for battleship 1: 1 1
			    		Location of battleship 1 for player A: A1
			    		Location of battleship 1 for player B: B2
			    		Type for battleship 2: P
			    		Dimension for battleship 2: 2 1
			    		Location of battleship 2 for player A: D4
			    		Location of battleship 2 for player B: C3
			    		Missile targets for player A: A1 B2 B2 B3
			    		Missile targets for player B: A1 B2 B3 A1 D1 E1 D4 D4 D5 D5
				 */
				System.out.println("\nEnter area boundaries :\n");
				s=sc.nextLine();
				// Enter area boundaries
				M=Integer.valueOf(s.split(" ")[0]);
				N=Integer.valueOf(convertLetterToInt(s.split(" ")[1]));
				if (M > 9)
				{
					throw new IllegalArgumentException("ERROR! M  CANNOT BE > 9");
				}

				//Type for battleship 1
				System.out.println("\nType for battleship 1 :\n");
				typeBattleShip1=sc.nextLine();
				System.out.println("\nDimension for battleship 1 :\n");

				battleShip1Dim=sc.nextLine();
				col1=Integer.valueOf(battleShip1Dim.split(" ")[0]);
				row1=Integer.valueOf(battleShip1Dim.split(" ")[1]);

				System.out.println("\n Location of battleship 1 for player A :\n");

				locBattleShip1PlayerA=sc.nextLine();
				System.out.println("\n Location of battleship 1 for player B:\n");
				locBattleShip1PlayerB=sc.nextLine();

				System.out.println("\nType for battleship 2 :\n");

				typeBattleShip2=sc.nextLine();
				System.out.println("\nDimension for battleship 2 :\n");
				battleShip2Dim=sc.nextLine();

				col2=Integer.valueOf(battleShip2Dim.split(" ")[0]);
				row2=Integer.valueOf(battleShip2Dim.split(" ")[1]);
				System.out.println("\n Location of battleship 2 for player A :\n");
				locBattleShip2PlayerA=sc.nextLine();
				System.out.println("\n Location of battleship 2 for player B :\n");
				locBattleShip2PlayerB=sc.nextLine();
				System.out.println("\n Missile targets for player A : \n");
				MissileTargetPlayerA=sc.nextLine().split(" ");
				System.out.println("\n Missile targets for player B : \n");
				MissileTargetPlayerB=sc.nextLine().split(" ");
				break;
			}

			placeShipOnBoard(row1,col1,locBattleShip1PlayerA,typeBattleShip1.toUpperCase(),PLAYER_A);

			placeShipOnBoard(row2,col2,locBattleShip2PlayerA,typeBattleShip2.toUpperCase(),PLAYER_A);

			placeShipOnBoard(row1,col1,locBattleShip1PlayerB,typeBattleShip1.toUpperCase(),PLAYER_B);

			placeShipOnBoard(row2,col2,locBattleShip2PlayerB,typeBattleShip2.toUpperCase(),PLAYER_B);

			fireMissileAndHit(MissileTargetPlayerA,MissileTargetPlayerB);


		}
		catch(IllegalArgumentException e){
			System.err.println("IllegalArgumentException  "+e);
		}
		catch(Exception e){
			System.err.println("Error "+e);
		}

	}


	private static void fireMissileAndHit(String[] missileTargetPlayerA,
			String[] missileTargetPlayerB) {
		// TODO Auto-generated method stub

		//Mainlogic where we play the game fire and declare winners
		List<String> playerA=new ArrayList<String>(Arrays.asList(missileTargetPlayerA));
		List<String> playerB=new ArrayList<String>(Arrays.asList(missileTargetPlayerB));



		Iterator<String> PlayerAIterator = playerA.iterator();
		Iterator<String> PlayerBIterator = playerB.iterator();

		while(true)
		{
			while (PlayerAIterator.hasNext()) {
				// Start the Hits by Player A on Player B board
				String hit=PlayerAIterator.next().toUpperCase();
				if(frigateWithPlayerB.contains(hit)){
					System.out.println("Player-1 fires a missile with target "+hit+" which hit");
					frigateWithPlayerB.remove(hit);
				}
				else{
					System.out.println("Player-1 fires a missile with target "+hit+" which missed");
					break;
				}
			}
			if(!(PlayerAIterator.hasNext())){
				System.out.println("Player-1 has no more missiles left");
			}
			if(!(PlayerBIterator.hasNext())){
				System.out.println("Player-2 has no more missiles left");
			}
			if(!(PlayerAIterator.hasNext())&&!(PlayerBIterator.hasNext())){
				// Declaring winners
				if(frigateWithPlayerA.isEmpty()){
					System.out.println("Player-2 won the battle");
				}
				if(frigateWithPlayerB.isEmpty()){
					System.out.println("Player-1 won the battle");

				}
				if(!frigateWithPlayerB.isEmpty() && !frigateWithPlayerA.isEmpty()){
					System.out.println("Peace");
				}
				break;
			}
			while (PlayerBIterator.hasNext()) {
				// Start the Hits by Player B on Player A board
				String hit=PlayerBIterator.next().toUpperCase();
				if(frigateWithPlayerA.contains(hit)){
					System.out.println("Player-2 fires a missile with target "+hit+" which hit");
					frigateWithPlayerA.remove(hit);
				}
				else{
					System.out.println("Player-2 fires a missile with target "+hit+" which missed");
					break;
				}
			}

		}
		System.out.println("*******************************************");
	}
	/*HELPER METHODS*/
	private static int convertLetterToInt(String val)
	{

		return val.toUpperCase().charAt(0)-'A'+1;
	}

	private static String convertInttoLetter(int val)
	{

		if(val < 0 && val > 27 ){
			throw new IllegalArgumentException("ERROR!  CANNOT BE > 27 or < 0");
		}

		return  String.valueOf((char)(val + 'A' - 1)) ;
	}

	/*HELPER METHODS*/
	private static int convertLetterToInt(char val)
	{

		return val-'A'+1;
	}


}
