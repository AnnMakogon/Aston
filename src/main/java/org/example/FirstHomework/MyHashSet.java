package org.example.FirstHomework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyHashSet<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTORY = 0.75;

    private List<Node<T>> table;
    private int size;

    public MyHashSet() {
        table = new ArrayList<>(DEFAULT_CAPACITY);
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            table.add(null);
        }
        size = 0;
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value){
            this.value = value;
        }
    }

    private int hash(T key) {
        if (key == null) return 0;
        int hashCode = key.hashCode();
        return (hashCode & 0x7FFFFFFF) % table.size();
    }

    public boolean insert (T value) {
        if (size >= table.size() * LOAD_FACTORY){
            resize();
        }

        int index = hash(value);
        Node<T> current = table.get(index);

        while (current != null) {
            if (Objects.equals(current.value, value)) {
                return false; // Уже существует
            }
            current = current.next;
        }

        Node<T> newNode = new Node<>(value);
        newNode.next = table.get(index);
        table.set(index, newNode);
        size++;
        return true;
    }

    public boolean remove(T value) {
        int index = hash(value);
        Node<T> current = table.get(index);
        Node<T> prev = null;

        while (current != null) {
            if (Objects.equals(current.value, value)) {
                if (prev == null) {
                    table.set(index, current.next);
                } else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    private void resize() {
        List<Node<T>> oldTable = table;
        table = new ArrayList<>(oldTable.size() * 2);
        for (int i = 0; i < oldTable.size() * 2; i++) {
            table.add(null);
        }
        size = 0;

        for (Node<T> node : oldTable) {
            Node<T> current = node;
            while (current != null) {
                insert(current.value);
                current = current.next;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean contains(T value) {
        int index = hash(value);
        Node<T> current = table.get(index);

        while (current != null) {
            if (Objects.equals(current.value, value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
