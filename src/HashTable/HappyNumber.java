package HashTable;

import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {
        if( n ==1 || n==-1) return true;
        HashSet<Integer> h = new HashSet<Integer>();
        int m=0;
        while(true){
            while(n != 0){
                m = m + (n%10)*(n%10);
                n=n/10;
            }
            if(m == 1){
                return true;
            }
            if(!h.add(m)){
                return false;
            }
            n=m;
            m=0;
        }
    }
}
