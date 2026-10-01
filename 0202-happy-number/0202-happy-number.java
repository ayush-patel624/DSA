class Solution {
    int sum(int n){
        int res=0;

        while(n>0){
            int temp = n%10;
            res+= temp*temp;
            n=n/10;
        }

        return res;
    }

    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;

        while(fast!=1){
            slow=sum(slow);
            fast=sum(fast);
            fast=sum(fast);

            if(slow==fast && slow!=1) return false;

            
        }

        return true;
    }
}