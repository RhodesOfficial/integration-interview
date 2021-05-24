package com.calpis.interview.kafka;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/3/20 3:23
 */
public class ProducerInterceptorPrefixPlus implements ProducerInterceptor<String, String> {

    private volatile AtomicLong sendSuccess = new AtomicLong();
    private volatile AtomicLong sendFailure = new AtomicLong();

    /**
     * 发之前调用
     */
    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
        String modifiedValue = "prefix-" + record.value();
        return new ProducerRecord<>(record.topic(), record.partition(), record.timestamp(), record.key(), modifiedValue, record.headers());
    }

    /**
     * 被应答或发送失败时调用
     */
    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        if (Objects.isNull(exception)) {
            sendSuccess.incrementAndGet();
        } else {
            sendFailure.incrementAndGet();
        }
    }

    @Override
    public void close() {
        double successRatio = sendSuccess.doubleValue() / (sendSuccess.doubleValue() + sendFailure.doubleValue());
        System.out.println("[INFO] 发送成功率=" + String.format("%f", successRatio * 100) + "%");
    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
