//package com.shu;
//import com.carrotsearch.sizeof.RamUsageEstimator;
///**
// * @description:
// * @author: shurunlong
// * @create: 2020-07-16 11:01
// */
//public class Test {
//    public static void main(String[] args) {
//        String str="";
//        StringBuffer stringBuffer = new StringBuffer();
//
//        for (int i = 0; i < 100000; i++) {
//            stringBuffer.append("1234567890");
//        }
//        String s = stringBuffer.toString();
//
//        str=s;
//        System.out.println(str);
//        System.out.println(str.length());
//        RamUsageEstimator.sizeOf(str);
//    }
//
//}
