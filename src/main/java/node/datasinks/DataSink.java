package node.datasinks;

import node.common.DataAtom;
import node.common.FloatData;

import java.io.Serializable;

public interface DataSink extends Serializable {

    public void processAtom(DataAtom atom, int sourceId);

    /**
     * Performs initialization procedures (e.g. opening files/urls etc..)
     */
    public void setUp();

    /**
     * Performs actions at the end of the computation
     */
    public void end();

    /**
     * @return True if the specified input class is allowed
     */
    public boolean inputRestriction(Class<? extends DataAtom> input);

}
