package data_structure;

class BTree{    
    private char data;    
    private BTree lchild;    
    private BTree rchild;    
    
    public BTree(char c) {    
        data = c;    
    }    
    public static BTree init() {  
    	BTree b1 = new BTree('a');    
        BTree b2 = new BTree('b');    
        BTree b3 = new BTree('c');    
        BTree b4 = new BTree('d');    
        BTree b5 = new BTree('e');    
    
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
        return b1;// root  
    }    
    /**      查找以node为根结点，值value结点对应的深度
     * @param node  根结点
     * @param value  结点的值
     * @param L  记录深度（初始化为0）
     * @return
     */
    public static int get_node_layer(BTree node,char value ,int L)
    {
    	int i=-1;
    	if(node != null) 
    	{
    		if(node.data == value)  
    			return L;
    		if((i = get_node_layer(node.lchild,value ,L+1)) != -1) //查左子树，如找到就返回
    			return i;    
    		if((i = get_node_layer(node.rchild,value ,L+1)) !=-1)//查右子树，如找到就返回
    			return i;    
      }
     return i;
    }
}
public class NodeLength{
    public static void main(String[] args) {    
    	BTree b1 = BTree.init(); 
    	System.out.print(BTree.get_node_layer(b1, 'e', 0));
    }    
	
}