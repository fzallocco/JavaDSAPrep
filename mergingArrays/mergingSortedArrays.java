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
		/*case1: if m and n are 0, return empty list*/
		if(m==0 && n==0)
		{
			System.out.println("Both n and m are 0, no resulting array\n");//keep empty list as is
			System.out.println("");
		}
		/*case2: if either m or n are 0, we return the sorted array whose length is greater than 0 as the resulting array*/
		if(m!=0 && n==0)
		{
			System.out.println("m != 0, nums1 is the resulting array");
			//print out all integers inside array)
			for(int i = 0; i<m; i++)
			{
				System.out.println(String.format("nums1[%d]: %d\n", i, nums1[i]));
				System.out.println("");
			}
		}
		if(n!=0 && m==0)
		{
			System.out.println("n != 0, nums2 is the resulting array\n");
			//print out all integers inside array)
			for(int i = 0; i<n; i++)
			{
				System.out.println(String.format("nums2[%d]: %d\n", i, nums2[i]));
				System.out.println("");
			}
		}
		/*case3: m and n are both greater than 0, we integrate either array into the other and return it as the resulting array*/
		if(n>0 && m>0)
		{
			System.out.println("n & m are +ve, resulting array's length: m+n, modified nums1 is:\n");
			int newArraySize = n + m;
			//check the back of each array
			//if nums1[back] > nums2[back] insert nums1[back] into modifiedNums1[back]
			//else insert nums2[back] into modifiedNums1[back]
			int[] resultingArray = new int[newArraySize];
			int k = newArraySize-1;
			int i = m-1;
			int j = n-1;
			System.out.println(String.format("nums1's length: %d\n", m));
			System.out.println(String.format("nums2's length: %d\n", n));
			System.out.println(String.format("resulting array's length: %d\n", newArraySize));
			while(i>=0 && j>=0)
			{
				/*nums1 = {-99, -8, -2, 0, 1, 2, 3, 8, 99}*/
				/*nums2 = {-1, 0, 1}*/
				if(nums1[i] >= nums2[j])
				{
					/*i = 8, j = 2, K = 11, 99 >= 1 Yes*/
					/*i = 7, j = 2, K = 10, 8 >= 1 Yes*/
					/*i = 6, j = 2, K = 9, 3 >= 1 Yes*/
					/*i = 5, j = 2, K = 8, 2 >= 1 Yes*/
					/*i = 4, j = 2, K = 7, 1 >= 1 Yes => r[K] = n[i]*/
					/*i = 3, j = 2, K = 6, 0 >= 1 No => r[K] = n[j]*/
					/*i = 3, j = 1, K = 5, 0 >= 0 Yes => r[K] = n[i]*/
					/*i = 2, j = 1, K = 4, -2 >= 0 No => r[K] = n[j]*/
					/*i = 2, j = 0, K = 3, -2 >= -1 No => r[K] = n[j]*/
					resultingArray[k--] = nums1[i--]; 
				}else{
					
					resultingArray[k--] = nums2[j--];
				}
			}
			
			if(i>=0) 
			{//in case nums1 is longer than nums2
				while(k>= 0 && i >= 0)
				{
					resultingArray[k--] = nums1[i--];
				}
			}
			
			if(j>=0)
			{//in case nums2 is longer than nums1
				while(k >= 0 && j >= 0)
				{
					resultingArray[k--] = nums1[j--];
				}
			}
			
			for(int x = 0; x<newArraySize; x++)
			{
				System.out.println(String.format("resulting array[%d]: %d\n", x, resultingArray[x]));
				System.out.println("");
			}
		}
	}
	public static void mergingSortedLists(LinkedList<Integer>)
	{
		
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

		int[] nums1 = {-99, -8, -2, 0, 1, 2, 3, 8, 99};
		int[] nums2 = {-1, 0, 1};
		int nums1Size = nums1.length;
		int nums2Size = nums2.length;
		
		System.out.println("Printing out all test cases\n");
		System.out.println("");
		mergingSortedArrays(a, b, aSize, bSize);
		mergingSortedArrays(emptyArray, nonEmptyArray, emptyArraySize, nonEmptyArraySize);
		mergingSortedArrays(nums1, nums2, nums1Size, nums2Size);
	}
}