import org.junit.Test;

import static org.junit.Assert.*;

public class ThreadLocalTest {

    @Test
    public void testBasics(){
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("Dog");
        assertEquals("Dog", threadLocal.get());
        threadLocal.remove();
        assertNull(threadLocal.get());
    }

    @Test
    public void testBasics_simplified(){
        String value;
        value = "Dog";
        assertEquals("Dog", value);
        value = null;
        assertNull(value);
    }

    @Test
    public void testTwoThreads() throws InterruptedException {
        final ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("Dog");
        Thread thread = new Thread(() -> threadLocal.set("Cat"));
        thread.start();
        thread.join();
        assertEquals("Dog", threadLocal.get());
    }
}
