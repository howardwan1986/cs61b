import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void TestequalChars() {
        assertTrue(offByOne.equalChars('a','b'));
        assertTrue(offByOne.equalChars('b','c'));
        assertFalse(offByOne.equalChars('a','c'));
        assertFalse(offByOne.equalChars('A','c'));
        assertFalse(offByOne.equalChars('@','c'));
        assertTrue(offByOne.equalChars('&', '%'));
        assertTrue(offByOne.equalChars('A', 'B'));
        assertTrue(offByOne.equalChars('B', 'A'));
        assertTrue(offByOne.equalChars('A', 'B'));
        assertFalse(offByOne.equalChars('C', 'A'));
        assertFalse(offByOne.equalChars('?', '!'));
        assertFalse(offByOne.equalChars('`', 'A'));
        assertFalse(offByOne.equalChars(' ', '"'));
    }
}
