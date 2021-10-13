package ru.job4j.java20.task05;

import java.util.HashMap;
import java.util.Map;

public  class Test {


       Map<String, String> map = new HashMap<String, String>();

    public void setMap(String a, String b) {
        this.map.put(a, b);
    }
    public Map<String, String> getMap() {
        return this.map;
    }

    public static void main(String[] args ) {
            Test app1 = new Test();
            app1.setMap("qqq", "eee");
            app1.setMap("ddd", "fff");
            String k = null;
            String v = null;
        //for (Map.Entry entry: app1.getMap().entrySet()) {
            //получить ключ
            //k = entry.getValue();
            //получить значение
          //  v = entry.getKey();
       // }
        }
}
