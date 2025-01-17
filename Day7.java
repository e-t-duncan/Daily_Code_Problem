
//Example
//Input:
//k = 3
//list1 = 1 -> 3 -> 5 -> 7
//list2 = 2 -> 4 -> 6
//list3 = 0 -> 8 -> 9 -> 10
//Output: 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10

public class Day7{

    public static void main(String[] args) {

        //create 3 arrays
        int[] list1 = {7, 3, 5, 1};
        int[] list2 = {2, 4, 5};
        int[] list3 = {0, 8, 9, 10};

        //create a new array to store the merged array
        int[] mergedList = new int[list1.length + list2.length + list3.length];

        //combine the 3 arrays into one
        int x = 0;
        for (int i = 0; i<list1.length; i++)
        {
            mergedList[x] = list1[i];
            x++;
        }
        for (int i = 0; i<list2.length; i++)
        {
            mergedList[x] = list2[i];
            x++;
        }
        for (int i = 0; i<list3.length; i++)
        {
            mergedList[x] = list3[i];
            x++;
        }

        int n = mergedList.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (mergedList[j] > mergedList[j + 1]) {
                
                    // swap temp and arr[i]
                    int temp = mergedList[j];
                    mergedList[j] = mergedList[j + 1];
                    mergedList[j + 1] = temp;
                }
            }
        }

        for(int i = 0; i < mergedList.length; i++)
        {
            System.out.println(mergedList[i]);
        }
    }
}