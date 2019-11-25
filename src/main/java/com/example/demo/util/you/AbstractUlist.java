package com.example.demo.util.you;

import java.util.AbstractCollection;
import java.util.List;
import java.util.ListIterator;

/**
 * @Description
 * @Author youyi
 * @Date 2019/9/8 下午6:30
 **/
public abstract class AbstractUlist<E> extends AbstractCollection<E> implements List<E> {
    public int lastIndexOf(Object o){
        ListIterator<E> it = listIterator(size());
        if (o==null) {
            while (it.hasPrevious())
                if (it.previous()==null)
                    return it.nextIndex();
        } else {
            while (it.hasPrevious())
                if (o.equals(it.previous()))
                    return it.nextIndex();
        }
        return -1;
    }
}
