package main.java.campanadegauss.vista;

import main.java.campanadegauss.modelo.Bola;

import java.util.*;

public class ArrayList implements List<Bola> {
    private List<Bola> list = new java.util.ArrayList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<Bola> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(Bola bola) {
        return list.add(bola);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Bola> c) {
        return list.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Bola> c) {
        return list.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Bola get(int index) {
        return list.get(index);
    }

    @Override
    public Bola set(int index, Bola element) {
        return list.set(index, element);
    }

    @Override
    public void add(int index, Bola element) {
        list.add(index, element);
    }

    @Override
    public Bola remove(int index) {
        return list.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    @Override
    public ListIterator<Bola> listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator<Bola> listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public List<Bola> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }
}