package ThinkingInJava.p10_innerclass.Practise192;

class temp {
    private String st;

    public temp(String s) {
        this.st = s;
    }

    @Override
    public String toString() {
        return "temp + " + st;
    }
}

interface Selector {
    boolean end();

    Object current();

    void next();
}

public class t2 {
    private Object[] items;
    private int next = 0;

    public t2(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        public boolean end() { return i == items.length; }

        public Object current() { return items[i]; }

        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        t2 sequence = new t2(10);
        for (int i = 0; i < 10; i++)
            sequence.add(new temp(Integer.toString(i)));
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        temp w1 = new temp("Peace");
        temp w2 = new temp("Love");
        temp w3 = new temp("Easter");
        t2 message = new t2(3);
        message.add(w1);
        message.add(w2);
        message.add(w3);
        Selector sel = message.selector();
        while (!sel.end()) {
            System.out.print(sel.current() + " ");
            sel.next();
        }

    }
}