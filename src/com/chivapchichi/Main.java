package com.chivapchichi;

import com.chivapchichi.mylist.MyLinkedList;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("===========================");
        System.out.println("add to end");
        MyLinkedList<String> listString = new MyLinkedList<>();
        listString.add("hello");
        listString.add("world");
        listString.add("12345");
        listString.add(3, "98745");
        listString.add(0, "98745");
        listString.forEach(System.out::println);

        System.out.println("===========================");
        System.out.println("add to index = 1 and index = 3");
        listString.add(1, "foo");
        listString.add(3, "bar");
        listString.forEach(System.out::println);

        System.out.println("===========================");
        System.out.println("clear");
        listString.clear();
        System.out.println(listString);

        System.out.println("===========================");
        System.out.println("get");
        listString.add("hello");
        listString.add("world");
        listString.add("12345");
        listString.add(3, "98745");
        listString.add(1, "foo");
        listString.add(3, "bar");
        System.out.println("first element = " + listString.get(1));
        System.out.println("6 element = " + listString.get(6));
        System.out.println("-1 element = " + listString.get(-1));

        System.out.println("===========================");
        listString.add("world");
        System.out.println(listString);
        System.out.println("indexOf \"world\" = " + listString.indexOf("world"));
        System.out.println("indexOf \"ccc\" = " + listString.indexOf("ccc"));

        System.out.println("===========================");
        System.out.println(listString);
        System.out.println("remove 1 = " + listString.remove(1));
        System.out.println(listString);

        System.out.println("===========================");
        System.out.println("set to \"kkk\" 2 = " + listString.set(2, "kkk"));
        System.out.println(listString);

        System.out.println("===========================");
        System.out.println("size = " + listString.size());

        System.out.println("===========================");
        Object[] arrObj = listString.toArray();
        System.out.println("like array = " + Arrays.toString(arrObj));
        String[] arrString = new String[6];
        String[] arrString2 = listString.toArray(arrString);
        System.out.println(arrString2 == arrString);
        System.out.println("like array = " + Arrays.toString(arrString2));
        arrString = new String[10];
        arrString2 = listString.toArray(arrString);
        System.out.println(arrString[6]);
        arrString = new String[1];
        arrString2 = listString.toArray(arrString);
        System.out.println(arrString == arrString2);

        MyLinkedList<Integer> myListInt = new MyLinkedList<>();
        LinkedList<Integer> listInt = new LinkedList<>();
        Random rnd = new Random();
        int size = 10000;
        for (int i = 0; i < size; i++) {
            int r = rnd.nextInt();
            myListInt.add(r);
            listInt.add(r);
        }

        System.out.println("===========================");
        System.out.println("Вставка в конец");
        long s = System.nanoTime();
        myListInt.add(100);
        long f = System.nanoTime();
        System.out.println("время myList = " + (f - s));

        s = System.nanoTime();
        listInt.add(100);
        f = System.nanoTime();
        System.out.println("время LinkedList = " + (f - s));

        System.out.println("Вставка в начало");
        s = System.nanoTime();
        myListInt.add(0, 1);
        f = System.nanoTime();
        System.out.println("время myList = " + (f - s));

        s = System.nanoTime();
        listInt.add(0, 1);
        f = System.nanoTime();
        System.out.println("время LinkedList = " + (f - s));

        System.out.println("Вставка в середину");
        s = System.nanoTime();
        myListInt.add(size / 2, 16);
        f = System.nanoTime();
        System.out.println("время myList = " + (f - s));

        s = System.nanoTime();
        listInt.add(size / 2, 16);
        f = System.nanoTime();
        System.out.println("время LinkedList = " + (f - s));

        System.out.println("Поиск элемента в середине");
        myListInt.set(size / 2, null);
        s = System.nanoTime();
        System.out.println(myListInt.indexOf(null));
        f = System.nanoTime();
        System.out.println("время myList = " + (f - s));

        listInt.set(size / 2, null);
        s = System.nanoTime();
        System.out.println(listInt.indexOf(null));
        f = System.nanoTime();
        System.out.println("время LinkedList = " + (f - s));

        System.out.println("Поиск элемента в конце");
        myListInt.set(size / 2, 1);
        myListInt.set(size, null);
        s = System.nanoTime();
        System.out.println(myListInt.indexOf(null));
        f = System.nanoTime();
        System.out.println("время myList = " + (f - s));

        listInt.set(size / 2, 1);
        listInt.set(size, null);
        s = System.nanoTime();
        System.out.println(listInt.indexOf(null));
        f = System.nanoTime();
        System.out.println("время LinkedList = " + (f - s));

        System.out.println("Поиск элемента в начале");
        myListInt.set(size, 1);
        myListInt.set(0, null);
        s = System.nanoTime();
        System.out.println(myListInt.indexOf(null));
        f = System.nanoTime();
        System.out.println("время myList = " + (f - s));
        myListInt.set(0, 1);

        listInt.set(size, 1);
        listInt.set(0, null);
        s = System.nanoTime();
        System.out.println(listInt.indexOf(null));
        f = System.nanoTime();
        System.out.println("время LinkedList = " + (f - s));
        listInt.set(0, 1);

        System.out.println("удаление элемента в конце");
        s = System.nanoTime();
        System.out.println(myListInt.remove(size));
        f = System.nanoTime();
        System.out.println("время myList = " + (f - s));

        s = System.nanoTime();
        System.out.println(listInt.remove(size));
        f = System.nanoTime();
        System.out.println("время LinkedList = " + (f - s));

        System.out.println("удаление элемента в начале");
        s = System.nanoTime();
        System.out.println(myListInt.remove(0));
        f = System.nanoTime();
        System.out.println("время myList = " + (f - s));

        s = System.nanoTime();
        System.out.println(listInt.remove(0));
        f = System.nanoTime();
        System.out.println("время LinkedList = " + (f - s));

        System.out.println("удаление элемента в середине");
        s = System.nanoTime();
        System.out.println(myListInt.remove(size / 2));
        f = System.nanoTime();
        System.out.println("время myList = " + (f - s));

        s = System.nanoTime();
        System.out.println(listInt.remove(size / 2));
        f = System.nanoTime();
        System.out.println("время LinkedList = " + (f - s));
    }
}
