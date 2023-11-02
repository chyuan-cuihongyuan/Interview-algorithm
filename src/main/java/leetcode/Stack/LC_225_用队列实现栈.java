package leetcode.Stack;

/**
 * @author cuihongyuan
 * @Date: 2023/11/1 0001  - 14:44
 * @Description: leetcode.Stack
 * @version: 1.0
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * 注意：
 * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 *
 * 示例：
 * 输入：
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 2, 2, false]
 * 解释：
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // 返回 2
 * myStack.pop(); // 返回 2
 * myStack.empty(); // 返回 False
 *
 * 提示：
 * 1 <= x <= 9
 * 最多调用100 次 push、pop、top 和 empty
 * 每次调用 pop 和 top 都保证栈不为空
 *
 * 进阶：你能否仅用一个队列来实现栈。
 */
public class LC_225_用队列实现栈 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.top();
        myStack.pop();
        myStack.empty();
        MyStack2 myStack2 = new MyStack2();
        myStack2.push(1);
        myStack2.push(2);
        myStack2.top();
        myStack2.pop();
        myStack2.empty();
        MyStack3 myStack3 = new MyStack3();
        myStack3.push(1);
        myStack3.push(2);
        myStack3.top();
        myStack3.pop();
        myStack3.empty();
        MyStack4 myStack4 = new MyStack4();
        myStack4.push(1);
        myStack4.push(2);
        myStack4.top();
        myStack4.pop();
        myStack4.empty();
        MyStack5 myStack5 = new MyStack5();
        myStack5.push(1);
        myStack5.push(2);
        myStack5.top();
        myStack5.pop();
        myStack5.empty();
        MyStack6 myStack6 = new MyStack6();
        myStack6.push(1);
        myStack6.push(2);
        myStack6.top();
        myStack6.pop();
        myStack6.empty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

class MyStack {

    Queue<Integer> queue1; // 和栈中保持一样元素的队列
    Queue<Integer> queue2; // 辅助队列

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue2.offer(x); // 先放在辅助队列中
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Queue<Integer> queueTemp;
        queueTemp = queue1;
        queue1 = queue2;
        queue2 = queueTemp; // 最后交换queue1和queue2，将元素都放到queue1中
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll(); // 因为queue1中的元素和栈中的保持一致，所以这个和下面两个的操作只看queue1即可
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

class MyStack2{
    //q1作为主要的队列，其元素排列顺序和出栈顺序相同
    Queue<Integer> q1 = new ArrayDeque<>();
    //q2仅作为临时放置
    Queue<Integer> q2 = new ArrayDeque<>();

    public MyStack2() {

    }
    //在加入元素时先将q1中的元素依次出栈压入q2，然后将新加入的元素压入q1，再将q2中的元素依次出栈压入q1
    public void push(int x) {
        while (q1.size() > 0) {
            q2.add(q1.poll());
        }
        q1.add(x);
        while (q2.size() > 0) {
            q1.add(q2.poll());
        }
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

class MyStack3 {
    // Deque 接口继承了 Queue 接口
    // 所以 Queue 中的 add、poll、peek等效于 Deque 中的 addLast、pollFirst、peekFirst
    Deque<Integer> que1; // 和栈中保持一样元素的队列
    Deque<Integer> que2; // 辅助队列
    /** Initialize your data structure here. */
    public MyStack3() {
        que1 = new ArrayDeque<>();
        que2 = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        que1.addLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = que1.size();
        size--;
        // 将 que1 导入 que2 ，但留下最后一个值
        while (size-- > 0) {
            que2.addLast(que1.peekFirst());
            que1.pollFirst();
        }

        int res = que1.pollFirst();
        // 将 que2 对象的引用赋给了 que1 ，此时 que1，que2 指向同一个队列
        que1 = que2;
        // 如果直接操作 que2，que1 也会受到影响，所以为 que2 分配一个新的空间
        que2 = new ArrayDeque<>();
        return res;
    }

    /** Get the top element. */
    public int top() {
        return que1.peekLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return que1.isEmpty();
    }
}

class MyStack4 {
    // Deque 接口继承了 Queue 接口
    // 所以 Queue 中的 add、poll、peek等效于 Deque 中的 addLast、pollFirst、peekFirst
    Deque<Integer> que1;
    /** Initialize your data structure here. */
    public MyStack4() {
        que1 = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        que1.addLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = que1.size();
        size--;
        // 将 que1 导入 que2 ，但留下最后一个值
        while (size-- > 0) {
            que1.addLast(que1.peekFirst());
            que1.pollFirst();
        }

        int res = que1.pollFirst();
        return res;
    }

    /** Get the top element. */
    public int top() {
        return que1.peekLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return que1.isEmpty();
    }
}

class MyStack5 {

    Queue<Integer> queue;

    public MyStack5() {
        queue = new LinkedList<>();
    }

    //每 offer 一个数（A）进来，都重新排列，把这个数（A）放到队列的队首
    public void push(int x) {
        queue.offer(x);
        int size = queue.size();
        //移动除了 A 的其它数
        while (size-- > 1) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

class MyStack6 {
    Queue<Integer> queue;

    public MyStack6() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        rePosition();
        return queue.poll();
    }

    public int top() {
        rePosition();
        int result = queue.poll();
        queue.add(result);
        return result;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public void rePosition(){
        int size = queue.size();
        size--;
        while(size-->0) {
            queue.add(queue.poll());
        }
    }
}
