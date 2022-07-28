package node.common;

public class FloatData extends DataAtom{
    private static final long serialVersionUID = 3328508760950595947L;
    private double data;
    private String kafka_data;
    //private int id; //没有operator时候暂时设置一下

    public FloatData(long timestamp, double value)
    {
        super(timestamp);
        data = value;
    }

    //封装kafka数据
    public FloatData(long timestamp, String value)
    {
        super(timestamp);
        kafka_data = value;

    }

    //for kafka
    public String floatValue_kafka()
    {
        return kafka_data;
    }


    public double floatValue()
    {
        return data;
    }




}
