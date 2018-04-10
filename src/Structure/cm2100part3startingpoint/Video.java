package Structure.cm2100part3startingpoint;


/**
 * CM2100 Coursework Part 3 Starting point
 * Abstract Class to store details of Video-based media, extends Media
 * @author David
 */
public abstract class Video extends Media{
    private int ageRestriction;

    public Video(String title, int seconds, int age) {
        super(title, seconds);
        this.ageRestriction = age;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(int age) {
        this.ageRestriction = age;
    }
    
    
    @Override
    public String toString() {
        return super.toString() 
                + ", Age Restriction: " + ageRestriction ;
    }
    
}
