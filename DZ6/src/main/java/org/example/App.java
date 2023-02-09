package org.example;

import java.util.*;

/**
 * Разработать программу, имитирующую поведение коллекции HashSet.
 * В программе содать метод add добавляющий элемент,
 * метод toString возвращающий строку с элементами множества и метод позволяющий читать элементы по индексу.
 * Формат данных Integer.
 */
public class App {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        Map<Integer,String> mapS = new HashMap<>();
        mapS.put(1,"c");
        mapS.put(2,"a");
        mapS.put(3,"d");
        mapS.put(4,"b");
        System.out.println("\nHashMap = "+ANSI_YELLOW+mapS+ANSI_RESET);

        Set<Integer> set = new HashSet<>();
        set.add(6);
        set.add(2);
        set.add(4);
        set.add(1);
        System.out.println("\nSet = "+ANSI_PURPLE+set+"\n"+ANSI_RESET);

        MySet mySet = new MySet();

        mySet.add(1);
        mySet.add(6);
        mySet.add(37);
        mySet.add(6);
        System.out.println("mySet = "+ANSI_GREEN+mySet+"\n"+ANSI_RESET);
        for (int i = 0; i < mySet.size(); i++) {
            System.out.println(mySet.get(i));
        }
    }
}
class MySet {
    static TreeMap<Integer, Object> map = new TreeMap<>();
    private final Object obj =new Object();

    @Override
    public String toString(){
        return map.keySet().toString();
    }
    public boolean add(Integer i){
        map.put(i,obj);
        return true;
    }
    public Integer size(){
        return map.keySet().size();
    }
    public Integer get(Integer i){
        return (int)map.keySet().toArray()[i];
    }

}
