import java.lang.annotation.*;

public class test01 {
    @myAnnotation(name = "12")
    public void m(){}
}
//表示我们的注解可以用在哪些地方
@Target(value = {ElementType.TYPE,ElementType.METHOD})
//表示我么你的注解在什么地方还有效
//runtime>class>sources
@Retention(value = RetentionPolicy.RUNTIME)
//表示是否将我们的注解生成在Javadoc中
//@Documented
@interface myAnnotation{
    //注解的参数 参数类型加参数名 default 默认参数
    String name() default "";
    int age() default 0;
    int id() default -1;//如果默认值为-1，代表不存在
    String[] schools() default {"绍兴文理"};
}
@Target(value = {ElementType.TYPE,ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@interface myAnnotation3{
    String value();
}
