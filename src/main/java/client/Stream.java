package client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * Stream constructor
     * @param op          Operator to use on the data passing trough the node
     * @param winSize     Size of the window for the operation
     * @param parents     Previous streams from which this one is derived
     */
    public Stream(Op op, int winSize, Stream ...parents) {
        this();
        this.parents = Arrays.asList(parents);
        this.operation = op;
        this.windowSize = winSize;

        for(Stream p : parents) {
            p.addChild(this);
        }

    }

    public void addChild(Stream child) {
        this.children.add(child);
    }

    /**
     * Returns the parent streams
     */
    public List<Stream> getParents() {
        return this.parents;
    }


    public List<Stream> getChildren()
    {
        return this.children;
    }

    /**
     * Returns the current operation's window size
     */
    public int getWindowSize() {
        return this.windowSize;
    }

    /**
     * Returns the current operation window's sliding factor
     */
    public int getWindowSlide() {
        return this.windowSlide;
    }

    /**
     * Returns the operation applied on this stream
     */
    public Op getOperation() {
        return this.operation;
    }



    /**
     * Returns the stream's unique id
     */
    public int getID() {
        return this.id;
    }

    /**
     * Returns the (only) root of the streams dag
     */
    public Stream traceSource() {
        if(this.parents.isEmpty())
            return this;

        return this.parents.get(0).traceSource();
    }


    /**
     * Serializes the stream, in the format
     * (id, op, windowSize, (children), (parents))
     *
     */
    @Override
    public String toString() {
        String id = Integer.toString(getID());
        String op = this.operation.getName();
        String win = Integer.toString(getWindowSize());
        String slide = Integer.toString(getWindowSlide());

        String childrensID = "(" + children.stream()
                .map(child -> Integer.toString(child.getID()))
                .collect(Collectors.joining(",")) + ")";
        String parentsID = "(" + parents.stream()
                .map(parent -> Integer.toString(parent.getID()))
                .collect(Collectors.joining(",")) + ")";

        String paramsString = String.join(";", this.params);

        return new String("(" + String.join(";", id, op, win, slide, paramsString, parentsID, childrensID) + ")");

    }



}
