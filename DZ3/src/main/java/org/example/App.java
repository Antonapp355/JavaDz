package org.example;

import java.util.*;

/**
 * @1. Создать новый список, добавить несколько строк и вывести коллекцию на экран.
 * @2. Итерация всех элементов списка цветов и добавления к каждому символа '!'.
 * @3. Вставить элемент в список в первой позиции.
 * @4. Извлечь элемент (по указанному индексу) из заданного списка.
 * @5. Обновить определенный элемент списка по заданному индексу.
 * @6. Удалить третий элемент из списка.
 * @7. Поиска элемента в списке по строке.
 * @8. Создать новый список и добавить в него несколько елементов первого списка.
 * @9. Удалить из первого списка все элементы отсутствующие во втором списке.
 * @10. *Сортировка списка.
 */
public class App 
{
    public static void main( String[] args )
    {
        List<String> lst1 = new ArrayList<>();
        List<String> lst2 = new ArrayList<>();
        addList(lst1);
        lst1.clear();
        collorList(lst1);
        appendList(lst1);
        String extractStr = toExtract(lst1);
        System.out.printf("" +
                "\n4. Извлечь элемент (по указанному индексу) из заданного списка." +
                "\n "+extractStr+"" +
                "\n");
        delElement(lst1);
        String str = "Red!";
        searchElement(lst1,str);
        lst2 = addNewList(lst1,lst2);
        lst2 = removeAll(lst1,lst2);
        lst1.clear();
        lst1 = sortList(lst1);

    }

    /**
     * @1. Создать новый список, добавить несколько строк и вывести коллекцию на экран.
     */
    public static List addList(List lst){
        lst.add("Hello");
        lst.add("My");
        lst.add("World");
        System.out.printf("" +
                "\n1. Создать новый список, добавить несколько строк и вывести коллекцию на экран." +
                "\n "+lst);
        return lst;
    }

    /**
     * @2. Итерация всех элементов списка цветов и добавления к каждому символа '!'.
     * @5. Обновить определенный элемент списка по заданному индексу.
     */
    public static List collorList(List lst){
        lst.add("Red");
        lst.add("Green");
        lst.add("Blue");
        lst.add("Yellow");
        lst.add("Black");
        System.out.println(lst);
        for (int i = 0; i < lst.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(lst.get(i).toString()).append("!");
            lst.set(i,sb);
        }
//        Или так.
//        for (int i = 0; i < lst.size(); i++) {
//            System.out.printf(lst.get(i)+"!");
//        }
        System.out.printf("" +
                "\nЗАДАНИЕ 2 В ОДНОМ." +
                "\n2. Итерация всех элементов списка цветов и добавления к каждому символа '!'." +
                "\n5. Обновить определенный элемент списка по заданному индексу." +
                "\n "+lst+"" +
                "\n");
        return lst;
    }

    /**
     * @3. Вставить элемент в список в первой позиции.
     */
    public static List appendList(List lst){
        lst.add(0, "Hello!)");
        System.out.printf("\n3. Вставить элемент в список в первой позиции." +
                "\n "+lst+"" +
                "\n");
        return lst;
    }

    /**
     * @4. Извлечь элемент (по указанному индексу) из заданного списка.
     */
    public static String toExtract(List lst){
        return lst.get(2).toString();
    }

    /**
     * @6. Удалить третий элемент из списка.
     */
    public static List delElement(List lst){
        lst.remove(2);
        System.out.printf("" +
                "\n6. Удалить третий элемент из списка." +
                "\n "+lst+"" +
                "\n");
        return lst;
    }

    /**
     * @7. Поиска элемента в списке по строке.
     */
    public static void searchElement(List lst, String str){
        System.out.printf("" +
                "\n7. Поиска элемента в списке по строке. Ищу строку \""+str+"\"");
        boolean b = false;
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).toString().equals(str)) {
                b = true;
                System.out.printf("" +
                        "\n Элемент найден. Индекс элемента: " + i+"" +
                        "\n");
            }
        }
        if (b==false){
            System.out.println("" +
                    "\n Элемент не найден."+"" +
                    "\n");
        }
    }

    /**
     * @8. Создать новый список и добавить в него несколько елементов первого списка.
     */
    public static List addNewList(List lst1, List lst2){
        lst2.add(lst1.get(1));
        lst2.add(lst1.get(2));
        System.out.printf("" +
                "\n8. Создать новый список и добавить в него несколько елементов первого списка." +
                "\n "+lst2+"" +
                "\n");
        return lst2;
    }

    /**
     * @9. Удалить из первого списка все элементы отсутствующие во втором списке.
     */
    public static List removeAll(List lst1, List lst2){
        System.out.printf("" +
                "\n9. Удалить из первого списка все элементы отсутствующие во втором списке." +
                "\n Второй список: "+lst2 +
                "\n Первый не скорректированный список: "+lst1+"" +
                "\n ");
        lst1.retainAll(lst2);
        System.out.printf("" +
                "Первый скорректированный список: "+lst1+"" +
                "\n");
        return lst1;
    }

    /**
     * @10. *Сортировка списка.
     */
    public static List sortList(List lst){
        Random rnd = new Random();
        for (int i = 0; i < 8; i++) {
            lst.add(rnd.nextInt(8));
        }
        System.out.printf("" +
                "\n10. *Сортировка списка." +
                "\n Не сортированный список: "+lst);
        lst.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.printf("" +
                "\n Сортированный список: "+lst+"" +
                "\n");
        return lst;
    }
}
