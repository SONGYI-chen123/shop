package com.example.shop.common.exception;

import lombok.Getter;

@Getter
public enum ShopExceptionCode implements IExceptionCode {
    ADD_STUDENT_FAILED("添加学生失败","Add student failed"),
    STUDENT_NOT_EXIST("抱歉，学生不存在", "Sorry, this student does not exist"),
    PARENT_NOT_EXIST("抱歉，该学生家长不存在", "Sorry, this parent of student does not exist");


    ShopExceptionCode(String zhMsg, String enMsg) {
        this.zhMsg = zhMsg;
        this.enMsg = enMsg;
    }

    String zhMsg;

    String enMsg;

    @Override
    public String getValue() {
        return this.name();
    }
}
