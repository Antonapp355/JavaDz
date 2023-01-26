package org.example;

/**
 * @1. Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).
 * @2. Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).
 * @3. Напишите программу, чтобы перевернуть строку с помощью рекурсии.
 * @4. Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
 * @5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
 * @6. *Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
 * @7. **Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.
 */
public class App 
{
    public static void main( String[] args )
    {
        String str1 = "abcdcba";
        String str2 = "abcd";
        int index = 0;
        String str3 = "";
        System.out.printf("\nЗадание 1. " +
                "Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).\n"
                + searchSubString(str1,str2) + "\n");                                                                   //Метод поиска вхождения подстроки в строке. Задание 1.
        System.out.printf("\nЗадание 2. " +
                "Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга " +
                "(вхождение в обратном порядке)." + searchRevSubString(str1,str2) + "\n");                              //Метод поиска прямого и реверсивного вхождения подстроки в строке. Задание 2.
        System.out.printf("\nЗадание 3. " +
                "Напишите программу, чтобы перевернуть строку с помощью рекурсии. " +
                "\n Оригинал строки: " + str2 + "\n Реверсированная строка: " + reverseString(str2,str3,index) + "\n"); //Метод рекурсивного реверсирования строки. Задание 3.
        strBAppend();                                                                                                   //Метод составления новых строк с выражениями и заменой символов. Задание 4,5,6.
        timeApp();                                                                                                      //Метод сравнения времени заполнения StringBuilder и String.
    }

    /**
     * @1. Метод поиска вхождения подстроки в строке. Задание 1.
     */
    static String searchSubString(String a,String b){
        if(a.contains(b)){
            return " В строке " + a + " есть вхождение строки " + b + ".";
        }
        else {
            return " В строке " + a + " нет вхождение строки " + b + ".";
        }
    }

    /**
     * @2. Метод поиска прямого и реверсивного вхождения подстроки в строке. Задание 2.
     */
    static String searchRevSubString(String a, String b){
        StringBuilder sb = new StringBuilder(a);
        if(a.contains(b) && sb.reverse().toString().contains(b)){
            return "\n Есть прямое и реверсивное вхождение строки.";
        }
        else {
            return "\n Нет реверсивного вхождения строки.";
        }

    }

    /**
     * @3. Метод рекурсивного реверсирования строки. Задание 3.
     */
    static String reverseString(String a, String b, int index){
        StringBuilder sb = new StringBuilder();
        sb.append(b);
        index = (a.length()-b.length())-1;
        if (index > -1){
            sb.append(a.charAt(index));
            return reverseString(a, sb.toString(),index);
        }
        else {
            return sb.toString();
        }
    }

    /**
     * @4,5,6. Метод составления новых строк с выражениями и заменой символов. Задание 4,5,6.
     */
    static void strBAppend(){
        System.out.printf("\nЗадание 4. Дано два числа, например 3 и 56, " +
                "необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 " +
                "Используем метод StringBuilder.append().\n");
        int x = 3;
        int y = 56;
        int index = 0;
        StringBuilder sb1 = new StringBuilder();
        sb1.append(" ").append(x).append(" + ").append(y).append(" = ").append(x+y).append("\n")
                .append(" ").append(x).append(" - ").append(y).append(" = ").append(x-y).append("\n")
                .append(" ").append(x).append(" * ").append(y).append(" = ").append(x*y).append("\n")
                .append(" ").append(x).append(" / ").append(y).append(" = ").append((float) x/y);
        System.out.printf(sb1+"\n\n");
        System.out.printf("Задание 5 (сделано по своему). Замените символ “=” на слово “равно”. " +
                "Использовал методы StringBuilder.toString().replaceAll.\n"+
                sb1.toString().replaceAll(" = ", " равно ")+                                            //Замена " = " на " равно " через StringBuilder.toString().replaceAll
                "\n\n");
        index = sb1.indexOf("+");
        System.out.printf("Задание 5 (оригинал но заменил “+” на слово “плюс”). Замените символ “=” на слово “равно”. " +
                "Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().\n"+
                sb1.deleteCharAt(index).insert(index, "плюс")+"\n\n");                                              //Замена "+" на "плюс" через StringBuilder.deleteCharAt().insert
        index = sb1.indexOf("-");
        System.out.printf("Задание 6 (заменил “-” на слово “минус”). " +
                "*Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().\n"+
                sb1.replace(index,index+1, "минус")+"\n\n");                                                    //Замена "-" на "минус" через StringBuilder.replace()
    }

    /**
     * @7. Метод сравнения времени заполнения StringBuilder и String.
     */
    static void timeApp(){
        System.out.println("7.Заполнить String 1000 символами, " +
                "вывести время и заполнить StringBuilder 1000 символами, вывести время.");
        String str = "";
        StringBuilder sb1 = new StringBuilder();
        sb1.delete(0, sb1.length());
        long begin1 = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            str += "!";
        }
        long end1 = System.currentTimeMillis();
        long begin2 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            sb1.append("!");
        }
        long end2 = System.currentTimeMillis();
        if (end1-begin1>end2-begin2){
            System.out.printf(" Время заполнения String больше.\n");
        }
        else {
            System.out.printf(" Время заполнения StringBuilder больше.\n");
        }
        System.out.printf(" Время заполнения String 1000 символами равно " + (end1-begin1) + "м/с. \n");
        System.out.printf(" Время заполнения StringBuilder 1000 символами равно " + (end2-begin2) + "\n");
    }
}
