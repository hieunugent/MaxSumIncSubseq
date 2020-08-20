import java.util.*;

class Program {
  public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
    // Write your code here.
		int [] sequences = new int[array.length];
		Arrays.fill(sequences, Integer.MIN_VALUE);
		int [] sums = array.clone();
		int maxIdxSum = 0;
		for(int i = 0 ; i < array.length; i++){
			int currentNum = array[i];
			for(int j = 0; j < i ; j++){
				int otherNum = array[j];
				if( currentNum > otherNum && sums[j]+ currentNum > sums[i]){
					sums[i] = sums[j] + currentNum;
					sequences[i] =j;
 				}
				
			}
			if (sums[i] >= sums[maxIdxSum]){ maxIdxSum = i;}
		}
    return buildMaxSub( array, sums[maxIdxSum], sequences, maxIdxSum);
  }
	public static List<List<Integer>> buildMaxSub(
	int[] array, int  sum, int[] sequences, int maxIdxSum){
		List<List<Integer>> sequence =new ArrayList<List<Integer>>();
		sequence.add(new ArrayList<Integer>());
		sequence.add(new ArrayList<Integer>());
		sequence.get(0).add(sum);
		int currentIdex = maxIdxSum;
	
		while(currentIdex != Integer.MIN_VALUE){
			sequence.get(1).add(0, array[currentIdex]);
			currentIdex = sequences[currentIdex];
		}
		//sequence.get(1).add(0, array[currentIdex]);
		return sequence;
		
	}
}
