package com.iwhalecloud.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class IndexTest {
    public static void main(String[] args) {
        List<String> seqList = new ArrayList<>(600);
        try{
            BufferedReader br = new BufferedReader(new FileReader("D:/udal_seq.txt"));//构造一个BufferedReader类来读取文件
            String seq = null;
            while((seq = br.readLine())!= null){ //使用readLine方法，一次读一行
                seqList.add(seq);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        /*List<String> curList = new ArrayList<>(600);
        try{
            BufferedReader br = new BufferedReader(new FileReader("D:/curr_vlue.txt"));//构造一个BufferedReader类来读取文件
            String cur = null;
            while((cur = br.readLine())!= null){ //使用readLine方法，一次读一行
                curList.add(cur);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }*/

        System.out.println(seqList.size());
        //System.out.println(curList.size());
        for (int i = 0; i < seqList.size(); i++) {
            //System.out.println("seqop @@addseq name='" + seqList.get(i) + "' and value='" + curList.get(i) + "' and increment='1' and min='1' max='9999999999999' and isCycle='false';");
            //System.out.println("ALTER SEQUENCE " + seqList.get(i) + " MAXVALUE 999999999999;");
            //CREATE SIMPLE SEQUENCE seq4 START WITH 1000 INCREMENT BY 2 MAXVALUE 99999999999 NOCYCLE;
            System.out.println("CREATE SIMPLE SEQUENCE " + seqList.get(i) + " START WITH 1 INCREMENT BY 1 MAXVALUE 999999999999 NOCYCLE;");
        }
    }
}
