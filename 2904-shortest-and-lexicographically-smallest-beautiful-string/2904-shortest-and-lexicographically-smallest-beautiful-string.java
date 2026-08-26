class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String res = "";
        int i=0;
        int j=0;
        int n = s.length();
        int min = Integer.MAX_VALUE;

        while(i<n){
            while(i<n && s.charAt(i)=='0') i++;
            j=i+1;
            StringBuilder sb = new StringBuilder();
            sb.append("1");
            int count=1;
            while(j<n && count<k){
                if(s.charAt(j)=='1') count++;
                sb.append(s.charAt(j));
                j++;
            }
            if(count==k && i<n){
               if(res.equals("")){
                res=sb.toString();
                min = res.length();
               }else if(sb.length()<min || (sb.length()==min && sb.toString().compareTo(res)<0)){
                 min=Math.min(min , sb.length());
                 res = sb.toString();
               }
            }
            i++;
        }
        return res;
    }
}