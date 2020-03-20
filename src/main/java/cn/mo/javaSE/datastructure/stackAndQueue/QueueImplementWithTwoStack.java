package cn.mo.javaSE.datastructure.stackAndQueue;

import java.util.Stack;

/**
 * desc: 两个栈实现一个队列
 * @author mozhihang
 * date:2020/3/19 17:26
 */
public class QueueImplementWithTwoStack<T> {

    private Stack<T> stack1;

    private Stack<T> stack2;

    public void add(T data){
        if(stack1 == null){
            stack1 = new Stack<>();
        }
        stack1.push(data);
    }

    public T poll(){
        if(stack2 == null){
            stack2 = new Stack<>();
        }
        if(stack2.isEmpty()){
            if(stack1 == null || stack1.isEmpty()){
                throw new RuntimeException("无元素");
            }else{
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.pop();
    }

    public T peek(){
        if(stack2 == null){
            stack2 = new Stack<>();
        }
        if(stack2.isEmpty()){
            if(stack1 == null || stack1.isEmpty()){
                throw new RuntimeException("无元素");
            }else{
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.peek();
    }

    public static void main(String[] args) {

    }

}
