class Solution {
    public boolean checkDivisibility(int n) {
        int sum =0;
        int prod=1;

        int temp=n;

        while(temp>0){
            int num = temp%10;
            sum+=num;
            prod*=num;
            temp/=10;
        }

        return n % (sum+prod) ==0 ? true : false;
    }
}