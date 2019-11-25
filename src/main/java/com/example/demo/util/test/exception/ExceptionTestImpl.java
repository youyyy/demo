package com.example.demo.util.test.exception;

/**
 * @Description
 * @Author youyi
 * @Date 2019/9/9 下午1:20
 **/
public class ExceptionTestImpl implements ExceptionTest {

    @Override
    public void throwException() throws Exception {
        throw new Exception("test");
    }
}
