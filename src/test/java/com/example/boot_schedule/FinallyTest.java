package com.example.boot_schedule;

public class FinallyTest {
    public static void main(String[] args) {
        System.out.println(fin2());
    }

    public static int fin() {
        int i = 0;
        try {
            System.out.println("try:" + i);
            return ++i;
        } finally {
            System.out.println("finally:" + i);
            ++i;
            return i;
        }
    }

    public static Integer fin2(){
        Integer i = 3000;
        try {
            System.out.println("try:"+i);
            return ++i;
        } finally {
            i = 9;
            System.out.println("finally:" + i);

//            return i;
        }
    }

    public static StringBuilder fin3(){
        StringBuilder s = new StringBuilder("Hello");
        try
        {
            //doing something

            return s.append("Word");
        }catch(Exception e){
            return s;
        }finally{
            s.append("finally");
//            return s;
        }
    }

    public static String fin4(){
        String s = "Hello";
        try
        {
            //doing something
            s = s+ "World";
            return s;
        }catch(Exception e){
            return s;
        }finally{
            s = s + "finally";
//            return s;
        }
    }

    public static String s(String s){
        s = s+ "world";
        return s;
    }
}
