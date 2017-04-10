/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q8;

public class Newgiftingmethod {
    public void calculate(Gifts[] gft,Boys[] b,Girls[] g){
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
                if(gft[j].price > gft[j+1].price){
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
            if(b[i].gf!=null){     
                for(j=0;j<100;j++){
                    if(gft[j].type.equals("LUXURY")&&b[i].l==0){
                        b[i].initgift += gft[j].price;
                        b[i].l=j;
                    }
                    else if(gft[j].type.equals("UTILITY")&&b[i].u==0){
                        b[i].initgift += gft[j].price;
                        b[i].u=j;
                    }
                    else if(gft[j].type.equals("ESSENTIAL")&&b[i].e==0){
                        b[i].initgift += gft[j].price;
                        b[i].e=j;
                    }
                    else if(b[i].l != 0 && b[i].u != 0 && b[i].e != 0){
                        break;
                    }
                }
            }
        }
        for(i=0;i<100;i++){
            int total_cost = 0;
            int amt = 0;
            if(!b[i].status){
                if("MISER".equals(b[i].type)){
                    amt = b[i].gf.maintenance-b[i].initgift;
                    total_cost = 0;
                    if("CHOOSY".equals(b[i].gf.type)){
                        int po = 0;
                        while(total_cost <= amt){ 
                            if("LUXURY".equals(gft[po].type)&&b[i].l!=po){
                                total_cost = total_cost + 2*price[po];
                            }
                            else if(b[i].u != po & b[i].e != po){
                                total_cost = total_cost + price[po];
                            }
                            po++;
                        }
                        b[i].gf.happiness = (int) Math.log((double)total_cost);
                    }
                    else if("NORMAL".equals(b[i].gf.type)){
                        int po = 0;
                        while(total_cost <= amt){
                            if(b[i].l!=po && b[i].u != po && b[i].e != po){
                                total_cost = total_cost + price[po] + gft[po].value;
                                po++;
                            }
                        }
                        b[i].gf.happiness = total_cost;
                    }
                    else if("DESPERATE".equals(b[i].gf.type)){
                        int po = 0;
                        while(total_cost <= amt){
                            if(b[i].l!=po && b[i].u != po && b[i].e != po){
                                total_cost = total_cost + price[po];
                                po++;
                            }
                        }
                        b[i].gf.happiness = (int)Math.exp((double)total_cost);
                    }
                    b[i].spent = total_cost;
                    b[i].happiness = b[i].budget - total_cost;
                }
                else if("GENEROUS".equals(b[i].type)){
                    amt = b[i].budget-b[i].initgift;
                    int po;
                    total_cost = 0;
                    if("CHOOSY".equals(b[i].gf.type)){
                        po=99;
                        while(total_cost <= amt ){
                            if(b[i].l!=po && b[i].u != po && b[i].e != po){
                                total_cost = total_cost + price[po--];
                            }
                        }
                        b[i].gf.happiness = (int) Math.log((double)total_cost);
                    }
                    else if("NORMAL".equals(b[i].gf.type)){
                        po = 99;
                        while(total_cost <= amt){
                            if(b[i].l!=po && b[i].u != po && b[i].e != po){
                                total_cost = total_cost + price[po] + gft[po].value;
                                po--;
                            }
                        }
                        b[i].gf.happiness = total_cost;
                    }
                    else if("DESPERATE".equals(b[i].gf.type)){
                        po = 99;
                        while(total_cost <= amt){
                            if(b[i].l!=po && b[i].u != po && b[i].e != po){
                                total_cost = total_cost + price[po];
                                po--;
                            }
                        }
                        b[i].gf.happiness = (int)Math.exp((double)total_cost);
                    }
                    b[i].spent = total_cost;
                    b[i].happiness = b[i].gf.happiness;
                }
                else if("GEEK".equals(b[i].type)){
                    total_cost = 0;
                    amt = b[i].gf.maintenance-b[i].initgift;
                    int po = 0;
                    while(total_cost <= amt){
                        if(b[i].l!=po && b[i].u != po && b[i].e != po){
                            total_cost = total_cost + price[po++];
                        }
                    }
                    if("CHOOSY".equals(b[i].gf.type)){
                        po = 0;
                        while(total_cost <= amt){
                            if(b[i].l!=po && b[i].u != po && b[i].e != po){
                                total_cost = total_cost + price[po++];
                            }
                        }
                        b[i].gf.happiness = (int) Math.log((double)total_cost);
                    }
                    else if("NORMAL".equals(b[i].gf.type)){
                        po = 0;
                        while(total_cost <= amt){
                            if(b[i].l!=po && b[i].u != po && b[i].e != po){
                                total_cost = total_cost + price[po++];
                            }
                        }
                        
                        b[i].gf.happiness = total_cost;
                    }
                    else if("DESPERATE".equals(b[i].gf.type)){
                        po = 0;
                        while(total_cost <= amt){
                            if(b[i].l!=po && b[i].u != po && b[i].e != po){
                                total_cost = total_cost + price[po++];
                            }
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
