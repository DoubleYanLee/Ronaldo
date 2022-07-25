package node.common;

public class FloatData {
    private static final long serialVersionUID = 3328508760950595947L;
    private double data;
    private long timestamp;


    public FloatData(long timestamp, double value)
    {
        this.timestamp = timestamp;
        data = value;
    }


    public double floatValue()
    {
        return data;
    }



}
