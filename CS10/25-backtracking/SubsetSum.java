import java.util.*;

/**
 * A class to demonstrate backtracking to solve subset sum
 *
 * by Scot Drysdale for CS 10
 */
public class SubsetSum {

	/**
	 * Finds all subsets of the numbers in List that add up to target.
	 * 
	 * @param numbers  The list of positive integers (cannot have duplicates!)
	 * @param pos      The current position in numbers to be considered
	 * @param subset   The current subset
	 * @param sum      The sum of the integers in subset
	 * @param target   The goal number that the sum should equal
	 */
	public static void findSubsets(List<Integer> numbers, int pos, Set<Integer> subset, int sum, int target) {
		if (sum == target)
			System.out.println("Subset: " + subset);
		else if (sum < target && pos < numbers.size()) {  // Do nothing if sum too large
			Integer m = numbers.get(pos);
			subset.add(m);
			findSubsets(numbers, pos+1, subset, sum+m, target); // Include pos
			subset.remove(m);		
			findSubsets(numbers, pos+1, subset, sum, target);  // Don't include pos
		}
	}
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(2,15,3,5,10);
		findSubsets(numbers, 0, new TreeSet<Integer>(), 0, 20);
	}
}