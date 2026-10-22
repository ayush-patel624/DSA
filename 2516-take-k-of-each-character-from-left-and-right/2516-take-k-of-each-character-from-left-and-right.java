class Solution {
    public int takeCharacters(String s, int k) {
    
        int n = s.length();
        int totA=0;
        int totB=0;
        int totC=0;
        
        for(char c : s.toCharArray()){
            if(c=='a') totA+=1;
            else if(c=='b')totB+=1;
            else totC+=1;
        }

        if(totA<k || totB<k || totC<k) return -1;

        int low=0;
        int high=0;
        int sumA=0;
        int sumB=0;
        int sumC=0;

        int res=0;

        while(high<n){
            char c = s.charAt(high);
            if(c=='a') sumA+=1;
            else if(c=='b') sumB+=1;
            else sumC+=1;

            while(totA-sumA < k || totB-sumB<k || totC - sumC < k){
                char x = s.charAt(low);
                if(x=='a') sumA-=1;
                else if(x=='b') sumB-=1;
                else sumC-=1;
                low++;
            }

            res=Math.max(res,high-low+1);
            high++;
        }
        return n-res;
    }
}