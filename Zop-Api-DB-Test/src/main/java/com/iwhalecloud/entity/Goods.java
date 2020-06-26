package com.iwhalecloud.entity;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Goods implements Serializable {

    private Integer goodsId;

    private String goodsName;

    private List<Subscriber> subList;

    public static void main(String[] args) {
        Object ss = 2332323335454565453L;
        long lo22 = (Long) ss;
        System.out.println(lo22);
    }

}
