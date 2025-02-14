import java.util.*;
import java.lang.*;
class twoSum{
	
	public static int[] twoSum(int[] arr, int target)
	{
		Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }

        return null;
	}
		
	public static void main(String[] args)
	{
		int[] nums = {2, 7, 11, 15};
		int[] ints = {3, 2, 4};
		int[] digits = {3, 3};
		int targetOne = 9;
		int targetTwo = 6;
		int targetThree = 6;
		int[] result = twoSum(nums, targetOne);
		
		for(int x = 0; x<result.length; x++)
		{
			System.out.println(result[x]);
		}
	}
}