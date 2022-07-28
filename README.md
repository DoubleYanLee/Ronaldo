### Ronaldo

A simple stream processing system for ByteDance's 4th Youth Training Camp.

#### To do list

| 功能 🆔| 评分项                            | 评分权重 | 是否完成 | 何时完成 | 完成核心代码 | 测试代码 | 备注 |
| ---- | ------------------------------------ | -------- | -------- | -------- | ------------ | ------------ | ------------ |
|      | 涉及实现流式API并把计算表达为DAG形式 | 10%      |          |          |              |              |             |
|      | 实现读取Kafka的Source算子         | 2.5%         |    ✅      |  2022-07-28    |  [KafkaDataSource.java](./src/main/java/node/datasources/KafkaDataSource.java)            |    [ExampleSourceAndSink](./src/test/java/ExampleSourceAndSink.java)     |封装没封装好，后面需要优化            |
|      | 实现写入外部文件的Sink算子         | 2.5%         |    🈚️     |   2022-07-25 | [FileDataSink](./src/main/java/node/datasinks/FileDataSink.java) |   [ExampleSourceAndSink](./src/test/java/ExampleSourceAndSink.java)     |   对于client端的consumer和这里的sink有点弄不明白          |

