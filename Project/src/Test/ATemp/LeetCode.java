package Test.ATemp;

public class LeetCode {
    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int middle;

        while (start <= end) {
            middle = (start + end) / 2;

            if (nums[middle] == target) { return middle; }

            if (nums[middle] >= nums[start]) {
                if (target >= nums[start] && target < nums[middle]) {
                    end = middle-1;
                } else {
                    start = middle+1;
                }
            } else {
                if (target <= nums[end] && target > nums[middle]) {
                    start = middle+1;
                } else {
                    end = middle - 1;
                }
            }
        }
        return -1;
    }




    public static void main(String[]args){
        search(new int[]{1,3},0);
    }
}
