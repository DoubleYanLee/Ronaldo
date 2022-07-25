package node.datasinks;

import node.common.FloatData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileDataSink implements DataSink {

    private static final long serialVersionUID = 4436385634778545179L;

    private int id;
    private int clock = 0;

    private String path;
    private BufferedWriter outStream;

    public FileDataSink(int id, String path)
    {
        this.id = id;
        this.path = path;
    }


    public int getID()
    {
        return id;
    }


    public void processAtom(FloatData floatdata, int sourceId) {
        try {
            outStream.write(((FloatData) floatdata).floatValue() + "\n");
        } catch (IOException e) {
            // do nothing..
        }
    }

    public void setUp() {
        try {
            //write to file
            this.outStream = new BufferedWriter(new FileWriter(new File(this.path)));
        } catch (IOException e) {
            //TODO send back error to supervisor
        }
    }

    public void end() {
        try {
            this.outStream.close();
        } catch (IOException e) {
            // nothing to do
        }
    }

    public boolean inputRestriction(Class<? extends FloatData> input) {
        return input == FloatData.class;
    }
}
