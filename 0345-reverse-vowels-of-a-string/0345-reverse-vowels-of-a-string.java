class Solution {
    public String reverseVowels(String s) {
        char [] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        int low=0;
        int high=arr.length-1;

        while(low<high){
            while(low < arr.length && !set.contains(arr[low])) low++;
            while(high>=0 && !set.contains(arr[high])) high--;

            if(low<high){
                char temp=arr[low];
                arr[low]=arr[high];
                arr[high]=temp;

                low++;
                high--;
            }
        }

        for(char c : arr) sb.append(c);
        return sb.toString();
    }
}