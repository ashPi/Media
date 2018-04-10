package Structure.cm2100part3startingpoint;

import java.util.ArrayList;

/**
 * CM2100 Coursework Part 3 Starting point
 * Class to store details of a Film item.
 * Film extends Video and Media
 * @author David
 */
public class Film extends Video {
    
    private String director;
    private ArrayList<String> actors;
   
    public Film(String title, int seconds, int age, String director) {
        super(title, seconds, age);
        this.director = director;
        actors = new ArrayList<>();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    public void addActor(String actor){
        actors.add(actor);
    }

    @Override
    public String toString() {
        return super.toString() + ", Director: " + director;
    }
    
    public ArrayList<String> getActors(){
        return actors;
    }
    
    @Override
    public int costInPence(){
        return (getDuration()/60)*2;
    }
}
