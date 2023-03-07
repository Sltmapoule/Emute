import javafx.scene.Node;

public class FilterValues {
    String type;
    int lowFreq;
    int highFreq;
    public FilterValues(String type, int lowFreq, int highFreq) {
        this.type = type;
        this.lowFreq = lowFreq;
        this.highFreq = highFreq;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLowFreq() {
        return lowFreq;
    }

    public void setLowFreq(int lowFreq) {
        this.lowFreq = lowFreq;
    }

    public int getHighFreq() {
        return highFreq;
    }

    public void setHighFreq(int highFreq) {
        this.highFreq = highFreq;
    }
}
