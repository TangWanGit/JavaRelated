package com.tangwan.jvm;

public class FinalizeActive {

    public static FinalizeActive obj;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("执行finalize");
        obj = this;
    }

    public static void main(String[] args) {

        obj = new FinalizeActive();

        //obj=null
        obj = null;
        System.gc();
        System.out.println("After GC");
        if (obj != null) {
            System.out.println("对象复活");
        }

        obj = null;
        System.out.println("After GC");
        if (obj == null) {
            System.out.println("对象死亡");
        }
    }
}