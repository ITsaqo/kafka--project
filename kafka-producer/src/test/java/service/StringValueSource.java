package service;

import model.StringValue;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class StringValueSource implements ValueSource {
    private static final Logger log = LoggerFactory.getLogger(StringValueSource.class);
    private final AtomicLong nextValue = new AtomicLong(1);
    private final DataSender valueConsumer;

    public StringValueSource(DataSender dataSender) {
        this.valueConsumer = dataSender;
    }

    public void generate() {
        var executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() -> valueConsumer.send(makeValue()), 0, 1, TimeUnit.SECONDS);
        log.info("generation started");
    }

    private StringValue makeValue() {
        var id = nextValue.getAndIncrement();
        return new StringValue(id, "stVal:" + id);
    }

    @Override
    public short[] shorts() {
        return new short[0];
    }

    @Override
    public byte[] bytes() {
        return new byte[0];
    }

    @Override
    public int[] ints() {
        return new int[0];
    }

    @Override
    public long[] longs() {
        return new long[0];
    }

    @Override
    public float[] floats() {
        return new float[0];
    }

    @Override
    public double[] doubles() {
        return new double[0];
    }

    @Override
    public char[] chars() {
        return new char[0];
    }

    @Override
    public boolean[] booleans() {
        return new boolean[0];
    }

    @Override
    public String[] strings() {
        return new String[0];
    }

    @Override
    public Class<?>[] classes() {
        return new Class[0];
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
