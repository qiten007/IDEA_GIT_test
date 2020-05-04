package com.mashibing.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @author hulinqi
 * @date 2020/4/23 --  14:56
 * @purpuse
 */
public class PropertyManger {
   static Properties props = new Properties();

   static {
       try {
           props. load(PropertyManger.class.getClassLoader().getResourceAsStream("config"));
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public static Object get(String key) {
       if (props == null) {
           return null;
       }else {
           return props.get(key);
       }
   }
}
