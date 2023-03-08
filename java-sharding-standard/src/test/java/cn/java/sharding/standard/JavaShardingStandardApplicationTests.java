package cn.java.sharding.standard;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaShardingStandardApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("123"+Thread.currentThread().getName()+"---"+Thread.currentThread().getState().name());
        });
        System.out.println(Thread.currentThread().getName()+"---"+Thread.currentThread().getState().name());
        thread.run();
        thread.start();
        Thread.State state = thread.getState();
        String name = state.name();
        System.out.println(thread.getName()+"---"+thread.getState().name());


    }
}
