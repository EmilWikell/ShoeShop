package Model;

public class Grade {
    private int id;
    private int value;
    private String keyword;

    public Grade(int id, int value, String keyword) {
        this.id = id;
        this.value = value;
        this.keyword = keyword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
