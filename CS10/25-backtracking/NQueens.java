import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Program to solve the n-queens problem.
 * 
 * @author Scot Drysdale
 * 12/2011
 */
public class NQueens {
	
	/**
	 * Solves the n-queens problem recursively.
	 * 
	 * @param partialSol the current partial solution (first position-1 places
	 *   are valid).  Its length is the problem size.
	 * @param position the next position to be assigned.
	 * @param List of solutions found so far
	 */
	public static void solve(int [] partialSol, int position, List<int []> solList) {
		if (position >= partialSol.length) {
			solList.add(partialSol.clone());  // Must clone so doesn't change
		}
		else
			for (int i = 1; i <= partialSol.length; i++) {  // Try all possible values
				partialSol[position] = i;
				if (noConflict(partialSol, position))
					solve(partialSol, position+1, solList);
			}		
	}
	
	/**
	 * Determines if value in given position conflicts with earlier values
	 * 
	 * @param partialSol the current partial solution
	 * @param position the position to be tested for conflict with earlier values
	 */
	public static boolean noConflict(int [] partialSol, int position) {
		for (int i = 0; i < position; i++) {
			if (partialSol[position] == partialSol[i] ||
					Math.abs(partialSol[position] - partialSol[i]) == position - i)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int n;                  // Problem size
		
		Scanner input = new Scanner(System.in);
		System.out.print("Number of queens (< 1 to quit): ");
		n = input.nextInt();
		
		while(n > 0) {
			int [] partialSol = new int[n];
			List<int []> solList  = new ArrayList<int []>();

			solve(partialSol, 0, solList);

			for (int [] sol : solList) {
				for (int i = 0; i < sol.length; i++)
					System.out.print(sol[i] + " "); 

				System.out.println();
			}

			System.out.println("\nNumber of solutions for n = " + n + " is " + solList.size());
			
			System.out.print("\nNumber of queens: ");
			n = input.nextInt();
		}
	}
}
