package org.example;

import java.util.Arrays;
import java.util.Random;

/**
 * @ДЗ. Первый семинар.
 * @1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i.
 * @2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа.
 * @3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1.
 * @4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2.
 *
 * @ps: int i = new Random().nextInt(k); //это кидалка случайных чисел!).
 */
public class App
{
    public static void main( String[] args )
    {
        int i = new Random().nextInt(2000);
        String n = "";
        n = numberToByte(i);
        n = maxBit(n);
        String[] m1 = sqr(Integer.toString(i), Integer.parseInt(n)).split(" ");     //Массив чисел кратных n в диапазоне от i до Short.MAX_VALUE.
        String[] m2 = nSqr(Integer.toString(i), Integer.parseInt(n)).split(" ");    //Массив чисел кратных n в диапазоне от Short.MIN_VALUE до i.
        System.out.printf
                     (i + " - Рандомное число в диапазоне от 0 до 2000.\n"
                        + n + " - Номер cтаршего бита.\n"
                        + Arrays.toString(m1) + " - Все числа кратные n в диапазоне от i до Short.MAX_VALUE\n"
                        + Arrays.toString(m2) + " - Все не кратные n числа в диапазоне от Short.MIN_VALUE до i"
                     );
    }
    /**
     * @Конвертирует: Число i из int в двоичный код.
    */
    public static String numberToByte(int i){
        String n = Integer.toBinaryString(i);
        return n;
    }

    /**
     * @Находит: Номер cтаршего бита числа i.
     */
    public static String maxBit(String m){
        int n = m.length()-1;
        return Integer.toString(n);
    }

    /**
     * @Находит: Все числа кратные n в диапазоне от i до Short.MAX_VALUE
     */
    public static String sqr(String i, int n){
        String text = "";
        for (int j = Integer.parseInt(i); j < Short.MAX_VALUE; j++) {
            if (j % n == 0){
                text += j;
                text += ' ';
            }
        }
        return text;
    }

    /**
     * @Находит: Все числа не кратные n в диапазоне от Short.MIX_VALUE до i.
     */
    public static String nSqr(String i, int n){
        String text = "";
        for (int j = Short.MIN_VALUE; j < Integer.parseInt(i); j++) {
            if (j % n != 0){
                text += j;
                text += ' ';
            }
        }
        return text;
    }

}
