package service;

import model.StringValue;

import java.util.List;

public interface StringValueConsumer {

    void accept(List<StringValue> value);
}