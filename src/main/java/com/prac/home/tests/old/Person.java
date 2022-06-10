package com.prac.home.tests.old;

public class Person {


    public void go(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("foo");
            }
        };
        Thread t    = new Thread(r);
        t.start();
        t.start();
    }
    public static void main(String[] args) {

        new Person().go();

        /*com.prac.home.tests.old.B b = new com.prac.home.tests.old.B("test");*/

       /* List<List<String>> l= Arrays.asList(Arrays.asList("Sachin","Tarun"), Arrays.asList("Jack","Micjael")
        , Arrays.asList("Sam","Gopal", "Ankit"), Arrays.asList("Anil"));
        List<String> l1 = l.stream().flatMap(x-> x.stream()).filter(x-> x.startsWith("com.prac.home.tests.old.A")).collect(Collectors.toList());
        System.out.println(l1)*/;

        /*com.prac.home.tests.old.MyAdd<Number> m = new com.prac.home.tests.old.MyAdd<>();
        m.add(new Integer(123));
        m.add(new Double(12.23));*/
    }

}

class A{
    A(){
        this("1");
    }

    A(String a){
        System.out.println("const a(string)");
    }
}

class B extends A{
    B(String s){
        System.out.println("const b(string)");
    }
}
class MyAdd<T>{

    public void add(T t){
        System.out.println(t);
    }
}