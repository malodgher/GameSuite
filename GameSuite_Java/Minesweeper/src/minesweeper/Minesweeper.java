package minesweeper;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Minesweeper {

	static List<List<String>> arrayListInit(boolean getInnergrid) {
		final List<List<String>> grid = new ArrayList<List<String>>();
		
		
		for(int i = 0; i < 8; i++) {
			grid.add(new ArrayList<String>());
			for(int j = 0; j < 10; j++) {
				grid.get(i).add("~");
			}
		}
		
		if(getInnergrid == false) {
			return grid.stream()
					.map(row -> row.stream()
							.map(elem -> elem = "-")
							.collect(Collectors.toList()))
					.collect(Collectors.toList());
		} else {
			for(int x = 0; x < grid.get(0).size(); x++) {
				while(true) {
					int row = (int)(Math.random() * grid.size());
					int col = (int)(Math.random() * grid.get(0).size());
					
					if(!(grid.get(row).get(col).equals("*"))) {
						grid.get(row).set(col, "*");
						break;
					}
					else
						continue;
				}
			}
			
			for(int i = 0; i < grid.size(); i++) {
				for(int j = 0; j < grid.get(i).size(); j++) {
					if(grid.get(i).get(j).equals("*"))
						continue;
					else {
						Integer mine_count;
						if(grid.get(i).get(j).equals("~"))
							mine_count = 0;
						else
							mine_count = Integer.parseInt(grid.get(i).get(j));
						
						if(((i-1) >= 0) && ((j-1) >= 0) && (grid.get(i-1).get(j-1).equals("*")))
							mine_count++;
						if(((i-1) >= 0) && (grid.get(i-1).get(j).equals("*")))
							mine_count++;
						if(((i-1) >= 0) && ((j+1) < grid.get(i).size()) && (grid.get(i-1).get(j+1).equals("*")))
							mine_count++;
						if(((j-1) >= 0) && (grid.get(i).get(j-1).equals("*")))
							mine_count++;
						if(((j+1) < grid.get(i).size()) && (grid.get(i).get(j+1).equals("*")))
							mine_count++;
						if(((i+1) < grid.size()) && ((j-1) >= 0) && (grid.get(i+1).get(j-1).equals("*")))
							mine_count++;
						if(((i+1) < grid.size()) && (grid.get(i+1).get(j).equals("*")))
							mine_count++;
						if(((i+1) < grid.size()) && ((j+1) < grid.get(i).size()) && (grid.get(i+1).get(j+1).equals("*")))
							mine_count++;
						
						if(!(mine_count.intValue() == 0))
							grid.get(i).set(j, mine_count.toString());
					}
				}
			}
			
			return grid;
		}
		
	}
	
	static void printGrid (List<List<String>> grid) {
		AtomicInteger count = new AtomicInteger(0);
		System.out.println("\n");
		System.out.print("  * |");
		
		grid.get(0).forEach(d -> {
			if(count.get() < 9)
				System.out.printf("%3d", count.incrementAndGet());
			else
				System.out.printf("%4d", count.incrementAndGet());
		});
		
		System.out.print("\n----+");
		grid.get(0).forEach(d -> { System.out.print("----"); });
		
		count.set(0);
		grid.forEach((row) -> {
			System.out.println();
			System.out.printf("%3d | ", count.incrementAndGet());
			System.out.print(row);
		});
	}
	
	static void playGameList() {
		/* final List<List<String>> playerGrid = arrayListInit(false);
		final List<List<String>> innerGrid = arrayListInit(true);
		printGrid(playerGrid);
		printGrid(innerGrid); */
	}
	
	// ----------------------------------------------------------------------------------------------------------------------------------
	
	static String[][] twoDArrayInit(boolean getInnergrid) {
		String[][] grid = new String[8][10];
		
		if(getInnergrid == false) {
			for(int i = 0; i < grid.length; i++) {
				for(int j = 0; j < grid[i].length; j++) {
					grid[i][j] = "-";
				}
			}
			
			return grid;
		} else {
			for(int i = 0; i < grid.length; i++) {
				for(int j = 0; j < grid[i].length; j++) {
					grid[i][j] = "~";
				}
			}
			
			for(int x = 1; x <= 10; x++) {
				while(true) {
					int row = (int)(Math.random() * grid.length);
					int col = (int)(Math.random() * grid[0].length);
					
					if(!(grid[row][col].equals("*"))) {
						grid[row][col] = "*";
						break;
					}
					else
						continue;
				}
			}
			
			
			
			for(int i = 0; i < grid.length; i++) {
				for(int j = 0; j < grid[i].length; j++) {
					if(grid[i][j].equals("*"))
						continue;
					else {
						Integer mine_count;
						if(grid[i][j].equals("~"))
							mine_count = 0;
						else
							mine_count = Integer.parseInt(grid[i][j]);
						
						if(((i-1) >= 0) && ((j-1) >= 0) && (grid[i-1][j-1].equals("*")))
							mine_count++;
						if(((i-1) >= 0) && (grid[i-1][j].equals("*")))
							mine_count++;
						if(((i-1) >= 0) && ((j+1) < grid[i].length) && (grid[i-1][j+1].equals("*")))
							mine_count++;
						if(((j-1) >= 0) && (grid[i][j-1].equals("*")))
							mine_count++;
						if(((j+1) < grid[i].length) && (grid[i][j+1].equals("*")))
							mine_count++;
						if(((i+1) < grid.length) && ((j-1) >= 0) && (grid[i+1][j-1].equals("*")))
							mine_count++;
						if(((i+1) < grid.length) && (grid[i+1][j].equals("*")))
							mine_count++;
						if(((i+1) < grid.length) && ((j+1) < grid[i].length) && (grid[i+1][j+1].equals("*")))
							mine_count++;
						
						if(!(mine_count.intValue() == 0))
							grid[i][j] = mine_count.toString();
					}
				}
			}
			
			return grid;
		}
	}

	static void printGridArr (String[][] grid) {
		System.out.println("\n");
		System.out.print("  * |");
		
		for(int i = 1; i <= grid[0].length; i++)
			System.out.printf("%4d", i);
		
		System.out.print("\n----+");
		
		for(String row: grid[0]) {
			System.out.print("----");
		}
		
		for(int i = 1; i <= grid.length; i++) {
			System.out.println();
			System.out.printf("%3d |", i);
			for(int j = 0; j < grid[0].length; j++){
				System.out.printf("%4s", grid[i-1][j]);
			}
		}
	}

	static void playGameArr() {
		/* String[][] playerArr = twoDArrayInit(false);
		String[][] innerArr = twoDArrayInit(true);
		printGridArr(playerArr);
		printGridArr(innerArr); */
	}
	
	// ----------------------------------------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		System.out.println("Welcome to Minesweeper!");
		Scanner kbin = new Scanner(System.in);
		System.out.print("Please enter 1 for Array or 2 for ArrayList: ");
		int arrOrList = kbin.nextInt();
		
		while( !((arrOrList == 1) || (arrOrList == 2)) ) {
			System.out.print("This input is incorrect. Please enter 1 for Array or 2 for ArrayList: ");
			arrOrList = kbin.nextInt();
		}
		kbin.close();
		
		if(arrOrList == 1)
			playGameArr();
		else
			playGameList();
	}

}