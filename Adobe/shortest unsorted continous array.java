//14th
public class Solution{
    public int findUnsortedSubarray(int[] nums){
        int start =0;
        int n = nums.length;
        int[] temp = nums.clone();
        Arrays.sort(temp);
        

        
        while(start<n && nums[start] == temp[start] )
        start++;

        int end=n-1;
        while(end>start && nums[end] == temp[end])
        end--;

        return end-start+1;
    }
}
