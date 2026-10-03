class Solution {
    public int compress(char[] chars) {
        int k=0;
        char last = chars[0];
        int count=0;

        for(char c : chars){
            if(c==last){
                count++;
            }else{
                chars[k++]=last;
                if(count>1){
                    String n = String.valueOf(count);
                    for(char x : n.toCharArray()) chars[k++]=x;
                }
                last=c;
                count=1;
            }
        }

        chars[k++]=last;

        if(count>1){
            String n = String.valueOf(count);
            for(char x : n.toCharArray()) chars[k++]=x;
        }

        return k;
    }
}