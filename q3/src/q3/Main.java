/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;



public class Main {
       public static void main(String[] args) throws FileNotFoundException, IOException{
        Logger u = new Logger();
        u.boy_generator();
        u.girl_generator();
        u.gift_generator();
       
        Boys[] b = new Boys[100];
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
       Girls[] g = new Girls[50];
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
       
        Gifts[] gft = new Gifts[100];
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
        
        Gifting gg = new Gifting();
        gg.calculate(gft,b,g);
        
        //for any randon k from 1 to 25
        Random r = new Random();
        int k = r.nextInt(30)+1;
        int[] couples_happiness = new int[50];
        int[] ind = new int[50];
        for(i=0;i<50;i++){
            couples_happiness[i] = 0;
            ind[i] = -1;
        }
        z=0;
        for(i=0;i<100;i++){
            if(!b[i].status){
                couples_happiness[z] = b[i].happiness + b[i].gf.happiness;
                ind[z++] = i;
            }
        }
        //sort
        int swap;
        for(i=0;i<50;i++){
           for(j=0;j<50-i-1;j++){
               if(couples_happiness[j] < couples_happiness[j+1]){
                 swap = couples_happiness[j];
                 couples_happiness[j] = couples_happiness[j+1];
                 couples_happiness[j+1] = swap;
                 
                 swap = ind[j];
                 ind[j] = ind[j+1];
                 ind[j+1] = swap;
               }
           }
        }
        String sr="";
        String st="";
        int[] comp = new int[50];
        for(i=0;i<50;i++){
            comp[i] = 0;
        }
        int sum =0;
        int diff;
        int[] ind1 = new int[50];
        for(i=0;i<50;i++){
            ind1[i] = i;
        }
        z=0;
        for(i=0;i<50;i++){
            sum = 0;
            if(!b[i].status){
                sum = sum + (b[i].budget - b[i].gf.maintenance);
                diff = b[i].min_attraction - b[i].gf.attractiveness;
                sum = sum + Math.abs(diff);
                diff = b[i].intelligence - b[i].gf.intelligence;
                sum = sum + Math.abs(diff);
                comp[z] = sum;
                ind1[z] = i;
                z++;
            }
            
        }
        for(i=0;i<50;i++){
           for(j=0;j<50-i-1;j++){
               if(comp[j] < comp[j+1]){
                 swap = comp[j];
                 comp[j] = comp[j+1];
                 comp[j+1] = swap;
                 
                 swap = ind1[j];
                 ind1[j] = ind1[j+1];
                 ind1[j+1] = swap;
               }
           }
        }
        st = st + "BOYNAME   "+"  |  "+ "    RELATIONSHIP   "+"   |   "+ "    GIRLNAME"+"    "+ "   |   "  +  "    DATE    "+"   |   "+"   TIME"+"\n";
        sr = sr + "BOYNAME   "+"  |  "+ "    RELATIONSHIP   "+"   |   "+ "    GIRLNAME"+"   " +"    DATE     "+"   |   "+  "TIME" +"\n";
        st = st + "--------------------------------------------------------------------------------------------"+"\n";
        sr = sr + "--------------------------------------------------------------------------------------------"+"\n";
        for(i=0;i<k;i++){
            if(ind[i]!=-1){
            String s1 = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            String s2 = new SimpleDateFormat("hh:mm:ss").format(new Date());
            st = st+b[ind[i]].name+"    commited to   "+b[ind[i]].gf.name +"     on  "+s1+"   at   "+s2+"\n";
            sr = sr+b[ind1[i]].name+"   commited to   "+b[ind1[i]].gf.name+"   on    "+s1+"   at   "+s2+"\n";
        
            }
        }
        try{
            FileWriter f = new FileWriter(new File("Q3_HAPPIEST_COUPLES.csv"));
            f.write(st);
            f.close();
            FileWriter fr = new FileWriter(new File("Q3_MOST_COMPATIBLE_COUPLES.csv"));
            fr.write(sr);
            fr.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
   }
}

