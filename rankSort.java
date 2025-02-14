/*link to sorting algorithms: https://builtin.com/machine-learning/fastest-sorting-algorithm
Medium: https://medium.com/enjoy-algorithm/introduction-to-sorting-algorithms-e9811ac2d7c7
*/
import java.util.*;
import java.time.*;
class rankSort
{
	public static void rankSortBruteForce(int[] inputArray, int[] rankArray, int[] outputArray)
	{
		for(int i = 0; i<inputArray.length; i++)
		{
			int lowestMin = inputArray[i];
			int currentSum = 0;
			for(int j = 0; j<inputArray.length; j++)
			{
				if(i!=j)
				{
					int currentMin = inputArray[j];
					if(lowestMin > currentMin)
					{
						currentSum += 1;
					}
					rankArray[i] = currentSum;
				}
			}
			
			for(int m = 0; m<inputArray.length; m++)
			{
				outputArray[rankArray[m]] = inputArray[m];
			}
		}
	}
	public static void rankMapSort(int[] inputArray, int[] rankArray, int[] outputArray)
	{
		ArrayList<Integer> numList = new ArrayList<>();
		for(int i = 0; i<inputArray.length; i++)
		{
			numList.add(inputArray[i]);
		}
		
		Collections.sort(numList); /*Ideally we do not want to use Collections.sort() to sort the list but rather facilitate the calculation of each element's rank*/
		
		Map<Integer, Integer> integerMap = new HashMap<>();
		
		int rank = 0;
		for(int num : numList)
		{
			if(!integerMap.containsKey(num))
			{
				integerMap.put(num, rank++);
			}
		}
		
		for(int j = 0; j<inputArray.length; j++)
		{
			rankArray[j] = integerMap.get(inputArray[j]);
		}
		
		for(int m = 0; m<inputArray.length; m++)
		{
			outputArray[rankArray[m]] = inputArray[m];
		}
	}
	public static void main(String[] args)
	{
		System.out.println("Testing O(n^2) RankSort and O(n+1) RankSort Algorithms\n");
		System.out.println("");
		System.out.println("Unsorted List Test:\n");
		System.out.println("");
		int[] unsortedList = {13, 9, 23, 10, 1};
		int sizeArray = unsortedList.length;
		for(int n = 0; n<sizeArray; n++)
		{
			System.out.print(unsortedList[n]+", ");
		}
		System.out.println("\n");
		int[] rankList = new int[sizeArray];
		int[] outputList = new int[sizeArray];
		long startBruteForceTime = System.nanoTime();
		rankSortBruteForce(unsortedList, rankList, outputList);
		long endBruteForceTime = System.nanoTime();
		System.out.println("O(n^2) Solution:\n");
		System.out.println("");
		for(int z = 0; z<sizeArray; z++)
		{
			System.out.print(outputList[z]+", ");
		}
		System.out.println("\n");
		long elapsedBruteForceTime = endBruteForceTime - startBruteForceTime;
		System.out.println("Elapsed time in nanoseconds: " + elapsedBruteForceTime);
		System.out.println("\n");
		System.out.println("Unorganized List Test:\n");
		System.out.println("");
		int[] unorganizedList = {33, 7, 53, 21, 10};
		int sizeList = unorganizedList.length;
		for(int n = 0; n<sizeList; n++)
		{
			System.out.print(unorganizedList[n]+", ");
		}
		System.out.println("\n");
		int[] rankedList = new int[sizeList];
		int[] resultList = new int[sizeList];
		long startMapSortTime = System.nanoTime();
		rankMapSort(unorganizedList, rankedList, resultList);
		long endMapSortTime = System.nanoTime();
		System.out.println("O(n+1) Solution\n");
		System.out.println("\n");
		for(int k = 0; k<sizeList; k++)
		{
			System.out.print(resultList[k]+", ");
		}
		System.out.println("\n");
		long elapsedMapSortTime = endMapSortTime - startMapSortTime;
		System.out.println("Elapsed time in nanoseconds: " + elapsedMapSortTime);
		System.out.println("\n");
	}
}