package data_structure;

import java.util.Stack;    
    
public class BinTree {    
    private char data;    
    private BinTree lchild;    
    private BinTree rchild;    
    
    public BinTree(char c) {    
        data = c;    
    }    
    
    // 先序遍历递归     
    public static void preOrder(BinTree t) {    
        if (t == null) {    
            return;    
        }    
        System.out.print(t.data);    
        preOrder(t.lchild);    
        preOrder(t.rchild);    
    }    
    
    // 中序遍历递归     
    public static void InOrder(BinTree t) {    
        if (t == null) {    
            return;    
        }    
        InOrder(t.lchild);    
        System.out.print(t.data);    
        InOrder(t.rchild);    
    }    
    
    // 后序遍历递归     
    public static void PostOrder(BinTree t) {    
        if (t == null) {    
            return;    
        }    
        PostOrder(t.lchild);    
        PostOrder(t.rchild);    
        System.out.print(t.data);    
    }    
    
    // 先序遍历非递归     
    public static void preOrder2(BinTree t) {    
        Stack<BinTree> s = new Stack<BinTree>();    
        while (t != null || !s.empty()) {    
            while (t != null) {    
                System.out.print(t.data);    //打印结点
                s.push(t);    
                t = t.lchild;    
            }                                //左孩子结点压栈直至某个结点没有左孩子
            if (!s.empty()) {    
                t = s.pop();                 //最左左孩子结点出栈，指针指向出栈结点右孩子
                t = t.rchild;       
            }    
        }    
    }    
    
    // 中序遍历非递归     
    public static void InOrder2(BinTree t) {    
        Stack<BinTree> s = new Stack<BinTree>();    
        while (t != null || !s.empty()) {    
            while (t != null) {    
                s.push(t);    
                t = t.lchild;    
            }                                //左孩子结点压栈直至某个结点没有左孩子
            if (!s.empty()) {    
                t = s.pop();                 //最左左孩子结点出栈
                System.out.print(t.data);    //打印结点
                t = t.rchild;                //指针指向出栈结点右孩子
            }    
        }    
    }    
    
    // 后序遍历非递归     
    public static void PostOrder2(BinTree t) {    
        Stack<BinTree> s = new Stack<BinTree>();    
        Stack<Integer> s2 = new Stack<Integer>();    
        Integer i = new Integer(1);    
        while (t != null || !s.empty()) {    
            while (t != null) {    
                s.push(t);    
                s2.push(new Integer(0));    
                t = t.lchild;    
            }    
            while (!s.empty() && s2.peek().equals(i)) {    
                s2.pop();    
                System.out.print(s.pop().data);    
            }    
    
            if (!s.empty()) {    
                s2.pop();    
                s2.push(new Integer(1));    
                t = s.peek();    
                t = t.rchild;    
            }    
        }    
    }    
    
    public static void main(String[] args) {    
        BinTree b1 = new BinTree('a');    
        BinTree b2 = new BinTree('b');    
        BinTree b3 = new BinTree('c');    
        BinTree b4 = new BinTree('d');    
        BinTree b5 = new BinTree('e');    
    
        /**  
         *         a   
         *        / \  
         *       b   c  
         *      / \  
         *     d   e  
         */    
        b1.lchild = b2;    
        b1.rchild = b3;    
        b2.lchild = b4;    
        b2.rchild = b5;    
        
        System.out.print("先序遍历递归:");  
        BinTree.preOrder(b1);    
        System.out.println();  
        System.out.print("先序遍历非递归:");    
        BinTree.preOrder2(b1);    
        System.out.println();  
        System.out.print("中序遍历递归:");    
        BinTree.InOrder(b1);    
        System.out.println();   
        System.out.print("中序遍历非递归:");   
        BinTree.InOrder2(b1);    
        System.out.println();   
        System.out.print("后序遍历递归:");   
        BinTree.PostOrder(b1);    
        System.out.println();   
        System.out.print("后序遍历非递归:");   
        BinTree.PostOrder2(b1);    
    }    
}    