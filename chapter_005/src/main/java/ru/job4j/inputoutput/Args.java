package ru.job4j.inputoutput;

import java.util.HashMap;
import java.util.Map;

public class Args {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }
    private void parse(String[] args) {
        for(String arg: args) {
            String str = arg;
            int index0 = str.indexOf("-");
            int index1 = str.indexOf("=");
            String str1 = str.substring(index0,index1);
            String str2 = str.substring(index1+1);
            values.put(str1, str2);
        }
    }

    public static Args of(String[] args) {
        Args names = new Args();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        // прописал в конфигурации
        //args  -Xmx=512 -encoding=UTF-8 -out=project.zip
        Args jvm = Args.of(args);
        System.out.println(jvm.get("-Xmx"));
        System.out.println(jvm.get("-encoding"));
        System.out.println(jvm.get("-out"));
    }
}
