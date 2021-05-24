package com.calpis.interview.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.errors.ProducerFencedException;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/15 23:18
 */
public class ProducerBootstrap {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092,127.0.0.1:9093,127.0.0.1:9094,127.0.0.1:9095");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, ProducerInterceptorPrefix.class.getName() + "," + ProducerInterceptorPrefixPlus.class.getName());
        props.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, "txid");
        Producer<String, String> producer = new KafkaProducer<>(props);
        producer.initTransactions();
        while (true) {
            try {
                // main线程 将消息添加到RecordAccumulator中的ProducerBatch缓存消息
                // sender线程 批量发送消息,发送前保存到InFlightRequest
                producer.beginTransaction();
                producer.send(new ProducerRecord<>("newTopic", "hello"));
                producer.send(new ProducerRecord<>("newTopic", "hello"));
                producer.send(new ProducerRecord<>("newTopic", "hello"));
                producer.commitTransaction();
                TimeUnit.SECONDS.sleep(1);
            } catch (ProducerFencedException e) {
                producer.abortTransaction();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
