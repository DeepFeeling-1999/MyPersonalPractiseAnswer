package ThinkingInJava.Practise253_300.Practise271;

class temp1 extends Exception {
    @Override
    public String getMessage() {
        return "temp1 getMessage 666" + super.getMessage();
    }

   /* public String toString(){
        return "temp1 toString";
    }*/
}

class temp2 extends Exception {
    @Override
    public String getMessage() {
        return "temp2 getMessage" + super.getMessage();
    }

    public String toString() {
        return "temp2 toString";
    }
}

class temp3 extends Exception {
    @Override
    public String getMessage() {
        return "temp3 getMessage" + super.getMessage();
    }

    public String toString() {
        return "temp3 toString";
    }
}

class temp11 extends Exception {
    public temp11() throws temp1, temp2 {
        throw new temp1();
    }

    protected void tFun() throws temp1 {
        throw new temp1();
    }
}

class temp22 extends temp11 {
    public temp22() throws temp3, temp2, temp1 {
        //super();
        throw new temp3();
    }

    @Override
    public void tFun() throws temp1 {
        System.out.println("aaa");
    }
}

public class t20 {
    public static void main(String[] args) throws temp3, temp2, temp1 {
        try {
            temp22 t22 = new temp22();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
