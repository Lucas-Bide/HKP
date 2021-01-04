/**
 * Class with method that identifies the interval of the sequence of a
 * number in an array.
 */
class Solution
{
	public static void main(String[] args)
	{
		Solution s = new Solution();
		// will always look for the number 4
		// different cases for most tests
		int[][] tests = { 	
							{},
							{1},
							{1,1},
							{1,1,1},
							{5},
							{5,5},
							{5,5,5},
							{4},
							{1,4},
							{4,1},
							{4,4,4,4,4,4},
							{1,1,1,1,4,4,6},
							{1,4,4,5,5,5},
							{1,2,3,4,4,4,4,5,6,7,8},
							{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,7},
							{1,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4} 
						};

		for (int i = 0; i < tests.length; i++)
		{
			int[] itr = s.searchRange(tests[i], 4);
			int[] rec = s.srLog(tests[i], 4);
			System.out.printf("itr: [%d, %d] -- rec: [%d, %d]\n\n", itr[0], itr[1], rec[0], rec[1]);
		}
	}

	/**
	 * Identifies the interval of the sequence of target in nums.
	 * @param nums the array of sequences
	 * @param target the number whose sequence is sought
	 * @return an array with the start and end positions of the interval
	 * or [-1, -1] if the interval isn't present.
	 */
	public int[] searchRange(int[] nums, int target)
	{
		int[] positions = {-1, -1};
	   	for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] == target)
			{
				if (positions[0] == -1)
				{
					positions[0] = i;
				}
				positions[1] = i;
			}
			else if (nums[i] > target) // end early
			{
				break;
			}
		}
		return positions;
	}

	/*
	 * Same as above but o(log n) time.
	 */
	public int[] srLog(int[] nums, int target)
	{
		int[] positions = {-1, -1};
		if (nums.length > 0)
		{
			positions[0] = srRecLower(nums, target, 0, nums.length - 1);

			if (positions[0] != -1)
			{
				positions[1] = srRecUpper(nums, target, positions[0], nums.length -1);
			}
		}
		return positions;
	}

	/**
	 * Recursively find the lower bound of the interval.
	 * @param nums the array of sequences
	 * @param target the number whose sequence is sought
	 * @param maxmin the maximun known position of a value less than target
	 * @param startpos the first occurence of target; initially the last index
	 * @return the index of the lower bound of the interval
	 */
	private int srRecLower(int[] nums, int target, int maxmin, int startpos)
	{
		int mid = maxmin + (startpos - maxmin) / 2;

		if (nums[mid] < target)
		{
			if (mid < nums.length - 1)
			{
				if (nums[mid + 1] != target)
				{
					startpos = updatePos(nums, target, startpos, srRecLower(nums, target, mid + 1, startpos));
				}
				else
				{
					startpos = mid + 1;
				}
			}
			else
			{
				startpos = -1;
			}		
		}
		else if (nums[mid] >= target)
		{
			if (mid > 0)
			{
				if (nums[mid - 1] >= target)
				{
					startpos = updatePos(nums, target, startpos, srRecLower(nums, target, maxmin, mid - 1));
				}
				else
				{
					startpos = mid;	
				}
			}
			else if (nums[mid] == target)
			{
				startpos = mid;
			}
			else
			{
				startpos = -1;
			}
		}
		return startpos;
	}

	/**
	 * Recursively find the upper bound of the interval.
	 * Only call if a lower bound is found.
	 * @param nums the array of sequences
	 * @param target the number whose sequence is sought
	 * @param startpos the first occurence of target
	 * @param endpos the last occurrence of target
	 * @return the index of the upper bound of the interval
	 */
	private int srRecUpper(int[] nums, int target, int startpos, int endpos)
	{
		int mid = startpos + (endpos - startpos) / 2;

		if (nums[mid] > target)
		{
			if (nums[mid - 1] > target)
			{
				endpos = srRecUpper(nums, target, startpos, mid - 1);
			}
			else
			{
				endpos = mid - 1;	
			}
		}
		else if (nums[mid] == target)
		{
			if (mid < nums.length - 1)
			{
				if (nums[mid + 1] == target)
				{
					endpos = srRecUpper(nums, target, mid + 1, endpos);
				}
				else
				{
					endpos = mid;
				}
			}
			else
			{
				endpos = mid;
			}
		}
		return endpos;
	}

	/**
	 * Determine whether to update oldpos with newpos
	 * @param nums the array of sequences
	 * @param target the number whose sequence is sought
	 * @param oldpos value of pos before recursive call
	 * @param newpos value of pos from recursive call
	 * @return updated position
	 */
	private int updatePos(int[] nums, int target, int oldpos, int newpos)
	{
		if (newpos != -1 || nums[oldpos] != target)
		{
			oldpos = newpos;
		}
		return oldpos;
	}
}
