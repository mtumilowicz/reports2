package core.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by mtumilowicz on 2017-08-19.
 */
public class GenericBuilder<T> {

    private final Supplier<T> instance;

    private List<Consumer<T>> instanceModifiers = new ArrayList<>();

    public GenericBuilder(Supplier<T> instance) {
        this.instance = instance;
    }

    public static <T> GenericBuilder<T> of(Supplier<T> instance) {
        return new GenericBuilder<>(instance);
    }

    public <U> GenericBuilder<T> with(BiConsumer<T, U> consumer, U value) {
        Consumer<T> c = instance -> consumer.accept(instance, value);
        instanceModifiers.add(c);
        return this;
    }

    public T build() {
        T value = instance.get();
        instanceModifiers.forEach(modifier -> modifier.accept(value));
        instanceModifiers.clear();
        return value;
    }
}
