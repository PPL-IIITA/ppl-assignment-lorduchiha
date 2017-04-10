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
import java.util.Scanner;



public class Main {
       public static void main(String[] args) throws FileNotFoundException, IOException{
        Initialize init = new Initialize();
        int ch;
        System.out.println("SELECT CHOICE :");
        System.out.println("1.DEFAULT    2.NEW GIFTING METHOD    3.EXIT");
        Scanner sc = new Scanner(System.in);
        ch = 1;
        Newgiftingmethod gm = new Newgiftingmethod();
        Gifting gg = new Gifting();
        Random r = new Random();
        int k = r.nextInt(10)+15;
        Boys[] b = new Boys[100];
        Girls[] g = new Girls[50];
        Gifts[] gft = new Gifts[100];
        init.start(b,g,gft);
        while(ch != 3){
            ch = sc.nextInt();
            switch(ch){
                case 1:
                        gg.calculate(gft,b,g);
                        find_happy_defaut(b,g,k);
                        System.out.println("FILE CREATED !");       
                        break;
                case 2: 
                        gm.calculate(gft,b,g);
                        find_happy_alternate(b,g,k);
                        System.out.println("FILE CREATED !");
                        break;
                case 3: System.out.println("EXITING");
                        break;
            }
        }
   }
    private static void find_happy_defaut(Boys[] b, Girls[] g,int k) {
        //System.out.println(k);
        int[] couples_happiness = new int[50];
        int[] ind = new int[50];
        for(int i=0;i<50;i++){
            couples_happiness[i] = 0;
            ind[i] = -1;
        }
        int z=0;
        for(int i=0;i<100;i++){
            if(!b[i].status){
                couples_happiness[z] = b[i].happiness + b[i].gf.happiness;
                ind[z++] = i;
            }
        }
        //sort
        int swap;
        for(int i=0;i<50;i++){
           for(int j=0;j<50-i-1;j++){
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
        for(int i=0;i<k;i++){
            if(ind[i] != -1){
            String s1 = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            String s2 = new SimpleDateFormat("hh:mm:ss").format(new Date());
            st = st+b[ind[i]].name+"    commited to   "+b[ind[i]].gf.name +"     on  "+s1+"   at   "+s2+"\n";
            }
        }
        try{
            
            FileWriter f = new FileWriter(new File("Q8_HAPPIEST_COUPLES_DEFAULT_METHOD.csv"));
            f.write(st);
            f.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }      
    }
    private static void find_happy_alternate(Boys[] b, Girls[] g,int k) {
        int[] couples_happiness = new int[50];
        int[] ind = new int[50];
        for(int i=0;i<50;i++){
            couples_happiness[i] = 0;
            ind[i] = -1;
        }
        int z=0;
        for(int i=0;i<100;i++){
            if(!b[i].status){
                couples_happiness[z] = b[i].happiness + b[i].gf.happiness;
                ind[z++] = i;
            }
        }
        //sort
        int swap;
        for(int i=0;i<50;i++){
           for(int j=0;j<50-i-1;j++){
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
        for(int i=0;i<k;i++){
            if(ind[i]!=-1){
            String s1 = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            String s2 = new SimpleDateFormat("hh:mm:ss").format(new Date());
            st = st+b[ind[i]].name+"    commited to   "+b[ind[i]].gf.name +"     on  "+s1+"   at   "+s2+"\n";
            }
        }
        try{
            
            FileWriter f = new FileWriter(new File("Q8_HAPPIEST_COUPLES_ALTERNATE_METHOD.csv"));
            f.write(st);
            f.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }      
    }
}

