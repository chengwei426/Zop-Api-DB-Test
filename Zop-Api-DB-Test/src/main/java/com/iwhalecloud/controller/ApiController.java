package com.iwhalecloud.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.iwhalecloud.common.ResponseData;
import com.iwhalecloud.entity.ApiPerformanceTesting;
import com.iwhalecloud.entity.CardInfo;
import com.iwhalecloud.entity.Goods;
import com.iwhalecloud.entity.MyKidInfo;
import com.iwhalecloud.entity.Order;
import com.iwhalecloud.entity.Product;
import com.iwhalecloud.entity.ReportApiDcoos;
import com.iwhalecloud.entity.User;
import com.iwhalecloud.service.UserService;
import com.iwhalecloud.utils.JacksonUtils;

@RestController
public class ApiController {

    private final static String YES_FLAG = "Y";

    @Value("${3pp.card.detail}")
    private String threePPCardDetail;

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public ResponseData getUser(@RequestParam("userId") @NotNull(message = "用户id不能为空") Long userId) {
        return new ResponseData<User>("200", "success");
    }

    // http://127.0.0.1:9090/void
    @RequestMapping(value = "/void")
    public void voidReq() {
        System.out.println("===================================");
        System.out.println("===================================");
        System.out.println("===================================");
        System.out.println("===================================");
        System.out.println("===================================");
        System.out.println("===================================");
        System.out.println("===================================");
    }

    // http://127.0.0.1:9090/index
    @RequestMapping(value = "/index")
    public ResponseData index() throws InterruptedException {
        ResponseData responseData = new ResponseData();
        responseData.setResCode("0000");
        responseData.setResMessage("zop api test success");
        ApiPerformanceTesting apiPerformanceTesting = userService.fetchApiPerformanceTestingByCode(null);
        if (apiPerformanceTesting != null) {
            String ifSleep = apiPerformanceTesting.getIfSleep();
            if (YES_FLAG.equals(ifSleep)) {
                if (apiPerformanceTesting.getSleepTime() != null) {
                    long sleepTime = (long) apiPerformanceTesting.getSleepTime();
                    Thread.sleep(sleepTime);
                }
            }

            String ifUseResponse = apiPerformanceTesting.getIfUseResponse();
            if (YES_FLAG.equals(ifUseResponse)) {
                String responseBody = apiPerformanceTesting.getResponseBody();
                if (!StringUtils.isEmpty(responseBody)) {
                    responseData.setData(responseBody);
                    return responseData;
                }
            }
        }

        List<String> list = new ArrayList<String>(4);
        list.add("武汉");
        list.add("安庆");
        list.add("南京");
        responseData.setData(list);
        return responseData;
    }

    @RequestMapping(value = "/indexApi")
    public ResponseData indexApi() {
        ResponseData responseData = new ResponseData();
        responseData.setResCode("0000");
        responseData.setResMessage("zop api test success");
        User user = new User(11, "zhangsan ");
        responseData.setData(user);
        return responseData;
    }

    // http://127.0.0.1:9090/apiTest
    @RequestMapping(value = "/apiTest")
    public ResponseData apiTest(@RequestBody Order order) {
        ResponseData responseData = new ResponseData();
        responseData.setResCode("0000");
        responseData.setResMessage("zop api success");
        Map<String, String> map = new HashMap<String, String>(4);
        map.put("ASA_Name", order.getUserName());
        map.put("ASA_Id", "11");
        responseData.setData(map);
        return responseData;
    }

