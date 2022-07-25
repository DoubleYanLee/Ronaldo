package LikeDataStream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Stream Representation
 * assume all the operations to be window-based (operations on a single item at
 * a time have a window of size 1).
 */

public class Stream implements Serializable {

    private static final long serialVersionUID = -8565637299384034533L;

    protected List<Stream> parents = new ArrayList<Stream>();
    protected List<Stream> children = new ArrayList<Stream>();


    protected Op operation;
    protected int id;
    protected int windowSize;
    protected int windowSlide;
    protected List<String> params = new ArrayList<String>();


    /**
     * assign a unique id (integer)to every new stream.
     */

    private static class StreamEnumerator {
        private static int currID = 0;

        public static int getNewID() {
            int current = currID;
            currID++;
            return current;
        }
    }

    /**
     * initializes the default parameters
     */

    public Stream() {
        this.id = StreamEnumerator.getNewID();
        this.operation = Op.NONE;
        this.windowSize = 1;
        this.windowSlide = 1;
    }



}
