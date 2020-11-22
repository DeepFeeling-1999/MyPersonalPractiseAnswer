package ThinkingInJava.p15_Generics.Practise383;

interface myFactory<T> {
    T create(Integer i);
}

class temp231<T> {
    private T x;

    public <F extends myFactory<T>> temp231(F factory, Integer i) {
        x = factory.create(i);
    }

    @Override
    public String toString() {
        return " temp231 " + x + " " + x.getClass() + " ";
    }
}

class IntegerFactor implements myFactory<Integer> {
    public Integer create(Integer integer) {
        return Integer.valueOf(integer);
    }
}

public class t23 {
    public static void main(String[] args) {
        System.out.println(new temp231<>(new IntegerFactor(), 6));
    }
}


