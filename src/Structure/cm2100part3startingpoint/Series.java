 package Structure.cm2100part3startingpoint;

/**
 * CM2100 Coursework Part 3 Starting point
 * Class to store details of a Series episode item.
 * Film extends Video and Media
 * @author David
 */
public class Series extends Video{
    
    private int episode;
    private String episodeTitle;

    public Series(String title, int seconds, int age, int episode, String episodeTitle) {
        super(title, seconds, age);
        this.episode = episode;
        this.episodeTitle = episodeTitle;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public String getEpisodeTitle() {
        return episodeTitle;
    }

    public void setEpisodeTitle(String episodeTitle) {
        this.episodeTitle = episodeTitle;
    }

    @Override
    public String toString() {
        String str = super.toString() 
                + ", Episode: " + this.getEpisode()
                + ", Episode title: " + this.getEpisodeTitle();
        return str;
    }
    
    @Override
    public int costInPence(){
        if(this.getAgeRestriction()<12) return 20;
        else return 50;
    }
       
}
