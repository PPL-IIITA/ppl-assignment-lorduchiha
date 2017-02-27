import java.util.*;
import java.io.*;

public class Utility {
    public void girl_generator() throws FileNotFoundException{
        int i,j;
        String name;
        int attr;
        int maint;
        String[] type = {"choosy" , "normal" , "desperate"};
        String ty;
        String[] choice = {"intelligent","attractive","rich"};
        String ch;
        int iq;
        PrintWriter p = new PrintWriter(new File("GIRL.csv"));
        StringBuilder s = new StringBuilder();
        Random r = new Random();
        
        for(i=1;i<=25;i++){
            name = "GIRL_"+i;
            attr = r.nextInt(10)+1;
            maint = r.nextInt(10000);
            ty = type[r.nextInt(3)];
            iq = r.nextInt(150)+1;
            ch = choice[r.nextInt(3)];
            
            s.append(name);
            s.append(',');
            s.append(iq);
            s.append(',');
            s.append(attr);
            s.append(',');
            s.append(maint);
            s.append(',');
            s.append(ty);
            s.append(',');
            s.append(ch);
            s.append('\n');
        }
        p.write(s.toString());
        p.close();
    }
    
    public void boy_generator() throws FileNotFoundException{
        int i,j;
        String name;
        int attr;
        int budget;
        int iq;
        int min_attr;
        String[] type = {"miser","generous","geek"};
        String ty;
        
        PrintWriter p = new PrintWriter(new File("BOY.csv"));
        StringBuilder s = new StringBuilder();
        Random r = new Random();
        
        for(i=1;i<=50;i++){
            name = "BOY_"+i;
            iq = r.nextInt(150)+1;
            attr = r.nextInt(10)+1;
            min_attr = r.nextInt(9)+1;
            budget = r.nextInt(10000);
            ty = type[r.nextInt(3)];
            
            
            s.append(name);
            s.append(',');
            s.append(iq);
            s.append(',');
            s.append(attr);
            s.append(',');
            s.append(min_attr);
            s.append(',');
            s.append(budget);
            s.append(',');
            s.append(ty);
            s.append('\n');
        }
        
        p.write(s.toString());
        p.close();
        
    }
    
    public void gift_generator() throws FileNotFoundException{
        String[] type= {"essential","utility","luxury"};
        int price;
        int value;
        String ty;
        
        PrintWriter p = new PrintWriter(new File("GIFT.csv"));
        StringBuilder s = new StringBuilder();
        Random r = new Random();
        
        int i;
        for(i=0;i<100;i++){
            ty = type[r.nextInt(3)];
            price = r.nextInt(10000);
            value = r.nextInt(10000);
            
            s.append(ty);
            s.append(',');
            s.append(price);
            s.append(',');
            s.append(value);
            s.append('\n');
        }
        p.write(s.toString());
        p.close();
    }
}
    
