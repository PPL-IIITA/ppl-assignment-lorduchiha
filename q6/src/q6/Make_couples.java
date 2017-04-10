/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Make_couples {
    public void make_couples(Boys[] b,Girls[] g){
        for(int i=0;i<50;i++){
           for(int j=0;j<100;j++){
               if(g[i].is_match(g[i], b[j]) && b[j].is_match(g[i],b[j])){
                   if(g[i].index != j){
                        g[i].status = false;
                        g[i].bf = b[j];
                        b[j].status = false;
                        b[j].gf = g[i];
                        b[j].index = i;
                        g[i].index = j;
                   }
               }
           }
        }
    }
}
