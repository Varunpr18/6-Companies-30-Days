//12th-prblm
class Solution {
    public int maxRotateFunction(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int n = nums.length;
        int sum = 0, prevProduct = 0;

        for(int i = 0; i < n; i++) //Calculating f[0] and total sum of nums here 
        {
            sum += nums[i]; //f[0] Sum
            prevProduct += (nums[i] * i); //f[0] value*index = product
        }

    

        int ans = prevProduct;

        for(int k = 1; k < n; k++) //ignoring the 0th index and starting from 1
        {
            int newProduct = prevProduct + (nums[k - 1] * (n - 1)) - (sum - nums[k - 1]);
            prevProduct = newProduct;
            ans = Math.max(newProduct, ans);
        }

        return ans;
    }
}
