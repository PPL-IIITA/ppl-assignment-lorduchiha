/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
class makeCouples {
    public void make(Boys[] b, Girls[] g,int t){
        int p,q;
        Random ran = new Random();
        for(p=0;p<100;p++){
           q = ran.nextInt(t)+1; 
           if(b[p].is_match(g[q], b[p]) && g[q].is_match(g[q],b[p])){
               b[p].gf = g[q];
               b[p].status = false;
               g[q].status = false;
               g[q].bf = b[p];
            }
        }
    }
}
