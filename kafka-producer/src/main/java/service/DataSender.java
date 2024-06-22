package service;

import org.apache.kafka.shaded.com.google.protobuf.StringValue;

public interface DataSender {
    void send(model.StringValue value);

    void send(StringValue value);
}