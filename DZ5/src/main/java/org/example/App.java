package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @1. Создать словарь HashMap. Обобщение <Integer, String>.
 * @2. Заполнить тремя ключами (индекс, цвет), добавить ключь, если не было!)
 * @3. Изменить значения дописав восклицательные знаки.
 * @4. *Создать TreeMap, заполнить аналогично.
 * @5. *Увеличить количество элементов до 1000 случайными ключами и общей строкой.
 * @6. **Сравнить время последовательного и случайного перебора тысячи элементов словарей.
 *
 */
public class App

{
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main( String[] args )
    {
        //1. Создать словарь HashMap. Обобщение <Integer, String>.
//======================================================================================================================
        HashMap<Integer,String> map = new HashMap<>();
        System.out.printf(ANSI_GREEN+"\nСловарь HashMap создан.\n"+ANSI_RESET);



        //2. Заполнить тремя ключами (индекс, цвет), добавить ключь, если не было!)
//======================================================================================================================
        map.put(0,"Green");
        map.put(1,"Red");
        map.put(2,"Blue");
        map.put(3,"Yellow");
        map.put(4,"Black");
        System.out.printf(ANSI_GREEN+"\nСловарь HashMap заполнен.\n"+ANSI_RESET+map);



        //3. Изменить значения дописав восклицательные знаки.
//======================================================================================================================
        for (Integer tmp : map.keySet()) {
            map.compute(tmp, (k,v) -> v+='!');
        }
        System.out.printf(ANSI_GREEN+"\n\nЗначения в HashMap изменены.\n"+ANSI_RESET+map);



        //4. *Создать TreeMap, заполнить аналогично.
//======================================================================================================================
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(0,"Green");
        treeMap.put(1,"Red");
        treeMap.put(2,"Blue");
        treeMap.put(3,"Yellow");
        treeMap.put(4,"Black");
        System.out.printf(ANSI_GREEN+"\n\nСловарь TreeMap создан и заполнен.\n"+ANSI_RESET+treeMap);



        //5. *Увеличить количество элементов до 1000 случайными ключами и общей строкой.
//======================================================================================================================
        for (int i = 5; i < 1000; i++) {
            Random rnd = new Random();
            map.put(rnd.nextInt(),"Hello");
            treeMap.put(rnd.nextInt(),"Hello");
        }
        //Дополнительно создал Map-ы для последовательного перебора.
        Map<Integer,String> map1 = new HashMap<>();
        TreeMap<Integer,String> treeMap1 = new TreeMap<>();
        for (int i = 0; i < 1000; i++) {
            map1.put(i,"Hello");
            treeMap1.put(i,"Hello");
        }

        System.out.printf(ANSI_GREEN+"\n\nСловари увеличены до 1000 элементов.\n"+ANSI_RESET);



        //6. **Сравнить время последовательного и случайного перебора тысячи элементов словарей.
//======================================================================================================================
        //Последовательный перебор
        System.out.println(ANSI_GREEN+"\nПоследовательный перебор."+ANSI_RESET);
        long begin1 = System.currentTimeMillis();
        for (Integer key: map1.keySet()) {
            System.out.println(key+" = "+map1.get(key));
        }
        for (Integer key: treeMap1.keySet()) {
            System.out.println(key + " = " + treeMap1.get(key));
        }
        long end1 = System.currentTimeMillis();

        //Случайный перебор
        System.out.println(ANSI_GREEN+"\n\nСлучайный перебор."+ANSI_RESET);
        long begin2 = System.currentTimeMillis();
        for (Integer key: map.keySet()) {
            System.out.println(key+" = "+map.get(key));
        }
        for (Integer key: treeMap.keySet()) {
            System.out.println(key + " = " + treeMap.get(key));
        }
        long end2 = System.currentTimeMillis();
        System.out.printf(ANSI_YELLOW+"\n\nПоследовательный перебор занимает "+(end1-begin1)+" м.с.\n");
        System.out.printf("Случайный перебор занимает "+(end2-begin2)+" м.с.\n\n");

        if(end1-begin1>end2-begin2){
            System.out.println(ANSI_GREEN+"Последовательный перебор занимает больше времени."+"("+(end1-begin1)+" м.с.)");
        }else {
            System.out.println("Случайный перебор занимает больше времени."+"("+(end2-begin2)+" м.с.)"+ANSI_RESET);
        }

    }
}
