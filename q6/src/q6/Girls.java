/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q6;



public abstract class Girls {
       String name;
       int attractiveness;
       int maintenance;
       int intelligence;
       String criterion;
       String type;
       boolean status;
       long happiness;
       Boys bf;
       int index;
       boolean break_up;
       boolean is_match(Girls g, Boys b){
        boolean answer = true;
        if(b.status && g.status){
            if(b.budget < g.maintenance){
                answer = false;
            }
            return answer;
        }   
        return false;
    }
}
class choosy extends Girls{
    public choosy(String name, int attractivenss, int maintenance, int intelligence, String criterion,boolean status){
           this.name = name;
           this.attractiveness = attractiveness;
           this.maintenance = maintenance;
           this.intelligence = intelligence;
           this.criterion = criterion;
           this.status = status;
           type = "CHOOSY";
           bf = null;
           this.happiness =0 ;
           this.index = 0;
           this.break_up = false;
    }
}
class normal extends Girls{
    public normal(String name, int attractivenss, int maintenance, int intelligence, String criterion,boolean status){
           this.name = name;
           this.attractiveness = attractiveness;
           this.maintenance = maintenance;
           this.intelligence = intelligence;
           this.criterion = criterion;
           this.status = status;
           type = "NORMAL";
           this.bf = null;
           this.happiness = 0;
           this.index = 0;
           this.break_up = false;
       }
}
class desperate extends Girls{
    public desperate(String name, int attractivenss, int maintenance, int intelligence, String criterion,boolean status){
           this.name = name;
           this.attractiveness = attractiveness;
           this.maintenance = maintenance;
           this.intelligence = intelligence;
           this.criterion = criterion;
           this.status = status;
           type = "DESPERATE";
           this.bf = null;
           this.happiness = 0;
           this.index = 0;
           this.break_up = false;
       }
}