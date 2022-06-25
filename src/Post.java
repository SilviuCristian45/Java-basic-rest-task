
public class Post
{
    private int id;
    private String title;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Postarea ( cu id : " + this.id + ", si title : '" + this.title + "')";
    }
}
