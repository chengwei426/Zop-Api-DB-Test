package com.iwhalecloud.entity;


import java.io.Serializable;
import lombok.Data;

@Data
public class Subscriber implements Serializable {

    private Integer subId;

    private String subName;


}
