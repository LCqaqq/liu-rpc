package com.lc.lrpc.example.consumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class ExampleServiceImplTest {
    @Resource
    private ExampleServiceImpl exampleService;

    @Test
    void test(){
        exampleService.test();
    }
}
