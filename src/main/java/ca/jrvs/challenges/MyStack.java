package main.java.ca.jrvs.challenges;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int top;

    public MyStack(){
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x){
        q1.add(x);
        top = x;
    }

    public int pop(){
        while (q1.size() > 1){
            top = q1.remove();
            q2.add(top);
        }
        int out = q1.remove();
        q1 = q2;
        q2 = new LinkedList<>();

        return out;
    }

    public int top(){
        return top;
    }

    public boolean empty(){
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        Queue<Integer> queue = new LinkedList<>();
        obj.push(1);
        obj.push(2);
        obj.top();

        obj.empty();

    }
}
