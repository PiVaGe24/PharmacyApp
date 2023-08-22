package View.swing.search;

public class DataSearch {

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public boolean isStory() {
        return story;
    }

    public void setStory(boolean story) {
        this.story = story;
    }

    public DataSearch(int id, String text, boolean story) {
        this.id = id;
        this.text = text;
        this.story = story;
    }

    public DataSearch() {
    }

    private String text;
    private boolean story;
    private int id;
}
