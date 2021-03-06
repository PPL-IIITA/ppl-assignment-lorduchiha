/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
       //filling girls values
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
        Make_couples make = new Make_couples();
        make.make_couples(b, g);
        
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
        Random ran = new Random();
        int t;
        int tu;
        int l=1;
        t = ran.nextInt(10)+15;
        tu = t;
        while(true){
            if(t == 0){
                break;
            }
           System.out.println("day "+l);
            gg.calculate(gft,b,g);
            //for any randon k from 1 to 25
        long[] couples_happiness = new long[50];
        int[] ind = new int[50];
        for(i=0;i<50;i++){
            couples_happiness[i] = 0;
            ind[i] = -1;
        }
        z=0;
        for(i=0;i<100;i++){
            if(!b[i].status){
                couples_happiness[z] = (int) Math.abs(b[i].happiness + b[i].gf.happiness);
                ind[z++] = i;
            }
        }
        
        //sort
        long swap;
        int swap2;
        for(i=0;i<=z-1;i++){
           for(j=0;j<=z-1;j++){
               if(couples_happiness[j] > couples_happiness[j+1]){
                 swap = couples_happiness[j];
                 couples_happiness[j] = couples_happiness[j+1];
                 couples_happiness[j+1] = swap;
                 
                 swap2 = ind[j];
                 ind[j] = ind[j+1];
                 ind[j+1] = swap2;
               }
           }
        }
        String st="";
        String sr="";
        st = st + "BOYNAME   "+"  |  "+ "    RELATIONSHIP   "+"   |   "+ "    GIRLNAME"+"    "+ "   |   "  +  "    DATE    "+"   |   "+"   TIME"+"\n";
        sr = sr + "BOYNAME   "+"  |  "+ "    RELATIONSHIP   "+"   |   "+ "    GIRLNAME"+"   " +"    |   "  +  "    DATE    "+"   |   "+"   TIME"+"\n";
        st = st + "-----------------------------------------------------------------------------------------------------------"+"\n";
        sr = sr + "-----------------------------------------------------------------------------------------------------------"+"\n";
        for(i=0;i<tu;i++){
            if(ind[i] != -1){
                String s1 = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                String s2 = new SimpleDateFormat("hh:mm:ss").format(new Date());
                st = st + b[ind[i]].name+ "    broke up with     " +b[ind[i]].gf.name+"     "+s1+"    "+s2+"\n";
                b[ind[i]].break_up = true;
                b[ind[i]].gf.break_up = true;
                b[ind[i]].status = true;
                g[b[ind[i]].index].status = true; 
            }
        }
        
        make.make_couples(b, g);
        for(i=0;i<tu;i++){
            if(b[i].gf != null && b[i].status == false){
                String s1 = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                String s2 = new SimpleDateFormat("hh:mm:ss").format(new Date());
                sr = sr + b[i].name  +"     is commited to     " +b[i].gf.name  +"       "+s1+"    "+s2+"\n";
            }
        }
        
        try{
            FileWriter f = new FileWriter(new File("Q6_BREAKUPS.csv"));
            f.write(st);
            f.close();
            FileWriter fr = new FileWriter(new File("Q6_NEW_COUPLES_AFTER_BREAKUP.csv"));
            fr.write(sr);
            fr.close();
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        t--;
        l++;
       }
    }
}
