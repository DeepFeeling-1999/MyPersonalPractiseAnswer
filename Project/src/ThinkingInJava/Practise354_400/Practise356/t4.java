package ThinkingInJava.Practise354_400.Practise356;

import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.List;

interface mySelector {
    boolean end();

    Object current();

    void next();
}

public class t4<E> {
    private List<E> myList = new ArrayList<>();
    private int next = 0;

    public t4(List<E> myList) {
        this.myList = myList;
    }

    public void add(E e) {
        myList.add(e);
    }

    private class mySequenceSelector implements mySelector {
        private int i = 0;

        public boolean end() {
            return i == myList.size();
        }

        public Object current() {
            return myList.get(i);
        }

        public void next() {
            if (i < myList.size()) {
                i++;
            }
        }
    }

    public mySequenceSelector getSelector() {
        return new mySequenceSelector();
    }

    public static void main(String[] args) {
        List<String> tList = new ArrayList<>();
        t4<String> temp4 = new t4<>(tList);


        for (int i = 0; i < 3; i++) {
            tList.add(Integer.toString(i));
        }
        mySelector tSelector = temp4.getSelector();

        while (!tSelector.end()) {
            System.out.println(tSelector.current() + " ");
            tSelector.next();
        }
    }
}
