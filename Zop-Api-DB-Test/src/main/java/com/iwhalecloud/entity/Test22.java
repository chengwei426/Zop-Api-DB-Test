package com.iwhalecloud.entity;

import java.util.Map;
//import com.alibaba.fastjson.JSON;

public class Test22 {

    public static void main(String[] args) {
        String headerStr = "{\"svcCont\":{\"requestObject\":{\"PosOrderRequest\":{\"order_action\":\"saveOrder\",\"lan_id\":\"731\",\"service_action\":\"complexService\",\"user_id\":\"31004179578\",\"extParameter\":{\"is_deal_fee\":\"0\",\"ext_cust_order_trs_id\":\"BCC_24831\"},\"service_optional_skip\":\"noCalcFee,noCommit\",\"cust_id\":\"9162\",\"PosCompInstance\":[{\"PosProdInst\":[{\"lan_id\":\"731\",\"acc_num\":\"411700016\",\"action_type\":\"A\",\"comp_role_id\":\"70000045\",\"attributes\":{\"attrib_01\":\"en-US\",\"payment_mode_cd\":\"1200\",\"CARD_TYPE_CODE\":\"Standard\",\"col7\":\"5\",\"attrib_08\":\"2\",\"col1\":\"4562718069509690423\"},\"PosProdInstAcct\":[{\"acct_item_group_id\":\"-1\",\"acct_id\":\"15643\",\"action_type\":\"A\",\"attributes\":{\"priority\":\"999\",\"if_default_acct_id\":\"1\"},\"priority\":\"999\"}],\"prod_id\":\"80000045\",\"PosProdInstFunc\":[{\"action_type\":\"A\",\"prod_id\":\"1016417\"}]}],\"PosOfferInst\":[{\"PosProdInst\":[{\"lan_id\":\"731\",\"acc_num\":\"411700016\",\"action_type\":\"A\",\"comp_role_id\":\"70000045\",\"prod_id\":\"80000045\"}],\"action_type\":\"A\",\"offer_id\":\"755729131\"},{\"PosProdInst\":[{\"lan_id\":\"731\",\"acc_num\":\"411700016\",\"action_type\":\"A\",\"comp_role_id\":\"70000045\",\"prod_id\":\"80000045\"}],\"action_type\":\"A\",\"offer_id\":\"755729132\"},{\"PosProdInst\":[{\"lan_id\":\"731\",\"acc_num\":\"411700016\",\"action_type\":\"A\",\"comp_role_id\":\"70000045\",\"prod_id\":\"80000045\"}],\"action_type\":\"A\",\"offer_id\":\"755729118\"},{\"PosProdInst\":[{\"lan_id\":\"731\",\"acc_num\":\"411700016\",\"action_type\":\"A\",\"comp_role_id\":\"70000045\",\"prod_id\":\"80000045\"}],\"action_type\":\"A\",\"offer_id\":\"755729188\"}],\"action_type\":\"A\",\"offer_id\":\"755729191\"}]}}},\"tcpCont\":{\"svcCode\":\"20200200030003\",\"appPwd\":\"4QrcOUm6Wau+VuBX8g+IPg==\",\"sign\":\"lP02k/Q119/WX8HdJZLafQ==\",\"appKey\":\"CRMBCC\",\"reqTime\":\"20200418075236\",\"dstSysId\":\"OrderCenter\",\"version\":\"1.0\",\"transactionId\":\"CRMBCC202004180752360000004981\"}}";
       // Map map = JSON.parseObject(headerStr, Map.class);
        System.out.println(headerStr.replaceAll("\n", "").replaceAll(" ", ""));
    }
}
