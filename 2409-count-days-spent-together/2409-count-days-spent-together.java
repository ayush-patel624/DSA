class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aam = Integer.parseInt(arriveAlice.substring(0,2));
        int aad = Integer.parseInt(arriveAlice.substring(3,5));

        int abm = Integer.parseInt(arriveBob.substring(0,2));
        int abd = Integer.parseInt(arriveBob.substring(3,5));

        int lam = Integer.parseInt(leaveAlice.substring(0,2));
        int lad = Integer.parseInt(leaveAlice.substring(3,5));

        int lbm = Integer.parseInt(leaveBob.substring(0,2));
        int lbd = Integer.parseInt(leaveBob.substring(3,5));

        int [] md = new int[]{0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if(lbm<aam || lam<abm) return 0;

        int sm = Math.max(abm,aam);
        int sd = sm==abm ? abd : aad;
        if(abm==aam) sd = Math.max(abd,aad);

        int em = Math.min(lbm,lam);
        int ed = em==lbm ? lbd : lad;
        if(lbm==lam) ed = Math.min(lbd,lad);

        int res=0;

        for(int i=sm;i<=em;i++){
            res+=md[i];
        }

        res-=sd-1;
        res-=md[em]-ed;

        return res<0 ? 0 : res;
        
    }
}