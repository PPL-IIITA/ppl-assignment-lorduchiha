/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q9;

/**
 *
 * @author pride
 */
class makeCouples {
    public void make(Boys[] b, Girls[] g,int t){
        int p,q;
        for(p=0;p<50;p++){
            for(q=0;q<100;q++){
                if(g[p].is_match(g[p], b[q],t,p,q) && b[q].is_match(g[p],b[q],t,p,q)){
                    g[p].status = false;
                    b[q].status = false;
                    b[q].gf = g[p];
                    g[p].bf = b[q];
                }
            }
        }
    }
}
