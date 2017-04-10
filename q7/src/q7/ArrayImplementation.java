/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class ArrayImplementation {
    public void find_girl(String[] searchBoys,String[] result,Girls[] g,int t){
        int i,j,k;
        for(i=0;i<t;i++){
            for(j=0;j<50;j++){
                if(g[j].bf != null){
                    if(searchBoys[i].equals(g[j].bf.name)){
                        result[i] = g[j].name;
                    }
                }
            }
        }
    }
}
