package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvenNumberSetTest {

    EvenNumberSet evenSet;

    @BeforeEach
    void setUp() {
        evenSet = new EvenNumberSet();
    }

    @Test
    void testAdd() {
        evenSet.add(1);
        evenSet.add(2);
        evenSet.add(3);
        evenSet.add(4);
        evenSet.add(5);

        assertEquals(evenSet.size(), 2);
        assert(evenSet.contains(2));
        assertFalse(evenSet.contains(5));

        evenSet.add(2);
        assertEquals(evenSet.size(), 2);
    }

    @Test
    void testAddWithRemove() {
        evenSet.add(2);
        evenSet.add(4);
        evenSet.add(6);

        assertEquals(evenSet.size(), 3);

        evenSet.remove(4);

        assertEquals(evenSet.size(), 2);

        assertFalse(evenSet.contains(4));
    }
}