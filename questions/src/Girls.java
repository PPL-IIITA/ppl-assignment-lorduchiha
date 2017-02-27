
public class Girls {
    String name;
    int maintenence_budget;
    int attractiveness_factor;
    int intelligence_factor;
    boolean is_single;
    String type;
    String choice;
    int happiness;
    Boys bf;
    
    Girls(String name,int main_budget,int attr,int iq,String type,String choice,boolean is_single){
        this.name = name;
        maintenence_budget = main_budget;
        attractiveness_factor = attr;
        intelligence_factor = iq;
        this.is_single = is_single;
        this.type = type;
        this.choice = choice;
        bf= null;
    }
    boolean is_match(Girls g, Boys b){
        boolean answer = true;
        if(b.is_single&& g.is_single){
            if(b.budget < g.maintenence_budget){
                answer = false;
            }
            return answer;
        }   
        return false;
    }
}
