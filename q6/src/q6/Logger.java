/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;


public class Logger {
    public void boy_generator() throws FileNotFoundException{
        String name="";
        int attractiveness;
        int budget;
        int intelligence;
        int min_attraction;
        int ch;
        String type;
        int i,j,k=0;
        char c;
        Random ran = new Random();
        PrintWriter p = new PrintWriter(new File("BOYS.csv"));
        StringBuilder s = new StringBuilder();
        for(i=0;i<100;i++){
            name = "";
            for(j=0;j<7;j++){
                c = (char)(ran.nextInt(25)+65);
                name = name + c;
            }
            attractiveness = ran.nextInt(100)+1;
            budget = ran.nextInt(500)+500;
            intelligence = ran.nextInt(100)+1;
            min_attraction = ran.nextInt(50)+1;
            ch = ran.nextInt(3);
            switch (ch) {
                case 0:
                    type = "MISER";
                    break;
                case 1:
                    type = "GENEROUS";
                    break;
                default:
                    type = "GEEK";
                    break;
            }
            s.append(name);
            s.append(',');
            s.append(attractiveness);
            s.append(',');
            s.append(budget);
            s.append(',');
            s.append(intelligence);
            s.append(',');
            s.append(min_attraction);
            s.append(',');
            s.append(type);
            s.append('\n');
           
        }
        p.write(s.toString());
        p.close();
    }
    public void girl_generator() throws FileNotFoundException{
        String name;
        int attractiveness;
        int maintenance;
        int intelligence;
        String criterion;
        String type;
        int ch;
        int i,j,k=0;
        char c;
        Random ran = new Random();
        PrintWriter p = new PrintWriter(new File("GIRLS.csv"));
        StringBuilder s = new StringBuilder();
        for(i=0;i<50;i++){
            name="";
            for(j=0;j<7;j++){
                c = (char)(ran.nextInt(25)+65);
                name = name + c;
            }
            attractiveness = ran.nextInt(100)+1;
            maintenance = ran.nextInt(500)+200;
            intelligence = ran.nextInt(100)+1;
            ch = ran.nextInt(3);
            switch (ch) {
                case 0:
                    criterion = "INTELLIGENT";
                    break;
                case 1:
                    criterion = "RICH";
                    break;
                default:
                    criterion = "ATTRACTIVE";
                    break;
            }
            ch = ran.nextInt(3);
            switch (ch) {
                case 0:
                    type = "CHOOSY";
                    break;
                case 1:
                    type = "NORMAL";
                    break;
                default:
                    type = "DESPERATE";
                    break;
            }
            s.append(name);
            s.append(',');
            s.append(attractiveness);
            s.append(',');
            s.append(maintenance);
            s.append(',');
            s.append(intelligence);
            s.append(',');
            s.append(criterion);
            s.append(',');
            s.append(type);
            s.append('\n');
            
        }
        p.write(s.toString());
        p.close();
        
    }
    public void gift_generator() throws FileNotFoundException{
        String[] type= {"ESSENTIAL","UTILITY","LUXURY"};
        int price;
        int value;
        String ty;
        
        PrintWriter p = new PrintWriter(new File("GIFTS.csv"));
        StringBuilder s = new StringBuilder();
        Random r = new Random();
        
        int i;
        for(i=0;i<100;i++){
            ty = type[r.nextInt(3)];
            price = r.nextInt(200);
            value = r.nextInt(100);
            
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
