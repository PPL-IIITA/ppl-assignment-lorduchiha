/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
class sorting {
    public void sort(Boys[] b,Girls[] g,Gifts[] gft){
        int i,j,k;
        Boys temp;
        Girls temp2;
        Gifts temp3;
        for(i=0;i<100;i++){
            for(j=0;j<100-i-1;j++){
                if(b[j].attractiveness < b[j+1].attractiveness){
                    temp = b[j];
                    b[j] = b[j+1];
                    b[j+1] = temp;
                }
            }
        }
        for(i=0;i<50;i++){
            for(j=0;j<50-i-1;j++){
                if(g[j].maintenance > g[j+1].maintenance){
                    temp2 = g[j];
                    g[j] = g[j+1];
                    g[j+1] = temp2;
                }
            }
        }
        for(i=0;i<100;i++){
            for(j=0;j<100-i-1;j++){
                if(gft[j].value > gft[j+1].value){
                    temp3 = gft[j];
                    gft[j] = gft[j+1];
                    gft[j+1] = temp3;
                }
            }
        }
    }
}
