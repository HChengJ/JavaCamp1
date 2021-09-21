package io.kimmking.kmq.core;

import io.kimmking.kmq.demo.Order;
import lombok.Data;

import java.util.HashMap;

/**
 * @author Administrator
 */
@Data
public class MyMessage<T> {

    private String id;
    private HashMap<String,T> body;

    public MyMessage(T t) {

    }
}
