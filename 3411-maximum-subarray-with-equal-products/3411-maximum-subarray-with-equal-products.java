class Solution {

    static int fgcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    static int flcm(int a, int b) {
        return (a / fgcd(a, b)) * b;
    }

    public int maxLength(int[] nums) {
        int res=1;

        for(int i=0;i<nums.length;i++){
            int prod=nums[i];
            int gcd=nums[i];
            int lcm=nums[i];
            for(int j=i+1;j<nums.length;j++){
                prod *= nums[j];
                gcd = fgcd(gcd,nums[j]);
                lcm = flcm(lcm,nums[j]);
                if(prod == lcm*gcd) res = Math.max(res,j-i+1);
            }
        }
        return res;
    }
}