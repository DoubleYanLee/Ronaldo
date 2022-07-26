import client.ClientDAG;
import client.Stream;
import client.consumer.FileConsumerStream;
import client.producer.FileProducerStream;

public class ExampleDAG {

    public static void main(String[] args){

        Stream source = new FileProducerStream("./test_DAG.txt");

        Stream consumer = new FileConsumerStream("./test_DAG_new.txt", source);

        ClientDAG compDag = ClientDAG.derive(consumer);

        System.out.println(compDag.toString());

    }

}
