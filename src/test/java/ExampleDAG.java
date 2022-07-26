import client.ClientDAG;
import client.Stream;
import client.consumer.FileConsumerStream;
import client.producer.FileProducerStream;
import node.datasinks.FileDataSink;
import node.datasources.FileDataSource;

public class ExampleDAG {

    public static void main(String[] args){

        Stream source = new FileProducerStream("./test_DAG.txt");
        //Stream consumer = new FileConsumerStream("./test_DAG_new.txt", source);
        //ClientDAG compDag = ClientDAG.derive(consumer);
        //System.out.println(compDag.toString());

        FileDataSource fdsource = new FileDataSource(source.getID(), "./test_DAG.txt");

        /*
        To do : 从FileDataSource中读取数据（op=NONE 先不操作）写入FileDataSink
         */

        FileDataSink fdsink = new FileDataSink(fdsource.getID(), "./test_DAG_new.txt");
        fdsink.setUp();
        fdsink.end();

    }

}
