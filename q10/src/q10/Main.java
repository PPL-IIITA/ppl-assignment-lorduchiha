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
        Boys[] b = new Boys[100];
        Girls[] g = new Girls[50];
        Gifts[] gft = new Gifts[100];
        Initialize init = new Initialize();
        init.init(b, g, gft);
        
        Random ran = new Random();
        int t = ran.nextInt(10)+15;
        sorting sort = new sorting();
        sort.sort(b,g,gft);
        makeCouples couples = new makeCouples();
        couples.make(b,g,t);
        
        Gifting gg = new Gifting();
        gg.calculate(gft,b,g,t);
        
        //for any randon k from 1 to 25
        int i,j;
        Random r = new Random();
        int k = r.nextInt(30)+1;
        int[] couples_happiness = new int[50];
        int[] ind = new int[50];
        for(i=0;i<50;i++){
            couples_happiness[i] = 0;
            ind[i] = -1;
        }
        int z=0;
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
        String st=""; 
        st = st + "BOYNAME   "+"  |  "+ "    RELATIONSHIP   "+"   |   "+ "    GIRLNAME"+"    "+ "   |   "  +  "    DATE    "+"   |   "+"   TIME"+"\n";
        st = st + "--------------------------------------------------------------------------------------------"+"\n";
        for(i=0;i<k;i++){
            if(ind[i]!=-1){
            String s1 = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            String s2 = new SimpleDateFormat("hh:mm:ss").format(new Date());
            st = st+b[ind[i]].name+"    commited to   "+b[ind[i]].gf.name +"     on  "+s1+"   at   "+s2+"\n";
        
            }
        }
        try{
            FileWriter f = new FileWriter(new File("Q10_HAPPIEST_COUPLES.csv"));
            f.write(st);
            f.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
   }
}

