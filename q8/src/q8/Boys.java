/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public abstract class Boys {
    String name;
    int attractiveness;
    int budget;
    int intelligence;
    int min_attraction;
    String type;
    boolean status;
    int happiness;
    int spent;
    Girls gf;
    int initgift;
    int l,u,e;
    boolean is_match(Girls g, Boys b){
        boolean answer = true;
        if(g.status && b.status){
            if(g.attractiveness > b.min_attraction){
                answer = false;
            }
            if(g.maintenance > b.budget){
                answer = false;
            }
            return answer;
        }   
        return false;
    }
}
class Miser extends Boys{
    
    public Miser(String name, int attractiveness, int budget, int intelligence, int min_attraction, boolean status) {
        this.name = name;
        this.attractiveness = attractiveness;
        this.budget = budget;
        this.intelligence = intelligence;
        this.min_attraction = min_attraction;
        this.status = status;
        this.gf = null;
        type = "MISER";
        gf = null;
        l=0;
        u=0;
        e=0;
        initgift = 0;
    }
}
class generous extends Boys{
     public generous(String name, int attractiveness, int budget, int intelligence, int min_attraction, boolean status) {
        this.name = name;
        this.attractiveness = attractiveness;
        this.budget = budget;
        this.intelligence = intelligence;
        this.min_attraction = min_attraction;
        this.status = status;
        this.gf = null;
        type = "GENEROUS";
        gf = null;
        l=0;
        u=0;
        e=0;
        initgift = 0;
    }
}
class geek extends Boys{
     public geek(String name, int attractiveness, int budget, int intelligence, int min_attraction, boolean status) {
        this.name = name;
        this.attractiveness = attractiveness;
        this.budget = budget;
        this.intelligence = intelligence;
        this.min_attraction = min_attraction;
        this.status = status;
        this.gf = null;
        type = "GEEK";
        gf = null;
        l=0;
        u=0;
        e=0;
        initgift = 0;
    }
}
