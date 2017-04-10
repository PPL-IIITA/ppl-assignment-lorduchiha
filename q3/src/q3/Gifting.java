
import java.lang.*;

public class Gifting {
    public void calculate(Gifts gft[],Boys b[],Girls g[]){
        int[] price = new int[100];
        int i,j;
        for(i=0;i<100;i++){
            price[i] = gft[i].price;
        }

        String str;
        int pr;
        int val;
        for(i=0;i<100;i++){
            for(j=0;j<100-i-1;j++){
                if(price[j] > price[j+1]){
                   pr = price[j];
                   price[j] = price[j+1];
                   price[j+1] = pr;
                   
                   gft[j].price = price[j];
                   gft[j+1].price = price[j+1];
                   
                   val = gft[j].value;
                   gft[j].value = gft[j+1].value;
                   gft[j+1].value = val;
                   
                   str = gft[j].type;
                   gft[j].type = gft[j+1].type;
                   gft[j+1].type = str;
                }
            }
        }

        for(i=0;i<100;i++){
            int total_cost = 0;
            int amt = 0;
            if(!b[i].status){
                if("MISER".equals(b[i].type)){
                    amt = b[i].gf.maintenance;
                    if("CHOOSY".equals(b[i].gf.type)){
                        int po = 0;
                        while(total_cost <= amt){ 
                            if("LUXURY".equals(gft[po].type)){
                                total_cost = total_cost + 2*price[po];
                            }
                            else{
                                total_cost = total_cost + price[po];
                            }
                            po++;
                        }
                        b[i].gf.happiness = (int) Math.log((double)total_cost);
                    }
                    else if("NORMAL".equals(b[i].gf.type)){
                        int po = 0;
                        while(total_cost <= amt){
                            total_cost = total_cost + price[po] + gft[po].value;
                            po++;
                        }
                        b[i].gf.happiness = total_cost;
                    }
                    else if("DESPERATE".equals(b[i].gf.type)){
                        int po = 0;
                        while(total_cost <= amt){
                            total_cost = total_cost + price[po];
                            po++;
                        }
                        b[i].gf.happiness = (int)Math.exp((double)total_cost);
                    }
                    b[i].spent = total_cost;
                    b[i].happiness = b[i].budget - total_cost;
                }
                else if("GENEROUS".equals(b[i].type)){
                    amt = b[i].budget;
                    int po;
                    if("CHOOSY".equals(b[i].gf.type)){
                        po=99;
                        while(total_cost <= amt ){
                            total_cost = total_cost + price[po--];
                        }
                        b[i].gf.happiness = (int) Math.log((double)total_cost);
                    }
                    else if("NORMAL".equals(b[i].gf.type)){
                        po = 99;
                        while(total_cost <= amt){
                            total_cost = total_cost + price[po] + gft[po].value;
                            po--;
                        }
                        b[i].gf.happiness = total_cost;
                    }
                    else if("DESPERATE".equals(b[i].gf.type)){
                        po = 99;
                        while(total_cost <= amt){
                            total_cost = total_cost + price[po];
                            po--;
                        }
                        b[i].gf.happiness = (int)Math.exp((double)total_cost);
                    }
                    b[i].spent = total_cost;
                    b[i].happiness = b[i].gf.happiness;
                }
                else if("GEEK".equals(b[i].type)){
                    amt = b[i].gf.maintenance;
                    int po = 0;
                    while(total_cost <= amt){
                        total_cost = total_cost + price[po++];
                    }
                    for(po = 0;po < 100 ;po++){
                        if("LUXURY".equals(gft[po].type)){
                            break;
                        }
                    }
                    int lux_amt = gft[po].price;
                    if((b[i].budget - total_cost) >= lux_amt){
                        total_cost = total_cost + lux_amt;
                    }
                    if("CHOOSY".equals(b[i].gf.type)){
                        po = 0;
                        lux_amt = 0;
                        while(total_cost <= amt){
                            total_cost = total_cost + price[po++];
                        }
                        for(po = 0;po < 100 ;po++){
                            if("LUXURY".equals(gft[po].type)){
                                break;
                            }
                        }
                        lux_amt = gft[po].price;
                        if((b[i].budget - total_cost) >= lux_amt){
                            total_cost = total_cost + lux_amt;
                        }
                        b[i].gf.happiness = (int) Math.log((double)total_cost);
                    }
                    else if("NORMAL".equals(b[i].gf.type)){
                        po = 0;
                        lux_amt = 0;
                        while(total_cost <= amt){
                            total_cost = total_cost + price[po++];
                        }
                        for(po = 0;po < 100 ;po++){
                            if("LUXURY".equals(gft[po].type)){
                                break;
                            }
                        }
                        lux_amt = gft[po].price;
                        if((b[i].budget - total_cost) >= lux_amt){
                            total_cost = total_cost + lux_amt;
                        }
                        b[i].gf.happiness = total_cost;
                    }
                    else if("DESPERATE".equals(b[i].gf.type)){
                        po = 0;
                        lux_amt = 0;
                        while(total_cost <= amt){
                            total_cost = total_cost + price[po++];
                        }
                        for(po = 0;po < 100 ;po++){
                            if("LUXURY".equals(gft[po].type)){
                                break;
                            }
                        }
                        lux_amt = gft[po].price;
                        if((b[i].budget - total_cost) >= lux_amt){
                            total_cost = total_cost + lux_amt;
                        }
                        b[i].gf.happiness = (int)Math.exp((double)total_cost);
                    }
                    b[i].spent = total_cost;
                    b[i].happiness = b[i].gf.intelligence;
                }
                
            }
        }
    }
}
