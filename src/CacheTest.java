import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;


public class CacheTest {


    //测试部分
    public static void main(String[] args) {

        Apple apple = new Apple();
        //lambda表达式的方法体就是Consumer接口的抽象方法具体实现（accept方法）,x就是它唯一的一个抽象方法的参数，
        // Consumer接口的唯一抽象方法是不需要返回值的，所以这个lambda是没有返回值的
        Consumer<Apple> consumer = x->{
            x.setName("niho");
            
        };
        consumer.accept(apple);
        System.out.println(apple.getName());

        Predicate<Object> predicate = p->p.equals("nihao");
        System.out.println(predicate.test(1));

        Function function = f ->
            f.toString();
        System.out.println(function.apply(1));

        //Supplier的唯一抽象接口方法（get方法）是没有入参的但是有返回值的，所以lambda表达式必须是（），必须有返回值
        Supplier<Apple> supplier =  () -> {
            Apple apple7 = new Apple();
            apple7.setName("好吃");
            return apple7;
        };
        System.out.println(supplier.get().getName());


        List<Person> lisiList = new ArrayList<>();
        Consumer <Person> consumer1  =  x -> {
            if (x.name.equals("lisi")){
                lisiList.add(x);
            }
        }; //lambda表达式的方法体就是Consumer接口的抽象方法具体实现（accept方法）
        Stream.of(
                new Person(21,"zhangsan"),
                new Person(22,"lisi"),
                new Person(23,"wangwu"),
                new Person(24,"wangwu"),
                new Person(23,"lisi"),
                new Person(26,"lisi"),
                new Person(26,"zhangsan")
        ).forEach(consumer1);
        System.out.println(lisiList);
    }

}