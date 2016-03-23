package Ad;


public class Content {
    private int id;
    private int len;
    private int value; //value is fixed ?
    private boolean isSeclected =  false;

    public Content(int id, int len, int value) {
        this.id = id;
        this.len = len;
        this.value = value;
    }

    public boolean getIsSeclected () {
        return isSeclected;
    }

    public void setIsSected(boolean b) {
        isSeclected = b;
    }
}
