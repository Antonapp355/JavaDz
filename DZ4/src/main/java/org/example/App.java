package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


/**
 * @1. Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader
 * @2. Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"
 * @3. Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возрас и пол в отдельных списках.
 * @4. Отсортировать по возрасту используя дополнительный список индексов.
 */
public class App 
{
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main( String[] args ){

        //1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader

        //Сохранение в файл.
        try {
            FileWriter fw = new FileWriter("text.txt");
            fw.append("Петров Артём Викторович 56 Мужской");
            fw.append("\nИванов Игорь Макарович 22 Мужской");
            fw.append("\nСидоров Максим Петрович 35 Мужской");
            fw.append("\nПопова Лидия Антоновна 16 Женский");
            fw.append("\nБольшова Галина Константиновна 46 Женский");
            System.out.printf(ANSI_GREEN+"\nФайл записан.\n");
            fw.flush();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        //Загрузка из файла.
        try {
            FileReader fr = new FileReader("text.txt");
            StringBuilder sb = new StringBuilder();
            while (fr.ready()){
                sb.append((char) fr.read());
            }
            System.out.printf("\nФайл считан. \n"+ANSI_RESET+sb+"\n");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        //2. Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М".

        List<String> lstLName = new ArrayList<>();
        List<String> lstFName = new ArrayList<>();
        List<String> lstMName = new ArrayList<>();
        List<Integer> lstAge = new ArrayList<>();
        List<String> lstGender = new ArrayList<>();
        List<Boolean> lstGenderBool = new ArrayList<>();
        List<Integer> lstIndex = new ArrayList<>();

        //Загрузка из файла.
        try {
            FileReader fr = new FileReader("text.txt");
            StringBuilder sb = new StringBuilder();
            while (fr.ready()){
                sb.append((char)fr.read());
            }
            //Сплитование по новой строке.
            String[] stmp = sb.toString().split("\n");
            List<String> lst = new ArrayList<>();
            for (int i = 0; i < stmp.length; i++) {
                //Сплитование по пробелу.
                String[] strings = stmp[i].split(" ");
                //Создание списка индексов.
                lstIndex.add(i);
                for (int j = 0; j < strings.length; j++) {
                    lst.add(strings[j]);
                }
            }

            //Добавление Фамилии, имена, отчества, возрас и пол в отдельные списки (+добавил список гендеров в формате Boolean).
            for (int i = 0; i < lst.size(); i++) {
                if((i+1)%5==0){
                    lstGenderBool.add(lst.get(i).contains("у")?false:true);
                    lstGender.add(lst.get(i));
                    lstLName.add(lst.get(i-4));
                    lstFName.add(lst.get(i-3));
                    lstMName.add(lst.get(i-2));
                    lstAge.add(Integer.parseInt(lst.get(i-1)));
                }
            }
            System.out.printf(ANSI_GREEN+"\nВывод в формате \"Иванов И.И. 32 М\"."+ANSI_RESET);

            //Вывод в формате "Иванов И.И. 32 М".
            for (int i = 0; i < lstFName.size(); i++) {
                System.out.printf("\n"+ lstLName.get(i)+" "
                        +lstFName.get(i).toCharArray()[0]
                        +"."+lstMName.get(i).toCharArray()[0]
                        +". "+lstAge.get(i)
                        +" "+lstGender.get(i).toCharArray()[0]+".");
            }
            System.out.printf(
                    ANSI_GREEN+"\n\nСписки данных."+ANSI_RESET+"\nИмена\t\t\t" + lstFName
                    +"\nФамилии\t\t\t" + lstLName
                    +"\nОтчества\t\t" + lstMName
                    +"\nВозраст\t\t\t" + lstAge
                    +"\nПол\t\t\t\t" + lstGender
                    +"\nПол(Boolean)\t"+lstGenderBool
                    +"\nСписок индексов\t"+lstIndex+"\n");

            //Сортировка по возрасту.
            boolean sorted = false;
            int tempAge;
            int tempIndex;
            while(!sorted) {
                sorted = true;
                for (int i = 0; i < lstAge.size()-1; i++) {
                    if (lstAge.get(i) > lstAge.get(i+1)) {
                        tempAge = lstAge.get(i);
                        tempIndex = lstIndex.get(i);
                        lstAge.set(i,lstAge.get(i+1));
                        lstIndex.set(i,lstIndex.get(i+1));
                        lstAge.set(i+1,tempAge);
                        lstIndex.set(i+1,tempIndex);
                        sorted = false;
                    }
                }
            }

            //Вывод отсортированного списка в формате "Иванов И.И. 32 М".
            System.out.printf(ANSI_GREEN+"\n\nСортировка по возрасту."+ANSI_RESET);
            for (int i = 0; i < lstFName.size(); i++) {
                System.out.printf("\n"+ lstLName.get(lstIndex.get(i))+" "
                        +lstFName.get(lstIndex.get(i)).toCharArray()[0]
                        +"."+lstMName.get(lstIndex.get(i)).toCharArray()[0]
                        +". "+lstAge.get(i)
                        +" "+lstGender.get(lstIndex.get(i)).toCharArray()[0]+".");
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
