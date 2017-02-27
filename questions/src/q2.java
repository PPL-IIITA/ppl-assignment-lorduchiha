import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
public class q2 {
   public static void main(String args[]) throws FileNotFoundException, IOException{
        Utility u = new Utility();
        u.gift_generator();
       
        Boys[] b = new Boys[50];
        BufferedReader br = null;
        String str = "";
        br = new BufferedReader(new FileReader("BOY.csv"));
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
            b[i++] = new Boys(b_name,b_budget,b_iq,b_attr,b_min_attr,b_type,true);
        }
        
        //filling details for girls
        Girls[] g = new Girls[25];
        String g_name;
        int g_attr;
        int g_maint;
        int g_iq;
        String g_type;
        String g_choice;
        BufferedReader br2 = null;
        String str2="";
        br2 = new BufferedReader(new FileReader("GIRL.csv"));
        int j=0;
        while((str2 = br2.readLine())!= null){
            String[] girl = str2.split(",");
            g_name = girl[0];
            g_iq = Integer.parseInt(girl[1]);
            g_attr = Integer.parseInt(girl[2]);
            g_maint = Integer.parseInt(girl[3]);
            g_type = girl[4];
            g_choice = girl[5];
            g[j++] = new Girls(g_name,g_maint,g_attr,g_iq,g_type,g_choice,true);
        }
        int p,q;
        for(p=0;p<25;p++){
            for(q=0;q<50;q++){
                if(g[p].is_match(g[p], b[q])&&b[q].is_match(g[p],b[q])){
                    g[p].is_single = false;
                    b[q].is_single = false;
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
        BufferedReader br3 = new BufferedReader(new FileReader("GIFT.csv"));
        int z=0;
        String str3="";
        while((str3 = br3.readLine())!= null){
            String[] gift = str3.split(",");
            type = gift[0];
            price = Integer.parseInt(gift[1]);
            value = Integer.parseInt(gift[2]);
            
            gft[z++] = new Gifts(type,price,value);
        }
        
        Gifting gg = new Gifting();
        gg.calculate(gft,b,g);
        
        //for any randon k from 1 to 25
        Random r = new Random();
        int k = r.nextInt(25)+1;
        int[] couples_happiness = new int[25];
        int[] ind = new int[25];
        for(i=0;i<25;i++){
            couples_happiness[i] = 0;
            ind[i] = 0;
        }
        z=0;
        for(i=0;i<50;i++){
            if(!b[i].is_single){
                couples_happiness[z] = b[i].happiness + b[i].gf.happiness;
                ind[z++] = i;
            }
        }
        //sort
        int swap;
        for(i=0;i<25;i++){
           for(j=0;j<25-i-1;j++){
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
        int[] comp = new int[25];
        for(i=0;i<25;i++){
            comp[i] = 0;
        }
        int sum =0;
        int diff;
        int[] ind1 = new int[25];
        for(i=0;i<25;i++){
            ind1[i] = i;
        }
        z=0;
        for(i=0;i<50;i++){
            sum = 0;
            if(!b[i].is_single){
                sum = sum + (b[i].budget - b[i].gf.maintenence_budget);
                diff = b[i].attraction_factor - b[i].gf.attractiveness_factor;
                sum = sum + Math.abs(diff);
                diff = b[i].intelligence_factor - b[i].gf.intelligence_factor;
                sum = sum + Math.abs(diff);
                comp[z] = sum;
                ind1[z] = i;
                z++;
            }
            
        }
        for(i=0;i<25;i++){
           for(j=0;j<25-i-1;j++){
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
        int inde;
        for(i=0;i<k;i++){
            inde = i+1;
            String s1 = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
            String s2 = new SimpleDateFormat("hh:mm:ss").format(new Date());
            st = st+inde+"->"+b[ind[i]].name+"commited to"+b[ind[i]].gf.name +" on "+s1+" at "+s2+"\n";
            sr = sr+inde+"->"+b[ind1[i]].name+"commited to"+b[ind1[i]].gf.name+"on"+s1+" at "+s1+"\n";
        }
        try{
            FileWriter f = new FileWriter(new File("Happiest_couples.csv"));
            f.write(st);
            f.close();
            FileWriter fr = new FileWriter(new File("Most_Compatible_couples.csv"));
            fr.write(sr);
            fr.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
   }
}
