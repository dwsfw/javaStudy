package com.tlb;

public class Test4 {

    static class Like2 implements ILike{

        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like=new Like2();
        like.lambda();

        class Like3 implements ILike{

            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }
        like=new Like3();
        like.lambda();

        like=new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        };
        like.lambda();

        like=()->{
            System.out.println("i like lambda5");
        };
        like.lambda();
    }
}
//定义一个函数式接口
interface ILike{
    void lambda();
}
class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}