package Structure.cm2100part3startingpoint;

/**
 * CM2100 Coursework Part 3 Starting point
 * @author David
 * Class to store information about Music Item, extends Media
 */
public class Music extends Media{
    
    private String artist;
    
    public Music(String songTitle, int seconds, String artist) {
        super(songTitle, seconds);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    @Override
    public int costInPence() {
        if(getDuration()<30) return 0;
        else return 20;
    }

    @Override
    public String toString() {
        return super.toString() 
                + ",  Artist: " + this.getArtist();
    }

}