    @RequestMapping(value = "/apiOrder")
    public ResponseData apiTest(@RequestBody User user) throws InterruptedException {
        ResponseData responseData = new ResponseData();
        responseData.setResCode("200");
        responseData.setResMessage("apiOrder success");

        ApiPerformanceTesting apiPerformanceTesting = userService.fetchApiPerformanceTestingByCode(user.getTestCode());
        if (apiPerformanceTesting != null) {
            String ifSleep = apiPerformanceTesting.getIfSleep();
            if (YES_FLAG.equals(ifSleep)) {
                if (apiPerformanceTesting.getSleepTime() != null) {
                    long sleepTime = (long) apiPerformanceTesting.getSleepTime();
                    Thread.sleep(sleepTime);
                }
            }

            String ifUseResponse = apiPerformanceTesting.getIfUseResponse();
            if (YES_FLAG.equals(ifUseResponse)) {
                String responseBody = apiPerformanceTesting.getResponseBody();
                if (!StringUtils.isBlank(responseBody)) {
                    responseData.setData(responseBody);
                    return responseData;
                }
            }
        }

        Order order = new Order(user.getUserId(), "静静的顿河", new Date());
        order.setUserName(user.getUserName());
        responseData.setData(order);
        return responseData;
    }


    @RequestMapping(value = "/getApiPerformanceTestingByCode")
    public ResponseData getApiPerformanceTestingByCode() {
        ResponseData responseData = new ResponseData();
        responseData.setResCode("200");
        responseData.setResMessage("operator success");

        ApiPerformanceTesting apiPerformanceTesting = userService.fetchApiPerformanceTestingByCode(null);

        responseData.setData(apiPerformanceTesting);
        return responseData;
    }

    @RequestMapping(value = "/modifyApiPerformanceTesting")
    public ResponseData modifyApiPerformanceTesting(@RequestBody ApiPerformanceTesting apiPerformanceTesting) {
        ResponseData responseData = new ResponseData();
        responseData.setResCode("200");
        responseData.setResMessage("operator success");

        userService.modifyApiPerformanceTesting(apiPerformanceTesting);

        return responseData;
    }


    @RequestMapping(value = "/query/v2", method = RequestMethod.POST)
    public ResponseData queryV2(@RequestBody Product product) {
        ResponseData responseData = new ResponseData();
        responseData.setResCode("200");
        responseData.setResMessage("operator success");

        String provider = StringUtils.isEmpty(product.getProvider()) ? "MOBILY" : product.getProvider();
        responseData.setData(provider);
        return responseData;
    }


    /*{
        "access_token": "Zjg0Y2M3NTMwMzFjODRlZjM0YTVmZWVhYzIyMjc4ODg=",
            "method": "Exclusive_Flow",
            "version": "V1.0",
            "content": {"txnNumber":"1234567987",
            "addressId": "20677645",
            "startDate": "2020-03-26",
            "accessMode": "GPON",
            "apptProdList": "HSI_PPPOE:1",
            "csTeamId": "",
            "odbId": " RUH-MURS-SULM-06-4358",
            "provider": "ITC",
            "seeker": "MOBILY"}
    }*/
    @RequestMapping(value = "/query/v3", method = RequestMethod.POST)
    public ResponseData queryV3(@RequestBody Product product) {
        ResponseData responseData = new ResponseData();
        responseData.setResCode("200");
        responseData.setResMessage("response success");

        String provider = StringUtils.isEmpty(product.getProvider()) ? "ITC" : product.getProvider();
        responseData.setData(provider);
        return responseData;
    }

    // http://127.0.0.1:9090/dealGet/${custOrderNo}/${txnNumber}
    @RequestMapping(value = "/dealGet/{custOrderNo}/{txnNumber}", method = RequestMethod.GET)
    public ResponseData dealGet(@PathVariable("custOrderNo") String custOrderNo, @PathVariable("txnNumber") String txnNumber) {
        ResponseData responseData = new ResponseData();
        responseData.setResCode("200");
        responseData.setResMessage("response success");
        HashMap<String, String> map = new HashMap<>(4);
        map.put("custOrderNo", custOrderNo);
        map.put("txnNumber", txnNumber);
        responseData.setData(map);
        return responseData;

    }

