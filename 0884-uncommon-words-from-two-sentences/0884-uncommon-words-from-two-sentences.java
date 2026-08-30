class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        ArrayList<String> unc = new ArrayList<>();

        HashMap<String,Integer> map = new HashMap<>();

        int i=0;

        while(i<s1.length()){
            int j=i;
            StringBuilder sb = new StringBuilder();
            while(j<s1.length() && s1.charAt(j)!=' '){
                sb.append(s1.charAt(j));
                j++;
            }
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
            i=j+1;
        }
        i=0;
        while(i<s2.length()){
            int j=i;
            StringBuilder sb = new StringBuilder();
            while(j<s2.length() && s2.charAt(j)!=' '){
                sb.append(s2.charAt(j));
                j++;
            }
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
            i=j+1;
        }

        for(String s : map.keySet()){
            if(map.get(s)==1) unc.add(s);
        }

        int n = unc.size();

        String[] res = new String[n];

        int k=0;

        for(String s : unc) {
            res[k++] =s;
        }

        return res;
    }
}