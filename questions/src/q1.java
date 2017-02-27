import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;


public class q1{
    public static void main(String args[]) throws FileNotFoundException, IOException{
        Utility u = new Utility();
        u.girl_generator();
        u.boy_generator();
        
        
        
        //filling details for boys;
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
            //System.out.println(b_name+" "+b_budget+" "+b_iq+" "+b_attr+" "+b_min_attr);
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
            //System.out.println(g_name+" "+g_maint+" "+g_iq+" "+g_attr);
            g[j++] = new Girls(g_name,g_maint,g_attr,g_iq,g_type,g_choice,true);
        }
        String st="";
        String sigst="";
        int p=0,q=0;

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
        
        for(p=0;p<50;p++){
            String ss1 = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
            String ss2=new SimpleDateFormat("hh:mm:ss").format(new Date());
            if(b[p].is_single){
                sigst = sigst + b[p].name + "------>is Single||||"+"\n";
            }
            else
                st = st + b[p].name + " --- >>> is commited to --- >>>" + b[p].gf.name+" on "+ss1+" at "+ss2+"\n";
                
        }
       
        for(p=0;p<25;p++){
            if(g[p].is_single){
                sigst = sigst + g[p].name + "------>is single||||"+"\n";
            }
        }
       
        try{
            FileWriter wr = new FileWriter(new File("Couples.csv"));
            wr.write(st);
            wr.write(sigst);
            wr.close();
        }
        catch(Exception ex){
                ex.printStackTrace();
        }
    }
}

