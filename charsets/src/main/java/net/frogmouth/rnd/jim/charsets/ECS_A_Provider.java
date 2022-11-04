package net.frogmouth.rnd.jim.charsets;

import java.nio.charset.Charset;
import java.nio.charset.spi.CharsetProvider;
import java.util.HashSet;
import java.util.Iterator;

/** CharsetProvider for the ECS_A charset. */
public class ECS_A_Provider extends CharsetProvider {

    private final ECS_A ecs_a;

    /** Constructor. */
    public ECS_A_Provider() {
        this.ecs_a = new ECS_A();
    }

    @Override
    public Iterator<Charset> charsets() {
        HashSet<Charset> set = new HashSet<>(1);
        set.add(ecs_a);
        return set.iterator();
    }

    @Override
    public Charset charsetForName(String name) {
        if (name.equals(ecs_a.name())) {
            return ecs_a;
        }
        return null;
    }
}
