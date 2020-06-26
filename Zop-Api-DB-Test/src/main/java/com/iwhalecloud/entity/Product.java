package com.iwhalecloud.entity;

import java.io.Serializable;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Product implements Serializable {
    /*v2的是这个
   "txnNumber":"1234567987",
           "addressId": "20677645",
           "startDate": "2020-03-26",
           "accessMode": "GPON",
           "apptProdList": "HSI_PPPOE:1",
           "csTeamId": "",
           "odbId": " RUH-MURS-SULM-06-4358",
           "provider": "ITC",
           "seeker": "MOBILY"
           */

    /*这个是v3的参数
    "txnNumber":"1234567987",
        "addressId": "20677645",
        "startDate": "2020-03-26",
        "accessMode": "GPON",
        "apptProdList": "HSI_PPPOE:1",
        "csTeamId": "",
        "odbId": " RUH-MURS-SULM-06-4358",
        "provider": "MOBILY",
        "seeker": "ITC"*/

    private String txnNumber;

    private String addressId;

    private String startDate;

    private String accessMode;

    private String apptProdList;

    private String csTeamId;

    private String odbId;

    private String provider;

    private String seeker;


}
