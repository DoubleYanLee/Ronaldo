package node.common;

//如果不抽象出一个类，后面任意一个DataSource，getNextAtom的时候最后结束数据的流不知道怎么统一传回来
public abstract class DataAtom {
    private static final long serialVersionUID = -7832345233584092879L;
    private long timestamp;


    public DataAtom(long timestamp)
    {
        this.timestamp = timestamp;
    }


    public long getTimestamp()
    {
        return timestamp;
    }

}
