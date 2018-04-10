package Structure.cm2100part3startingpoint;

import java.util.Comparator;

/**
 * CM2100 Coursework Part 3 Starting point
 * @author David
 * An abstract base class to store information about a media item
 */
public abstract class Media implements Comparable<Media>{
    
    private int duration;
    private String title;
    
    private String imageFileName;
    
    private static String imageFileDirectory = "src/resources/";
    
    public Media(String name, int seconds) {
        this.title = name;
        this.duration = seconds;
        this.imageFileName = "No image";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }    
    
    public int getDuration() {
        return duration;
    }

    public void setDuration(int d) {
        this.duration = d;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public static String getImageFileDirectory() {
        return imageFileDirectory;
    }

    public static void setImageFileDirectory(String imageFileDirectory) {
        Media.imageFileDirectory = imageFileDirectory;
    }
     
    @Override
    public String toString() {
        return  this.getTitle() 
                + ", Duration: " + this.getDuration() + "s, " +
                "Cost: " + costInPence() + "p";
    }
    
    public abstract int costInPence();
    
    @Override
    public int compareTo(Media o) {
        return this.getTitle().compareTo(o.getTitle());
    }
    
    public static class DurationComparator implements Comparator<Media>{
        public int compare(Media m1, Media m2) {
           return m2.getDuration() - m1.getDuration();
        }
    }
        
    public static class CostComparator implements Comparator<Media>{
        public int compare(Media m1, Media m2) {
           return m2.costInPence() - m1.costInPence();
        }
    }
}
