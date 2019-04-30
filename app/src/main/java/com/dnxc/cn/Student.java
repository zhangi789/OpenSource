package com.dnxc.cn;

/**
 * @author 张海洋
 * @Date on 2019/04/18.
 * @org 上海..科技有限公司
 * @describe
 */
public class Student {
   String key;
   int value;

    public Student(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
