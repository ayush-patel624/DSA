class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int [] res = new int [n];

        int s0=0;
        int s1=0;
        
        int last=0;
        
        for(int i=0;i<n;i++){
            char c = seq.charAt(i);

            if(c=='('){
                if(s1<s0){
                    s1++;
                    last=1;
                    res[i]=last;
                }else{
                    s0++;
                    last=0;
                    res[i]=last;
                }
            }else{
                if(last==0){
                    s0--;
                    res[i]=0;
                    if(s0<s1) last=1;
                }else{
                    s1--;
                    res[i]=1;
                    if(s1<s0) last=0;
                }
            }
        }

        return res;
    }
}