    // http://127.0.0.1:9090/listTest
    @RequestMapping(value = "/listTest", method = RequestMethod.POST)
    public ResponseData listTest(@RequestBody Goods goods) {
        ResponseData responseData = new ResponseData();
        responseData.setResCode("00000");
        responseData.setResMessage("response success");
        HashMap<String, Object> map = new HashMap<>(4);
        map.put("subList", goods.getSubList());
        map.put("dealResult", "Successful transaction");

        return responseData;
    }

    /*{
        "access_token": "ZjA4Mzg5NjYwNGIyYTM3Y2UzNDNjNzMyMDQzYzM2MTY=",
            "method": "cheng_standard_header",
            "version": "1.0",
            "content": {}
    }*/
    // http://127.0.0.1:9090/header
    @RequestMapping(value = "/header")
    public ResponseData header(HttpServletRequest request) {
        ResponseData responseData = new ResponseData();
        responseData.setResCode("00000");
        responseData.setResMessage("response success");
        HashMap<String, Object> map = new HashMap<>(4);
        map.put("X-Forwarded-Proto", request.getHeader("X-Forwarded-Proto"));
        map.put("Content-Type", request.getHeader("Content-Type"));
        map.put("CLINET-CODE", request.getHeader("CLINET-CODE"));
        map.put("api_key", request.getHeader("api_key"));
        map.put("channlId", request.getHeader("channlId"));
        responseData.setData(map);
        return responseData;
    }

    /**
     * 捕捉全局异常之后不需要BindingResult result
     *
     * @param reportApiDcoos
     * @return
     */
    @RequestMapping(value = "/dcoos/report", method = RequestMethod.POST, produces = "application/json")
    public Map<String, String> dcoosReport(@RequestBody @Validated ReportApiDcoos reportApiDcoos) {
        System.out.println("reportApiDcoos == " + reportApiDcoos);
        long apiId = System.currentTimeMillis();
        Map<String, String> map = new HashMap<>(10);
        map.putIfAbsent("api_id", apiId + "");
        ApiPerformanceTesting apiPerformanceTesting = new ApiPerformanceTesting();
        String json = JSON.toJSONString(reportApiDcoos);
        apiPerformanceTesting.setResponseBody(json);

        apiPerformanceTesting.setApiId(apiId + "");
        userService.addApiPerformanceTesting(apiPerformanceTesting);
        return map;
    }

    // http://127.0.0.1:9090/getParam?txnNumber=11&provider=fdsvf
    @RequestMapping(value = "/getParam", method = RequestMethod.GET)
    public ResponseData header(@PathParam("txnNumber") String txnNumber, @PathParam("provider") String provider) {
        ResponseData responseData = new ResponseData();
        responseData.setResCode("00000");
        responseData.setResMessage("response success");
        HashMap<String, Object> map = new HashMap<>(4);
        map.put("txnNumber", txnNumber);
        map.put("provider", provider);
        responseData.setData(map);
        return responseData;
    }


