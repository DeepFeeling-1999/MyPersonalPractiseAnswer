package Test.ATemp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode {


    public static int longestConsecutive(int[] nums) {
        int ans=0;
        Arrays.sort(nums);
        for(int j=0,i=1;i<nums.length;i++){
            if(nums[i]-nums[j]==i-j){
                ans=i-j+1;
            }else{
                j++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        
    }
}