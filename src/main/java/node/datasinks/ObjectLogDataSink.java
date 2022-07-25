package node.datasinks;

import node.common.FloatData;

/**
 *  default log datasink
 */

public class ObjectLogDataSink implements DataSink{

    private static final long serialVersionUID = 8823023649552312928L;
    private int id;

    public ObjectLogDataSink(int id)
    {
        this.id = id;
    }

    public int getID()
    {
        return id;
    }

    public void processAtom(FloatData floatdata, int sourceId) {

        //write log

    }

    public void setUp() {

    }

    public void end() {

    }

    public boolean inputRestriction(Class<? extends FloatData> input) {
        return true;
    }
}
