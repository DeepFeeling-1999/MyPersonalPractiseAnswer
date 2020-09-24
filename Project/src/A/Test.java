package A;

import SomeInstance.User;

public class Test{

    public static void main(String[] args) {
        String st= "012301230123";

        System.out.println(st.lastIndexOf("012",0));
        System.out.println(st.lastIndexOf("0123",7));

        System.out.println(st.lastIndexOf("llohe",2));

        System.out.println(st.lastIndexOf("llohe",3));

        System.out.println(st.lastIndexOf("llohe",4));


    }

}