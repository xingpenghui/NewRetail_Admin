package com.feri.admin.core.result;

/**
 * 自定义枚举类型
 * 用户类型
 * flag:
 * 1、有效
 * 2、临时无效
 * 3、永久无效*/
public enum MemberFlag {
    Youxiao(1),Linshi(2),Wuxiao(3);
    private int value;
    private MemberFlag(int value){
        this.value=value;
    }
    public int getValue(){
        return value;
    }
}
