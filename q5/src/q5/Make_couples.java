/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q5;



public class Make_couples {
    public void make_couples(Boys[] b,Girls[] g){
        int turn = 0;
        for(int i=0;i<50;i++){
            if(turn == 0){
                girl_turn(b,g);
                turn = 1;
            }
            else if(turn == 1){
                boy_turn(b,g);
                turn = 0;
            }
        }
    }

    private void girl_turn(Boys[] b, Girls[] g) {
        int flag = 0;
        for(int i=0;i<50;i++){
            for(int j=0;j<100;j++){
                if(g[i].is_match(g[i], b[j]) && b[j].is_match(g[i],b[j])){
                    g[i].status = false;
                    g[i].bf = b[j];
                    b[j].status = false;
                    b[j].gf = g[i];
                    flag = 1;
                    break;
                }
            }
            if(flag == 1){
                break;
            }
        }
    }

    private void boy_turn(Boys[] b, Girls[] g) {
        int flag = 0;
        for(int j=0;j<100;j++){
            for(int i=0;i<50;i++){
                if(g[i].is_match(g[i], b[j]) && b[j].is_match(g[i],b[j])){
                    g[i].status = false;
                    g[i].bf = b[j];
                    b[j].status = false;
                    b[j].gf = g[i];
                    flag = 1;
                    break;
                }
            }
            if(flag == 1){
                break;
            }
        }
    }
}
