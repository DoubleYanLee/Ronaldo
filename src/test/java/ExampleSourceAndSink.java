import client.consumer.FileConsumerStream;
import node.common.DataAtom;
import node.common.FloatData;
import node.datasinks.DataSink;
import node.datasinks.FileDataSink;
import node.datasources.DataSource;
import node.datasources.KafkaDataSource;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExampleSourceAndSink {

    public static void main(String[] args){

        DataSource kafka_source = new KafkaDataSource(100, "test");
        kafka_source.setUp();

        while(true){
            FloatData kafka_atom = (FloatData)((KafkaDataSource) kafka_source).getNextAtom();
            System.out.println(kafka_atom.floatValue_kafka());
            //因为kafkaDataSource中getNextAtom返回没设置好，导致不输入数据的时候就会产生空行
            //而且还有一个问题，这样下游的filedataSink就需要getNextAtom时分情况讨论了，不太好

            //但是为什么写不进去filesink呢？

            //暂时流id随便写一个，还没有consumer用
            DataSink file_sink =  new FileDataSink(1234,"./test_DAG_new.txt");

            file_sink.setUp();
            file_sink.processAtom(kafka_atom, 1234);
            file_sink.end();
        }

    }

}
