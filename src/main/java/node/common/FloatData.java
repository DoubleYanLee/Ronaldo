package node.common;

public class FloatData extends DataAtom{
    private static final long serialVersionUID = 3328508760950595947L;
    private double data;

    public FloatData(long timestamp, double value)
    {
        super(timestamp);
        data = value;
    }


    public double floatValue()
    {
        return data;
    }



}
