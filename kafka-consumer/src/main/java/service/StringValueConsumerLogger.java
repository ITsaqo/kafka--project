package service;

import model.StringValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import repository.StringValueRepository;

import java.util.List;

@Service
public class StringValueConsumerLogger implements StringValueConsumer{

    private final StringValueRepository stringValueRepository;

    public StringValueConsumerLogger(StringValueRepository stringValueRepository) {
        this.stringValueRepository = stringValueRepository;
    }

    private static final Logger log = LoggerFactory.getLogger(StringValueConsumerLogger.class);

    @Override
    public void accept(List<StringValue> values) {
        for(var value: values){
            log.info("log: {}", value);
            StringValueEntity stringValueEntity = convert(value);
            stringValueRepository.save(stringValueEntity);
        }
    }

    private StringValueEntity convert(StringValue stringValue){
        StringValueEntity stringValueEntity = new StringValueEntity();
        stringValueEntity.setValue(stringValue.value());
        return stringValueEntity;
    }
}
