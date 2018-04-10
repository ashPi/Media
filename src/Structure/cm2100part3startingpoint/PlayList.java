package Structure.cm2100part3startingpoint;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* CM2100 Coursework Part 3 Starting point
 * Class to store details of a PlayList.
 * Users User and Media classes
 * @author David 
*/

public class PlayList {
    private ArrayList<Media> items;
    private int currentItemNumber;
    private User user;
    
    public PlayList(User user) {      
        this.user = user;
        this.items = new ArrayList<>();
        this.currentItemNumber = 0;
    }
    
    public PlayList() {      
        this.user = new User("Intro Account", 1000);
        this.items = new ArrayList<>();
        freebieMedia();   
        this.currentItemNumber = 0;
    }
    
    private void freebieMedia(){
        items.add(new Series("Game of Thrones",3000,18,29,"The Rains of Castamere"));
        items.add(new Music("Losing my religion", 200, "REM"));
        items.add(new Film("The Last Jedi", 9120, 12, "Rian Johnson"));
    }

    public User getUser(){
        return user;
    }
    
    public int getNumItems() {
        return items.size();
    }
    
    public ArrayList<Media> getItems() {
        return items;
    }
    
    public Media getMedia(int i) {
        return items.get(i);
    }
    
    public void addMedia(Media m){
        if(user.purchase(m)) items.add(m);
    }
      
    public String getScheduleAsString(){
        String rs = "";
        for(Media m: items){
            rs += m.toString() + "\n";
        }
        return rs;
    }
    
    public int getTotalDuration(){
        int time = 0;
        for(Media m: items){
            time += m.getDuration();
        }
        return time;
    }
    
    public int getTotalCost(){
        int cost = 0;
        for(Media m: items){
            cost += m.costInPence();
        }
        return cost;
    }
    
    @Override
    public String toString() {
        String str = "Number of Items:"  + this.getNumItems() + "\t"
                + "Time: " + getTotalDuration() + "\n"
                + getScheduleAsString();
 
        return str; 
    }
    
    public void sortItemsByTitle(){
        Collections.sort(items);
    }
        
    public void readFromFile(File f){
        try {
            Scanner s = new Scanner(f);
            s.useDelimiter(",|\n");   
            // For each Item
            while (s.hasNextLine()){
                
                // Read description and runtime and type
                String line = s.nextLine();
                //System.out.println(line);
                String[] parts = line.split(",");
                String type = parts[0];
                String title = parts[1];
                int duration = Integer.parseInt(parts[2]);
                // content then depends on type
                    if (type.equals("Music")){
                        String artist = parts[3];                       
                        Music item = new Music(title,duration,artist);
                        this.addMedia(item);
                    } else if (type.equals("Film")){
                        int age = Integer.parseInt(parts[3]);
                        String director = parts[4];                       
                        Film item = new Film(title,duration,age,director);
                        this.addMedia(item);
                    } else if (type.equals("Series")){
                        int age = Integer.parseInt(parts[3]);
                        int episode = Integer.parseInt(parts[4]);
                        String episodeTitle = parts[5];                       
                        Series item = new Series(title,duration,age,episode,episodeTitle);
                        this.addMedia(item);
                    } 
            }
            s.close();
        } catch (FileNotFoundException ex) {}
        
    }
    
    public void sortItemsByDuration(){
        items.sort(new Media.DurationComparator());
    } 
    
    public void sortItemsByCost(){
        items.sort(new Media.CostComparator());
    }
    
    /* The remaining methods are added for Part 3 compared to Part 2 
     * Be sure to check the available methods before implementing any new 
     * methods in PlayList yourself*/ 
    
/* A method to add a media item without chargeing user's wallet */    
    public void addFreeMedia(Media m){
        items.add(m);
    }
    
 /* A method to remove a media item from the playlist */    
    public void removeMedia(int i) {
        items.remove(i);
    }

 /* A method to moveMedia position of item in playlist
    * Media item moves from index j to index i if i<j, else no change
    public void moveMedia(int i, int j) {
        if(i<j && i>=0 && i<items.size() && j<items.size()){
            Media temp = items.remove(j);
            items.add(i,temp);          
        }
    }
 */
     /* A method to save media list in file specified by parameter */ 
    public void saveToFile(File f){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            for (Media m: items){
                String line = "";
                if (m instanceof Music){
                    line += "Music," + m.getTitle() +"," 
                            + m.getDuration() + "," + ((Music) m).getArtist();
                } else if (m instanceof Film){
                    line += "Film," + m.getTitle() +"," 
                            + m.getDuration() + "," 
                            + ((Film) m).getAgeRestriction() + ","
                            + ((Film) m).getDirector();
                } else if (m instanceof Series){
                    line += "Series," + m.getTitle() +"," 
                            + m.getDuration() + "," 
                            + ((Series) m).getAgeRestriction() + ","
                            + ((Series) m).getEpisode() + ","
                            + ((Series) m).getEpisodeTitle();
                } 
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (Exception ex) {}

    }
    
    
    //-------------------------------------Additional or Modified Methods-------------------------------------
    
    /*Modified version of the moveMedia method
     Moves a media item from index i to index j
     Does not matter which index is bigger,
     i.e. media can be moved in any direction
     returns true if the action was successful
     */
    public boolean moveMedia(int i, int j) {
        boolean flag = true;
        if(i<items.size() && j<items.size() && i != j && i >= 0 && j >= 0) {
            Media temp = items.get(i);
            items.set(i, items.get(j));
            items.set(j, temp);
        }
        else {
            flag = false;
        }
        return flag;
    } 
}
