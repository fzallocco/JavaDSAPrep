import java.util.*;
class mergingSortedArrays{
	/*nums1 with m elements
	nums2 with n elements

	m+n <= 1e6
	m can be 0
	n can be 0
	nums1[i] & nums2[i] are all integers, 32 bits, they can go from -ve to +ve
	nums1 is sorted least to greatest
	nums2 is sorted least to greatest

	merge them into one list
	part 1 of 2 ^
	
	You have a list of lists
	Each list is of varying length from 0 till 1e6
	At least one inner-list
	Repeating Numbers
	-ve through +ve
	List[list1[10], list2[0], list3[3]] Time/Space O(n), O(log n), ==> O(n log n)
	HashSet, HashMap, LinkedList, Arrays, ,
	part 2 of 2 ^*/
	public static void mergingSortedArrays(int[] nums1, int[] nums2, int m, int n)
	{
		//case3: m and n are both greater than 0, we integrate either array into the other and return it as the resulting array*/
		if((n>0 && m>0) && (n != m)){
			System.out.println("n & m are +ve, resulting array's length: m+n, modified nums1 is:\n");
			int newArraySize = n + m;
			//check the back of each array
			//if nums1[back] > nums2[back] insert nums1[back] into modifiedNums1[back]
			//else insert nums2[back] into modifiedNums1[back]
			int[] resultingArray = new int[newArraySize];
			/*int k = newArraySize-1;
			int i = m-1;
			int j = n-1;*/
			int k = 0; 
			int i = 0;
			int j = 0;
			System.out.println(String.format("nums1's length: %d\n", m));
			System.out.println(String.format("nums2's length: %d\n", n));
			System.out.println(String.format("resulting array's length: %d\n", newArraySize));
			/*while(i>=0 && j>=0)*/
			while(i<m && j<n)
			{
				//nums2 = {-99, -8, -2, 0, 1, 2, 3, 8, 99}
				//nums1 = {-1, 0, 1}
				if(nums1[i] <= nums2[j])
				{
					resultingArray[k++] = nums1[i++]; 
				}else{
					
					resultingArray[k++] = nums2[j++];
				}
			}

			while(i < m)
			{
				resultingArray[k++] = nums1[i++];
			}

			while(j < n)
			{
				resultingArray[k++] = nums2[j++];
			}
			
			for(int x = 0; x<newArraySize; x++)
			{
				System.out.println(String.format("resulting array[%d]: %d\n", x, resultingArray[x]));
				System.out.println("");
			}
		}
	}
	public static List mergingSortedLists(List<List<Integer>> listOfLists)
	{
		List<Integer> result = new ArrayList<>();

		//Flatten the list
		for(List<Integer> list : listOfLists)
		{
			result.addAll(list);
		}

		//Sort the list
		Collections.sort(result);

		return result;
	}
	public static void main(String[] args)
	{
		int[] a = {};
		int[] b = {};
		int aSize = a.length;
		int bSize = b.length;
	
		int[] emptyArray = {};
		int[] nonEmptyArray = {0};
		int emptyArraySize = emptyArray.length;
		int nonEmptyArraySize = nonEmptyArray.length;

		int[] nums2 = {-99, -8, -2, 0, 1, 2, 3, 8, 99};
		int[] nums1 = {-1, 0, 1};
		int nums1Size = nums1.length;
		int nums2Size = nums2.length;
		
		System.out.println("Printing out all test cases\n");
		System.out.println("");
		mergingSortedArrays(a, b, aSize, bSize);
		mergingSortedArrays(emptyArray, nonEmptyArray, emptyArraySize, nonEmptyArraySize);
		mergingSortedArrays(nums1, nums2, nums1Size, nums2Size);

		System.out.println("Printing out all test cases of Pt 2\n");
		System.out.println("");
		//create a klist of lists
		List<List<Integer>> listOfLists = new ArrayList<>();
		//Creating inner Lists
		List<Integer> nums1List = new ArrayList<>();
		for(int i = 0; i<nums1Size; i++) 
		{ 
			nums1List.add(nums1[i]);
		}
		List<Integer> nums2List = new ArrayList<>();
		for(int i = 0; i<nums2Size; i++) 
		{ 
			nums2List.add(nums2[i]);
		}
		listOfLists.add(nums1List);
		listOfLists.add(nums2List);

		//Iterating through the list of lists before merging function
		/*for(List<Integer> innerList : listOfLists)
		{
			for(Integer element : innerList)
			{
				System.out.println(String.format("List value: %d\n", element));
				System.out.println("");
			}
		}*/

		//Iterating through the list of lists after the merging function

		List<Integer> sortedList = mergingSortedLists(listOfLists);

		for(Integer num : sortedList)
		{
			System.out.println(String.format("List value: %d\n", num));
		}

	}
}