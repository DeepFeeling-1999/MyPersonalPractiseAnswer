package Chapter5_Extends.Abstract_Person;

/**
 *  用abstract声明为抽象类
 *  有抽象方法的类本身必须声明为抽象类
 */
public abstract class PersonAbstract {


    public abstract String getDescription();
    //抽象函数，留给子类实现

    private String name;
    public PersonAbstract(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
}
