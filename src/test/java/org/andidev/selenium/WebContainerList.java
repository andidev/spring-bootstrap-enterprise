package org.andidev.selenium;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebElement;

public class WebContainerList<E extends WebContainer> implements List<E> {

    private List<WebElement> webElements;
    private List<E> webContainers;
    private Class<E> containerClass;

    public WebContainerList(List<WebElement> webElements, Class<E> containerClass) {
        this.webElements = webElements;
        this.containerClass = containerClass;    
    }

    public void createWebContainers() {
        webContainers = new ArrayList<E>();
        for (WebElement webElement : webElements) {
            try {
                // Create web container and add to list
                Constructor<E>constructor = containerClass.getConstructor(WebElement.class);
                E container = constructor.newInstance(webElement);
                webContainers.add(container);
            } catch (Exception ex) {
                Logger.getLogger(WebContainerList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public int size() {
        createWebContainers();
        return webContainers.size();
    }

    @Override
    public boolean isEmpty() {
        createWebContainers();
        return webContainers.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        createWebContainers();
        return webContainers.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        createWebContainers();
        return webContainers.iterator();
    }

    @Override
    public Object[] toArray() {
        createWebContainers();
        return webContainers.toArray();
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        createWebContainers();
        return webContainers.toArray(ts);
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException("This collection is imnmutable and therefore this method cannot be called.");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("This collection is imnmutable and therefore this method cannot be called.");
    }

    @Override
    public boolean containsAll(Collection<?> clctn) {
        createWebContainers();
        return webContainers.containsAll(clctn);
    }

    @Override
    public boolean addAll(Collection<? extends E> clctn) {
        throw new UnsupportedOperationException("This collection is imnmutable and therefore this method cannot be called.");
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> clctn) {
        throw new UnsupportedOperationException("This collection is imnmutable and therefore this method cannot be called.");
    }

    @Override
    public boolean removeAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("This collection is imnmutable and therefore this method cannot be called.");
    }

    @Override
    public boolean retainAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("This collection is imnmutable and therefore this method cannot be called.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("This collection is imnmutable and therefore this method cannot be called.");
    }

    @Override
    public E get(int i) {
        createWebContainers();
        return webContainers.get(i);
    }

    @Override
    public E set(int i, E e) {
        throw new UnsupportedOperationException("This collection is imnmutable and therefore this method cannot be called.");
    }

    @Override
    public void add(int i, E e) {
        throw new UnsupportedOperationException("This collection is imnmutable and therefore this method cannot be called.");
    }

    @Override
    public E remove(int i) {
        throw new UnsupportedOperationException("This collection is imnmutable and therefore this method cannot be called.");
    }

    @Override
    public int indexOf(Object o) {
        createWebContainers();
        return webContainers.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        createWebContainers();
        return webContainers.lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        createWebContainers();
        return webContainers.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        createWebContainers();
        return webContainers.listIterator();
    }

    @Override
    public List<E> subList(int i, int i1) {
        createWebContainers();
        return webContainers.subList(i, i1);
    }
}
