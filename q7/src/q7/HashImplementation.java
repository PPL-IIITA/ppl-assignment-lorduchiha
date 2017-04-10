/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Enumeration;
import java.util.Hashtable;


public class HashImplementation {
    public void make_hash(String[] searchBoys,String[] result,Boys[] b,Girls[] g, int t,int[] index){
            int hash;
            Hashtable boys_hashtable = new Hashtable();
            for(int i=0;i<t;i++){
                boys_hashtable.put(index[i],searchBoys[i]);
            }
        
            
            find_Result(searchBoys,result,b,g,t,boys_hashtable,index);
    }
    

    private void find_Result(String[] searchBoys, String[] result, Boys[] b, Girls[] g, int t, Hashtable boys_hashtable,int[] inarr) {
        int hash ;
        Hashtable boys = new Hashtable();
        for(int i =0;i<100;i++){
                boys.put(i,b[i].name);
        }
        int s_hash,b_hash;
        for(int i=0;i<t;i++){
            s_hash = inarr[i];
            for(int j=0;j<100;j++){
                b_hash = j;
                if(boys_hashtable.get(s_hash) == boys.get(b_hash)){
                    result[i] = b[j].gf.name;
                    break;
                }
            }
        }

    }
}
