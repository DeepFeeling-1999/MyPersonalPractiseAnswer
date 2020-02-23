package Test.interface_conflict;

interface test1{
    default void print(int n){
        System.out.println("test1 interface");
    }
}
interface test2 extends  test1{
    default void print(int n){
        System.out.println("test2 interface");
    }
}