    /**
     * Return ID card detail
     *
     * @return
     */
    // http://127.0.0.1:9090/malaysia/eid
    @RequestMapping(value = "/malaysia/eid", method = RequestMethod.GET)
    public String queryCardDetail() throws JsonProcessingException {
        if (StringUtils.isBlank(threePPCardDetail)) {
            CardInfo cardInfo = new CardInfo(
                    "smart reader name",
                    "Get string of last error message.",
                    1,
                    "tMyKid",
                    true,
                    "Not_Required",
                    "3",
                    "L1",
                    "R1",
                    "Length = 150 alphanumeric characters",
                    "Get the GMPC name of the card holder (full name printed on card surface)",
                    "Get the KPT short name of the card holder. ",
                    "Get the New ID Number of the card holder.",
                    "Get the Old ID Number of the card holder prior 1990",
                    "Get the other ID Number when card type is MyTentera or MyPolice",
                    "L",
                    "DD/MM/YYYY",
                    "Get the place of birth of the cardholder.",
                    "DD/MM/YYYY",
                    "WARGANEGARA",
                    "Get the race of the cardholder. Length = 25 alphanumeric characters. For citizen, it will indicate the race such as MELAYU, KADAZAN, BIDAYU, CINA, INDIA, and etc. ",
                    "Get the religion of the cardholder. Eg. ISLAM, BUDDHA, KRISTIAN, HINDU, and etc",
                    "Get the 1st line of address.",
                    "Get the 2nd line of address.",
                    "Get the 3rd line of address.",
                    98643,
                    "Get the city description of the address. ",
                    "Get the state description of the address",
                    "K",
                    "RJ",
                    "KT",
                    "DD/MM/YYYY",
                    "Get the nationality of the card holder if card type = MyKAS.",
                    "Get the nationality code and foreign Identity Number of the card holder if card type = MyPR",
                    ""
            );

            String cardInfoJson = JacksonUtils.obj2json(cardInfo);
            MyKidInfo myKidInfo = new MyKidInfo(
                    "Get MyKid birth certificate number of new born. ",
                    "DD/MM/YYYY ",
                    "Get the name of JPN branch where birth was registered.",
                    "Get MyKid identity card number assigned to the new born upon birth registration. This number will be same as Mykad’s NRIC.",
                    "Get the child full name as printed on the MyKid.",
                    "L",
                    "DD/MM/YYYY",
                    "HH:MM:SS",
                    "Get the 1st line of registration of birth.",
                    "Get the 2nd line of registration of birth – if any.",
                    "WARGANEGARA",
                    "Get the birth date where child was born. ",
                    "Get the 1st line of current address. ",
                    "Get the 2nd line of current address.",
                    "Get the 3rd line of current address. ",
                    "Get the postcode of the current address. ",
                    "Get the city description of the current address.",
                    "Get the city description of the current address.",
                    "Get the child new full name as printed on the MyKid – if any. ",
                    "Get the postcode of the new current address – if any.",
                    "Get the city description of the new current address – if any. ",
                    "Get the state description of the new current address – if any.",
                    "Get the original father’s name of the child.",
                    "Get the father’s Identity number.",
                    "Get the father’s other document number. Eg. Passport No. or other IDCard No.",
                    "Get the father’s other document type description. Eg. Passport or IDCard. ",
                    "Get the father age during date of given birth.",
                    "WARGANEGARA ",
                    "Get the father’s race of origin.eg. CANTONESE, BUGIS, AUSTRALIA, UNITED STATES, and etc.",
                    "Get the father’s religion. eg. ISLAM, KRISTIAN, BUDDHA, HINDU, and etc.",
                    "Get the original mother’s name of the child.",
                    "Get the mother’s Identity number. ",
                    "Get the mother’s other document number. Eg. Passport No. or other IDCard No.",
                    "Get the mother’s other document type description. Eg. Passport or IDCard.",
                    "Get the mother age during date of given birth.",
                    "WARGANEGARA",
                    "Get the mother’s race of origin.eg. CANTONESE, BUGIS, AUSTRALIA, UNITED STATES, and etc.",
                    "Get the mother’s religion. eg. ISLAM, KRISTIAN, BUDDHA, HINDU, and etc."
            );

            String myKidInfoJson = JacksonUtils.obj2json(myKidInfo);

            return cardInfoJson;
        } else {
            if ("0".equals(threePPCardDetail)) {
                // {"error": 0, "error": "Failed to verify fingers", "message": "Failed to verify fingers"}
                threePPCardDetail = "{\"error\": 0, \"error\": \"Failed to verify fingers\", \"message\": \"Failed to verify fingers\"}";
            } else if ("-1".equals(threePPCardDetail)) {
                // {"error": -1, "error": "Fingerprint verification failed", "message": "reached MaxFailedAttempts"}
                threePPCardDetail = "{\"error\": -1, \"error\": \"Fingerprint verification failed\", \"message\": \"reached MaxFailedAttempts\"}";
            }

            return threePPCardDetail;
        }
    }
}
