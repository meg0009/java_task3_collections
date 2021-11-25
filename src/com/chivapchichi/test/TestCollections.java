package com.chivapchichi.test;

import java.util.*;

public class TestCollections {

    public static void main(String[] args) {
        System.out.println("ArrayList:");
        testList(new ArrayList<>());

        System.out.println("================================");
        System.out.println("LinkedList:");
        testList(new LinkedList<>());

        System.out.println("================================");
        System.out.println("HashSet:");
        testSet(new HashSet<>());

        System.out.println("================================");
        System.out.println("LinkedHashSet:");
        testSet(new LinkedHashSet<>());

        System.out.println("================================");
        System.out.println("TreeSet:");
        testSet(new TreeSet<>());

        System.out.println("================================");
        System.out.println("HashMap:");
        testMap(new HashMap<>());

        System.out.println("================================");
        System.out.println("LinkedHashMap:");
        testMap(new LinkedHashMap<>());

        System.out.println("================================");
        System.out.println("TreeMap:");
        testMap(new TreeMap<>());
    }

    private static int size = 10000;

    private static void testList(List<Integer> list) {
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rnd.nextInt());
        }
        System.out.println("Вставка в начало");
        insertIntoList(list, 0, 1);

        System.out.println("Вставка в середину");
        insertIntoList(list, size / 2, 2);

        System.out.println("Вставка в конец");
        insertIntoList(list, 3);

        System.out.println("Удаление с начала");
        removeFromList(list, 0);

        System.out.println("Удаление с серидины");
        removeFromList(list, size / 2);

        System.out.println("Удаление с конца");
        removeFromList(list, size);

        System.out.println("Взятие элемента в начале");
        getFromList(list, 0);

        System.out.println("Взятие элемента в серидине");
        getFromList(list, size / 2);

        System.out.println("Взятие элемента в конце");
        getFromList(list, size - 1);
    }

    private static <T> void insertIntoList(List<T> list, int index,  T element) {
        long start = System.nanoTime();
        list.add(index, element);
        long finish = System.nanoTime();
        System.out.println("результат = " + (finish - start));
    }

    private static <T> void insertIntoList(List<T> list,  T element) {
        long start = System.nanoTime();
        list.add(element);
        long finish = System.nanoTime();
        System.out.println("результат = " + (finish - start));
    }

    private static <T> void removeFromList(List<T> list, int index) {
        long start = System.nanoTime();
        list.remove(index);
        long finish = System.nanoTime();
        System.out.println("результат = " + (finish - start));
    }

    private static <T> T getFromList(List<T> list, int index) {
        long start = System.nanoTime();
        T item = list.get(index);
        long finish = System.nanoTime();
        System.out.println("результат = " + (finish - start));
        return item;
    }

    private static void testSet(Set<Double> set) {
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            set.add(rnd.nextDouble());
        }

        final double tmp = 2.;
        final double tmp1 = -2.;
        final double tmp2 = 0.2;
        System.out.println("Добавление элементов");
        insertIntoSet(set, tmp);
        insertIntoSet(set, tmp1);
        insertIntoSet(set, tmp2);

        System.out.println("Проверка на содержание");
        setContains(set, tmp);
        setContains(set, tmp1);
        setContains(set, tmp2);

        System.out.println("Удаление элемента");
        removeFromSet(set, tmp);
        removeFromSet(set, tmp1);
        removeFromSet(set, tmp2);
    }

    private static <T> void insertIntoSet(Set<T> set, T element) {
        long start = System.nanoTime();
        set.add(element);
        long finish = System.nanoTime();
        System.out.println("результат = " + (finish - start));
    }

    private static <T> void setContains(Set<T> set, T element) {
        long start = System.nanoTime();
        set.contains(element);
        long finish = System.nanoTime();
        System.out.println("результат = " + (finish - start));
    }

    private static <T> void removeFromSet(Set<T> set, T element) {
        long start = System.nanoTime();
        set.remove(element);
        long finish = System.nanoTime();
        System.out.println("результат = " + (finish - start));
    }

    private static void testMap(Map<Integer, Double> map) {
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            map.put(i, rnd.nextDouble());
        }

        System.out.println("Добавление элементов");
        insertIntoMap(map, -1, 1.);
        insertIntoMap(map, size + 1, 1.);
        insertIntoMap(map, size / 2, 1.);

        System.out.println("Доступ к элементам");
        getFromMap(map, -1);
        getFromMap(map, size + 1);
        getFromMap(map, size / 2);

        System.out.println("Удаление элементов");
        removeFromMap(map, -1);
        removeFromMap(map, size + 1);
        removeFromMap(map, size / 2);
    }

    private static <K, T> void insertIntoMap(Map<K, T> map, K key, T value) {
        long start = System.nanoTime();
        map.put(key, value);
        long finish = System.nanoTime();
        System.out.println("результат = " + (finish - start));
    }

    private static <K, T> T getFromMap(Map<K, T> map, K key) {
        long start = System.nanoTime();
        T item = map.get(key);
        long finish = System.nanoTime();
        System.out.println("результат = " + (finish - start));
        return item;
    }

    private static <K, T> void removeFromMap(Map<K, T> map, K key) {
        long start = System.nanoTime();
        map.remove(key);
        long finish = System.nanoTime();
        System.out.println("результат = " + (finish - start));
    }
}
