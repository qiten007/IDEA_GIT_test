package com.learn.myselfTest;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author hulinqi
 * @date 2020/5/4 --  15:24
 * @purpuse
 */
public class 能精确表示数值的做法 {
    public static void main(String[] args){
        double d1 = 20.12;
        double d2 = 10.10;

        //直接用double类型数据进行运算。。
        System.out.println("直接用double类型数据进行运算:"+(d1 - d2));

        BigDecimal bdV1 = BigDecimal.valueOf(d1);
        BigDecimal bdV2 = BigDecimal.valueOf(d2);

        //用bigdicimal的string方法可以解决，因为valueof底层用了string方法，所以用valueof也可以解决精度问题
        System.out.println("用bigdecimal的valueof进行运算:"+bdV1.subtract(bdV2));

        BigDecimal bd1 = new BigDecimal(d1);
        BigDecimal bd2 = new BigDecimal(d2);
        System.out.println("用bigdecimal的new进行运算:"+bd1.subtract(bd2));

        BigDecimal bdStr1 = new BigDecimal("20.12");
        BigDecimal bdStr2 = new BigDecimal("10.10");
        System.out.println("用bigdecimal的new加String参数进行运算:"+bdStr1.subtract(bdStr2));

    }
}


/*======================运行结果=========================
E:\IT_setting\myeclipse_jdk1.8\bin\java.exe "-javaagent:E:\IT_software\IntelliJ IDEA 2018.2.5\lib\idea_rt.jar=4605:E:\IT_software\IntelliJ IDEA 2018.2.5\bin" -Dfile.encoding=UTF-8 -classpath E:\IT_setting\myeclipse_jdk1.8\jre\lib\charsets.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\deploy.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\ext\access-bridge-64.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\ext\cldrdata.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\ext\dnsns.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\ext\jaccess.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\ext\jfxrt.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\ext\localedata.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\ext\nashorn.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\ext\sunec.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\ext\sunjce_provider.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\ext\sunmscapi.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\ext\sunpkcs11.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\ext\zipfs.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\javaws.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\jce.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\jfr.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\jfxswt.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\jsse.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\management-agent.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\plugin.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\resources.jar;E:\IT_setting\myeclipse_jdk1.8\jre\lib\rt.jar;E:\ideaWorkspace\面试学习\out\production\面试学习;C:\Users\Think\.m2\repository\junit\junit\4.12\junit-4.12.jar;C:\Users\Think\.m2\repository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar com.learn.myselfTest.能精确表示数值的做法
直接用double类型数据进行运算:10.020000000000001
用bigdecimal的valueof进行运算:10.02
用bigdecimal的new进行运算:10.0200000000000013500311979441903531551361083984375
用bigdecimal的new加String参数进行运算:10.02
*
* */