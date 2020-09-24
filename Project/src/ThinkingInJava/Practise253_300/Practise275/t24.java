package ThinkingInJava.Practise253_300.Practise275;

class constructorEx extends Exception {}

class elseEx extends Exception {}

class temp {
    boolean state = false;

    public temp() throws constructorEx {
        //throw new constructorEx();
        state = true;
    }

    public void off() {
        state = false;
    }
}

public class t24 {
    public static void main(String[] args) throws constructorEx {
        try {
            temp t = new temp();
            try {
                System.out.println("构造成功 ");
                // throw new elseEx();
            } catch (Exception e) {
                System.out.println("构造成功后捕获异常 ");
            } finally {
                System.out.println("构造成功后，使用完用finally清理");
                t.off();
            }
        } catch (Exception e) {
            System.out.println("构造失败，从构造器中抛出异常，此时不用清理");
        }
    }
}
