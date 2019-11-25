package com.example.demo.util.MeicaiDoUtil;


import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2019-11-07 11:48
 **/
public class test {
    private int i = 0;

    public static void main(String[] args) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("addr"+addr);

    }
}
