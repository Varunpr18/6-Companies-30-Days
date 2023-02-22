//5th-prblm
class Solution{
    int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b,a%b);
    }
        
    public int minOperaations(int[] nums, int[] numsDivide) {
        
        Arrays.sort(nums);
        
        int divisor = numsDivide[0];
        for(int i: numsDivide)
            divisor = gcd(divisor, i);
        
        int l = -1;
        for(int i = 0; i < nums.length; i++){
            if(divisor % nums[i] == 0){
                l = i;
                break;
                    
            }
        }
        
        return l;
        
    }
}
