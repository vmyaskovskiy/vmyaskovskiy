package ru.job4j.lyambda;

import java.util.*;

public class ConverterIterator {

    public  Iterator<Integer> convert(Iterator<Iterator<Integer>> itOut) {

        return new Iterator<Integer>() {
            private Iterator<Integer> itIn = (new ArrayList<Integer>()).iterator();
            @Override
            public boolean hasNext() {
                if (itOut.hasNext())  {
                    if (itIn.hasNext()) {
                        return true;
                    }
                    itIn = itOut.next();
                }
               return itIn.hasNext();
            }
            @Override
            public Integer next() {
                if (hasNext()) {
                   return itIn.next();
                }
                throw new NoSuchElementException();
            }
        };
    }
}
