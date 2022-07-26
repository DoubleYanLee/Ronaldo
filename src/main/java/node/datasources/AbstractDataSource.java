package node.datasources;

import node.common.Config;
import node.common.DataAtom;
import node.common.FloatData;

abstract public class AbstractDataSource implements DataSource {

    private static final long serialVersionUID = -7866911933157690908L;
    private int throttle = Config.minSourceThrottle;
    private int id;
    private int clock = 0; //timestamp

    public AbstractDataSource(int id)
    {
        this.id = id;
    }

    public AbstractDataSource(int id, int throttle)
    {
        this(id);
        this.throttle = throttle;
    }


    public int getID()
    {
        return id;
    }

    public int clock()
    {
        return clock;
    }

    public DataAtom nextAtom() {
        // I'm not dealing with time right now
        //easy version

        DataAtom next = getNextAtom();

        return next;
    }

    protected abstract DataAtom getNextAtom();

    public void setUp() {

    }

    public void end() {

    }

    public void restart() {
        end();
        setUp();
    }

    public Class<? extends DataAtom> outputRestriction() {
        return null;
    }
}
