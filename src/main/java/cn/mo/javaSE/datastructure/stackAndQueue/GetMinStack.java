package cn.mo.javaSE.datastructure.stackAndQueue;

import java.util.Stack;

/**
 * desc: 设计一个有 getMin 功能的栈
 * 注意点：pop 和 peek 方法记得要判断下是否有元素
 * @author mozhihang
 * date:2020/3/19 17:07
 */
public class GetMinStack<T extends Comparable<T>> {

    private Stack<T> stack;

    private Stack<T> minStack;

    public void push(T data){
        if(stack == null){
            stack = new Stack<>();
            stack.push(data);
            minStack = new Stack<>();
            minStack.push(data);
        }else{
            stack.push(data);
            if(data.compareTo(minStack.peek()) < 0){
                minStack.push(data);
            }else{
                minStack.push(minStack.peek());
            }
        }
    }

    public T pop(){
        if(minStack.isEmpty()){
            throw new RuntimeException("无元素！");
        }
        minStack.pop();
        return stack.pop();
    }

    public T getMin(){
        if(minStack.isEmpty()){
            throw new RuntimeException("无元素！");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        GetMinStackTest test1 = new GetMinStackTest();
        test1.setAge(1);
        GetMinStackTest test3 = new GetMinStackTest();
        test3.setAge(3);
        GetMinStackTest test2 = new GetMinStackTest();
        test2.setAge(2);
        GetMinStack<GetMinStackTest> stack = new GetMinStack<>();
        stack.push(test2);
        System.out.println(stack.getMin().getAge());
        stack.push(test3);
        System.out.println(stack.getMin().getAge());
        stack.push(test1);
        System.out.println(stack.getMin().getAge());
        stack.pop();
        System.out.println(stack.getMin().getAge());
    }

    public static class GetMinStackTest implements Comparable<GetMinStackTest>{

        private int age;

        public int getAge(){
            return this.age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(GetMinStackTest getMinStackTest) {
            if(this.age > getMinStackTest.getAge()){
                return 1;
            }else if(this.age == getMinStackTest.getAge()){
                return 0;
            }else{
                return -1;
            }
        }
    }

}

