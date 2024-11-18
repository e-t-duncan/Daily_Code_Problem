
//Given an unsorted array of integers, find the length of the longest consecutive sequence. The sequence can be in any order, but numbers must be consecutive integers.
//Constraints:
//Your algorithm should run in 𝑂(𝑛) time complexity.


public class Day1{
    public static void main(String[] args)
    {
        //define the array
        int[] nums = {100, 4, 200, 1, 3, 2}; 

        //perform a bubble sort on the array
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < nums.length - 1; i++) {
            swapped = false;
            for (j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    
                    // Swap arr[j] and arr[j+1]
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }

        //now check the longest conseq sequence
        int longestConseq = 1;
        int currentConseq = 1;
        for (int k = 0; k < nums.length - 1; k++) {
            if (nums[k] + 1 == nums[k + 1]) {
                currentConseq++;
            } else if (nums[k] != nums[k + 1]) {
                if (currentConseq > longestConseq) {
                    longestConseq = currentConseq;
                }
                currentConseq = 1;
            }
        }
        //print the longest conseq sequence
        System.out.println("The longest consecutive sequence is: " + longestConseq);
    }
    
}

