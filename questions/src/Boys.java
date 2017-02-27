
public class Boys {
    String name;
    int budget;
    int intelligence_factor;
    int attraction_factor;
    int min_attraction_of_girls;
    boolean is_single;
    String type;
    int happiness;
    int spent;
    Girls gf;
        
    Boys(String name,int budget,int iq,int attr_factor,int min_attr_factor,String type,boolean is_single){
        this.name = name;
        this.budget = budget;
        this.intelligence_factor = iq;
        attraction_factor = attr_factor;
        min_attraction_of_girls = min_attr_factor;
        this.type = type;
        this.is_single = is_single;
        gf = null;
    }
    boolean is_match(Girls g,Boys b){
        boolean answer = true;
        if(g.is_single&& b.is_single){
            if(g.attractiveness_factor > b.min_attraction_of_girls){
                answer = false;
            }
            if(g.maintenence_budget > b.budget){
                answer = false;
            }
            return answer;
        }
        return false;
    }
}
