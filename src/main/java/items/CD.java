package items;

public class CD extends Item{
    private String artist;

    public CD(String title, Double price, Boolean isBogof, String artist) {
        super(title, price, isBogof);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
