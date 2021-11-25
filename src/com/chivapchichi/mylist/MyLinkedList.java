package com.chivapchichi.mylist;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class MyLinkedList<E> implements ILinkedList<E> {

    private Node<E> first = null;
    private Node<E> last = null;
    private int size = 0;

    public MyLinkedList() {
    }

    @Override
    public void add(E element) {
        if (first == null) {
            first = new Node<>(element, null, null);
            last = first;
        } else if (first == last) {
            last = new Node<>(element, first, null);
            first.next = last;
        } else {
            Node<E> next = new Node<>(element, last, null);
            last.next = next;
            last = next;
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (index == size) {
            add(element);
            return;
        }
        Node<E> node = first;
        for (int i = 1; i <= index; i++){
            node = node.next;
        }
        Node<E> tmp = new Node<>(element, node.prev, node);
        node.prev = tmp;
        if (tmp.prev != null) {
            tmp.prev.next = tmp;
        }
        if (node == first) {
            first = tmp;
        }
        size++;
    }

    @Override
    public void clear() {
        for(Node<E> curr = first; curr != null;) {
            Node<E> next = curr.next;
            curr.prev = null;
            curr.item = null;
            curr.next = null;
            curr = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        Node<E> curr = first;
        for(int i = 1; i <= index; i++){
            curr = curr.next;
        }
        return curr.item;
    }

    @Override
    public int indexOf(E element) {
        int i = 0;
        for(Node<E> curr = first; curr != null; curr = curr.next){
            if (element == null && curr.item == null || curr.item != null && curr.item.equals(element)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        Node<E> curr = first;
        for (int i = 0; i < index && curr != null; i++) {
            curr = curr.next;
        }
        if (curr == last) {
            last = last.prev;
        }
        if (curr != null) {
            if (curr == first) {
                first = first.next;
            } else {
                curr.prev.next = curr.next;
            }
            curr.next.prev = curr.prev;
            curr.prev = null;
            curr.next = null;
            E item = curr.item;
            curr.item = null;
            size--;
            return item;
        }
        return null;
    }

    @Override
    public E set(int index, E element) {
        Node<E> curr = first;
        for (int i = 0; i < index && curr != null; i++) {
            curr = curr.next;
        }
        if (curr != null) {
            E item = curr.item;
            curr.item = element;
            return item;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] res = new Object[size];
        int i = 0;
        for (Node<E> curr = first; curr != null; curr = curr.next) {
            res[i++] = curr.item;
        }
        return res;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            a = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
        }
        int i = 0;
        Object[] res = a;
        for (Node<E> curr = first; curr != null; curr = curr.next) {
            res[i++] = curr.item;
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "size=" + size +
                ", list = " + Arrays.toString(this.toArray()) +
                '}';
    }

    @Override
    public Iterator<E> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<E> {
        private Node<E> curr = (Node<E>) first;

        public MyListIterator() {
        }

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public E next() {
            Node<E> next = curr;
            curr = curr.next;
            return next.item;
        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
