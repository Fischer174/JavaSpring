package com.example.Buns.Mod2.Aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
    @Pointcut("execution(* add*(..))")
    public void allAddMethods(){}

    @Pointcut("execution(* get*(..))")
    public void allGetMethods(){}

    @Pointcut("execution(* return*(..))")
    public void allReturnMethods(){}
}

