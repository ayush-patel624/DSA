class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map = new HashMap<>();

        for(int i=0;i<knowledge.size();i++){
            String key = knowledge.get(i).get(0);
            String value = knowledge.get(i).get(1);

            map.put(key,value);
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(c!='('){
                sb.append(c);
                continue;
            }

            int j=i+1;
            StringBuilder temp = new StringBuilder();

            while(s.charAt(j)!=')'){
                temp.append(s.charAt(j));
                j++;
            }

            if(map.containsKey(temp.toString())){
                sb.append(map.get(temp.toString()));
            }else{
                sb.append('?');
            }

            i=j;

        }

        return sb.toString();
    }
}