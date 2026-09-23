class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n_5=0, n_10=0, n_20=0;

        for(int i=0; i<bills.length; i++) {
            if(bills[i] == 5) {
                n_5++;
            } else if(bills[i] == 10) {
                if(n_5 > 0) {
                    n_5--;
                    n_10++;
                } else {
                    return false;
                }
            } else {
                if(n_5>0 && n_10>0) {
                    n_5--;
                    n_10--;
                    n_20++;
                } else if(n_5>2) {
                    n_5-=3;
                    n_20++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}