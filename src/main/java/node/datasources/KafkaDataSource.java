package node.datasources;

import node.common.DataAtom;
import node.common.EndData;
import node.common.FloatData;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

public class KafkaDataSource extends AbstractDataSource  {

    private static final long serialVersionUID = 9034901424600021031L;
    private KafkaConsumer<String, String> consumer;
    private ConsumerRecords<String, String> records;
    private String topic; //先支持一个topic，后面改一下数据结构支持多个topic
    private static final String GROUPID = "groupA";


    public KafkaDataSource(int id, String topic) {

        super(id);
        this.topic = topic;
    }

    @Override
    public DataAtom getNextAtom() {

            records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
               // System.out.println("getNextAtom test: " + record.value()); //能消费出来
                return new FloatData(this.clock(), record.value());
            }

        //this.end();
        //return new EndData(this.clock());
        //这里EndData总是无法转换成FloatData类型
        //就先随便返回流一个空流
        return new FloatData(this.clock(), "");
    }

    @Override
    public void setUp()
    {
        try {

            //感觉这里可以封装到client端
            Properties props = new Properties();
            props.put("bootstrap.servers", "127.0.0.1:9092");
            props.put("group.id", GROUPID);
            props.put("enable.auto.commit", "true");
            props.put("auto.commit.interval.ms", "1000");
            props.put("session.timeout.ms", "30000");
            props.put("max.poll.records", 1000);
            props.put("auto.offset.reset", "earliest");
            props.put("key.deserializer", StringDeserializer.class.getName());
            props.put("value.deserializer", StringDeserializer.class.getName());
            consumer = new KafkaConsumer<String, String>(props);
            consumer.subscribe(Arrays.asList(topic));

        } catch (Exception e) {
            // TODO send error to supervisor and block everything
        }
    }


    @Override
    public void end()
    {
        if( records == null && records.count() == 0){
            try {
                consumer.close();
            } catch (Exception e) {
                // TODO send error to supervisor and block everything
                return;
            }
        }
    }


    @Override
    public void restart()
    {
        end();
        setUp();

    }


    @Override
    public Class<? extends DataAtom> outputRestriction()
    {
        return FloatData.class;
    }



}
