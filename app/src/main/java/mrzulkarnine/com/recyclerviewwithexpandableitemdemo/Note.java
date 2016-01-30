package mrzulkarnine.com.recyclerviewwithexpandableitemdemo;

/**
 * Created by zul on 31/01/2016.
 */
public class Note {

    public String title;
    public String content;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
