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
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;



public class Main {
       public static void main(String[] args) throws FileNotFoundException, IOException{
        Logger u = new Logger();
        u.boy_generator();
        u.girl_generator();
       
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
        int t;
        Random ran = new Random();
        t = ran.nextInt(10)+15;
        String[] searchBoys = new String[t];
        int index;
        //making random search list for boys name;
        int[] inarr = new int[t];
        for(i=0;i<t;i++){
            index = ran.nextInt(100);
            searchBoys[i] = b[index].name;
            inarr[i] = index;
        }
        String[] result = new String[t];
        for(i=0;i<t;i++){
            result[i] = null;
        }
        int ch=0;
        Scanner sc = new Scanner(System.in);
        while(ch != 4){
            System.out.println("1.Array Implementation   2.Binary_Search  3.HashTable Implementation  4.Exit");
            ch = sc.nextInt();
            switch(ch){
                case 1: ArrayImplementation arrResult = new ArrayImplementation();
                        arrResult.find_girl(searchBoys,result,g,t);
                        break;
                case 3 : HashImplementation hashing = new HashImplementation();
                         hashing.make_hash(searchBoys,result,b,g,t,inarr);
                         break;
                         
                case 4 : System.exit(0x0);
                         break;
                        
            }
        }
        //filling values for gift
        String st = "";
        st = st + "BOYNAME   "+"  |  "+ "    RELATIONSHIP   "+"   |   "+ "    GIRLNAME"+"    "+ "   |   "  +  "    DATE    "+"   |   "+"   TIME"+"\n"; 
        st = st + "--------------------------------------------------------------------------------------------"+"\n";
        for(i=0;i<t;i++){
           if(result[i] != null){
               String s1 = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
               String s2 = new SimpleDateFormat("hh:mm:ss").format(new Date());
               st = st+searchBoys[i]+"'s"+ "        girlfriend is       " +result[i] +"     committed on  "+s1+"   at   "+s2+"\n";
           }
           else{
               String s1 = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
               String s2 = new SimpleDateFormat("hh:mm:ss").format(new Date());
               st = st+searchBoys[i]+"'s"+ "        is single       "  +s1+"   at   "+s2+"\n";
           }
           
             
        }
        try{
            FileWriter f = new FileWriter(new File("Q7_ARRAY_IMPLEMENTATION_COUPLES.csv"));
            f.write(st);
            f.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
   }
}

