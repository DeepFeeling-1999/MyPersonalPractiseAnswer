package CoreJava.Chapter7_Exception.Assert;

/**
 * 断言
 * 只用于开发和测试阶段，确定程序内部的错误位置
 * 只在确信某个属性符合要求，并且代码依赖于这个属性时使用
 * 在代码发布时，这些插入的检测将会自动被移走
 */
public class AssertTest {
    public static void main(String[] args) {
        int test1 = 0, test2 = 0;

        //第一种形式           assert 条件：表达式
        //表达式会被传入AssertionError的构造器中，并转换成一个消息字符串
        assert test2 == 1 : "test2 !=1";

        //第二种形式，如果条件为false，则抛出AssertionError异常
        assert test1 < 0;

    }
}
