/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Initialize {
    public void start(Boys[] b, Girls[] g,Gifts[] gft) throws FileNotFoundException, IOException{
        Logger u = new Logger();
        u.boy_generator();
        u.girl_generator();
        u.gift_generator();
        BufferedReader br = null;
        String str = "";
        br = new BufferedReader(new FileReader("BOYS.csv"));
        int i=0;
        String b_name;
        int b_attr;
        int b_budget;
        int b_iq;
        int b_min_attr;
        String b_type;
        while((str = br.readLine())!= null){
            String[] boy = str.split(",");
            b_name = boy[0];
            b_iq = Integer.parseInt(boy[1]);
            b_attr = Integer.parseInt(boy[2]);
            b_min_attr = Integer.parseInt(boy[3]);
            b_budget = Integer.parseInt(boy[4]);
            b_type = boy[5];
            if(null != b_type)switch (b_type) {
                case "MISER":
                    b[i++] = new Miser(b_name,b_attr,b_budget,b_iq,b_min_attr,true);
                    break;
                case "GENEROUS":
                    b[i++] = new generous(b_name,b_attr,b_budget,b_iq,b_min_attr,true);
                    break;
                default:
                    b[i++] = new geek(b_name,b_attr,b_budget,b_iq,b_min_attr,true);
                    break;
            }
        }
        //filling details for girls
        String g_name;
        int g_attr;
        int g_maint;
        int g_iq;
        String g_type;
        String g_choice;
        BufferedReader br2 = null;
        String str2="";
        br2 = new BufferedReader(new FileReader("GIRLS.csv"));
        int j=0;
        while((str2 = br2.readLine())!= null){
            String[] girl = str2.split(",");
            g_name = girl[0];
            g_iq = Integer.parseInt(girl[1]);
            g_attr = Integer.parseInt(girl[2]);
            g_maint = Integer.parseInt(girl[3]);
            g_type = girl[4];
            g_choice = girl[5];
            if(null != g_type)switch (g_type) {
                case "CHOOSY":
                    g[j++] = new choosy(g_name,g_attr,g_maint,g_iq,g_choice,true);
                    break;
                case "NORMAL":
                    g[j++] = new normal(g_name,g_attr,g_maint,g_iq,g_choice,true);
                    break;
                default:
                    g[j++] = new desperate(g_name,g_attr,g_maint,g_iq,g_choice,true);
                    break;
            }
        }
        int p,q;
        for(p=0;p<50;p++){
            for(q=0;q<100;q++){
                if(g[p].is_match(g[p], b[q]) && b[q].is_match(g[p],b[q])){
                    g[p].status = false;
                    b[q].status = false;
                    b[q].gf = g[p];
                    g[p].bf = b[q];
                }
            }
        }
        
        //filling values for gifts
       
        String type;
        int price;
        int value;
        BufferedReader br3 = new BufferedReader(new FileReader("GIFTS.csv"));
        int z=0;
        String str3="";
        while((str3 = br3.readLine())!= null){
            String[] gift = str3.split(",");
            type = gift[0];
            price = Integer.parseInt(gift[1]);
            value = Integer.parseInt(gift[2]);
            if(null != type)switch (type) {
                case "LUXURY":
                    gft[z++] = new luxury(price,value);
                    break;
                case "ESSENTIAL":
                    gft[z++] = new essential(price,value);
                    break;
                default:
                    gft[z++] = new utility(price,value);
                    break;
            }
        }
    }
}
