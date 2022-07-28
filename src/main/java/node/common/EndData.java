package node.common;

public class EndData extends DataAtom {

    private static final long serialVersionUID = 751854214266997777L;


    public EndData(long timestamp)
    {
        super(timestamp);
    }

    //写入filesink有误 test
//    private String data;
//    public EndData(long timestamp, String value)
//    {
//        super(timestamp);
//        data = value;
//    }



    public String toString()
    {
        return "End Data";
    }
}
