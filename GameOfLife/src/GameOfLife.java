import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class GameOfLife {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Random rand = new Random();

		int gridSize;
		String check;
		char checkChar = 'Y';

		System.out.print("Enter grid size: ");
		gridSize = scanner.nextInt();

		int[][] grid = new int[gridSize][gridSize];
		int[][] newGrid = new int[gridSize][gridSize];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				int randNumber = rand.nextInt(2);
				grid[i][j] = randNumber;
			}
		}

		while (checkChar == 'Y') {
			for (int i = 0; i < grid.length; i++) {
				System.out.println(Arrays.toString(grid[i]));

				for (int j = 0; j < grid.length; j++) {
					int count = 0;
					if (i != 0 && j != 0) {
						if (grid[i - 1][j - 1] == 1) {
							count++;
						}
					}

					if (i != 0) {
						if (grid[i - 1][j] == 1) {
							count++;
						}
					}

					if (i != 0 && j != grid[i].length - 1) {
						if (grid[i - 1][j + 1] == 1) {
							count++;
						}
					}

					if (j != 0) {
						if (grid[i][j - 1] == 1) {
							count++;
						}
					}

					if (j != grid[i].length - 1) {
						if (grid[i][j + 1] == 1) {
							count++;
						}
					}

					if (i != grid.length - 1 && j != 0) {
						if (grid[i + 1][j - 1] == 1) {
							count++;
						}
					}

					if (i != grid.length - 1) {
						if (grid[i + 1][j] == 1) {
							count++;
						}
					}

					if (i != grid.length - 1 && j != grid[i].length - 1) {
						if (grid[i + 1][j + 1] == 1) {
							count++;
						}
					}

					if (grid[i][j] == 1) {
						if (count <= 1 || count >= 4) {
							newGrid[i][j] = 0;
						}
						if (count == 2 || count == 3) {
							newGrid[i][j] = 1;
						}
					}

					if (grid[i][j] == 0) {
						if (count == 3) {
							newGrid[i][j] = 1;
						} else {
							newGrid[i][j] = 0;
						}
					}
				}
			}
		
			grid = newGrid;
			System.out.print("Continue? y/n ");
			check = scanner.next();
			check = check.toUpperCase();
			checkChar = check.charAt(0);
		
		}
	}
}
