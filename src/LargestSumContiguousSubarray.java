/**
 * Created by rajat on 18/12/16.
 */
public class LargestSumContiguousSubarray {


    /*
    * "The Maximum Subarray problem: Given an array A of N elements, find maximum possible sum of a Contiguous Subarray
    *
    * */

    public static void main(String[] args) {

        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                findLargestSumContiguousSubArray(a));
        System.out.println("Maximum contiguous sum is " +
                findLargestSumNonContiguousSubArray(a));
    }


    public static int findLargestSumContiguousSubArray(int [] arr){
        int max_so_far = 0;
        int max_ending_here = 0;

        for(int index = 0 ; index < arr.length; index++){

            max_ending_here = max_ending_here + arr[index];
            if(max_ending_here <  0){
                max_ending_here = 0;
            }else{
                if(max_so_far < max_ending_here){
                    max_so_far = max_ending_here;
                }
            }
        }

        return max_so_far;
    }

    public static int findLargestSumNonContiguousSubArray(int [] arr){
        if(arr == null )
            return 0;
        int sum2 = 0;
        int sum1 =  arr[0];
        int sum3;

        for(int index = 1 ; index < arr.length; index++){
            sum3 = Math.max(sum1,sum2);
            sum2 = sum3;
            sum1 = sum2 + arr[index];

        }
        return Math.max(sum1,sum2);
    }
}
