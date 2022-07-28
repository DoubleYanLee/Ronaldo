package node.datasinks;

import node.common.DataAtom;
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

    //id means file write stream id -- consumer.getID()
    public FileDataSink(int id, String path)
    {
        this.id = id;
        this.path = path;
    }

    //不太明白consumer和sink的区别

    public int getID()
    {
        return id;
    }

    public void processAtom(DataAtom atom, int sourceId) {
        try {
            //这里先简单写入，不考虑exactly-one这种高级特性
            //outStream.write(((FloatData) atom).floatValue() + "\n");
            //暂时kafka
            outStream.write(((FloatData) atom).floatValue_kafka() + "\n");
            //这里没有flush，是等consumer端flush吗,可能需要一个类似与execution这样的操作
            //测试的时候魔改一下 加个flush
            outStream.flush(); //add
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

    public boolean inputRestriction(Class<? extends DataAtom> input) {
        return input == FloatData.class;
    }
}
