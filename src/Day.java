public class Day{
    Integer positive;
    Integer recovered;
    Integer death;
    Integer date;
    String state;

    //getters
    public Integer getPositive(){
        return positive;
    }
    public Integer getRecovered(){
        return recovered;
    }
    public Integer getDeath(){
        return death;
    }
    public Integer getDate(){
        return date;
    }
    public String getState(){
        return state;
    }

    //Setters
    public void setPositive(Integer positive){
        this.positive = positive;
    }
    public void setRecovered(Integer recovered){
        this.recovered = recovered;
    }
    public void setDeath(Integer death){
        this.death = death;
    }
    public void setDate(Integer date){
        this.date = date;
    }
    public void setState(String state){
        this.state = state;
    }


    public void checkNull(){
        if(positive == null){
            positive = 0;
        }
        if(recovered == null){
            recovered = 0;
        }
        if(death == null){
            death = 0;
        }
        if(date == null){
            date = 0;
        }
    }
    public String toString(){
        return "Positive: " + positive + " State: " + state;
    }
}