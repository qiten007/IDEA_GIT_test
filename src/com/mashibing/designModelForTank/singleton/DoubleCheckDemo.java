package com.mashibing.designModelForTank.singleton;

/**
 * @author hulinqi
 * @date 2020/4/23 --  17:20
 * @purpuse
 */
public class DoubleCheckDemo {
    private static volatile DoubleCheckDemo INSTANCE;

    private DoubleCheckDemo(){}

    public DoubleCheckDemo getINSTANCE(){
        if(INSTANCE == null){
            synchronized (this){
                if(INSTANCE == null){
                    INSTANCE = new DoubleCheckDemo();
                }
            }
        }
        return INSTANCE;
    }
}
