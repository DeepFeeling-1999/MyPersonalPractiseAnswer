package ThinkingInJava.Practise354_400.Practise357;

public class t5<T> {
    private class myNode {
        T item;
        myNode next;

        public myNode() {
            item = null;
            next = null;
        }

        public myNode(T item, myNode next) {
            this.next = next;
            this.item = item;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private myNode top = new myNode();

    public void push(T item) {
        top = new myNode(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }

        return result;
    }

    public static void main(String[] args) {
        t5<String> myList = new t5<>();

        for (int i = 0; i < 3; i++) {
            myList.push(Integer.toString(i));
        }
        String tempS;

        while ((tempS = myList.pop()) != null) {
            System.out.println(tempS);
        }
    }


}
