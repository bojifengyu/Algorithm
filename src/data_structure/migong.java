package data_structure;

import java.util.Stack;

//迷宫问题
class Seat{              //坐标类，有两个成员变量，x、y代表轴坐标
	int x;
	int y;
	public Seat(int xx, int yy){
		x = xx;
		y = yy;		
	}
	boolean equals(Seat s){
		if(s == null || !(s instanceof Seat)){
			return false;
		}
		if(x == s.x && y == s.y){
			return true;
		}
		return false;
	}
}
class Pos{            //迷宫位置类，有成员变量坐标s，方向direct，step可有可无（记录所走步数）
	Seat s;
	int direct = 0;	  //direct=1，2，3，4分别代表上下左右四个方向（1-下，2-右，3-上，4-左）。
	int step = 0;
	Pos(){
	}
	Pos(Seat ss){
		s = ss;
	}
	Pos NextPos(Pos p, int x){
		if(x == 1){
			Seat s = new Seat(p.s.x + 1, p.s.y);
			p = new Pos(s);
		}
		else if(x == 2){
			Seat s = new Seat(p.s.x, p.s.y + 1);
			p = new Pos(s);
		}
		else if(x == 3){
			Seat s = new Seat(p.s.x - 1, p.s.y);
			p = new Pos(s);
		}
		else if(x == 4){
			Seat s = new Seat(p.s.x, p.s.y - 1);
			p = new Pos(s);
		}
		return p;
	}
	boolean IsPass(int maze[][]){      //判断当前位置是否走过
		if(this.direct == 0 && maze[this.s.x][this.s.y] == 1){
			return true;
		}
		return false;
	}
	boolean equals(Pos p){
		if(p == null || !(p instanceof Pos)){
			return false;
		}
		if(this.s.x == p.s.x && this.s.y == p.s.y){
			return true;
		}
		return false;
	}
}
public class migong {
	
	boolean MazePath(int maze[][], Seat start, Seat end){
		Stack<Pos> S = new Stack<Pos>();
		Pos curpos = new Pos(start); 
		Pos e = new Pos();
		do{
			if(curpos.IsPass(maze)){
				System.out.println("(" + curpos.s.x + "," + curpos.s.y + ")");
				curpos.step++;
				curpos.direct++;
				maze[curpos.s.x][curpos.s.y] = 0;    //标记已经过的位置
				S.push(curpos);
				Pos endpos = new Pos(end);
				if(curpos.equals(endpos)){
					return true;
				}
				curpos = curpos.NextPos(curpos, 1);
			}// if
			else{
				if(!S.isEmpty()){
					e = (Pos) S.pop();
					while(e.direct == 4 && !S.isEmpty()){   //该位置四个方向均不能通过
						System.out.println("(" + e.s.x + "," + e.s.y + ")");
//						System.out.println("经过点" + "(" + e.s.x + "," + e.s.y + ")" + "的路不能通过");
						e = (Pos) S.pop();
					}///while
					if(e.direct < 4){                       //寻找其它出口
						Pos temp = (Pos)S.peek();
						e.direct++;
						S.push(e);
						curpos = e.NextPos(e, e.direct);
						if(curpos.s.equals(temp.s)){
							curpos.direct = ((Pos)S.peek()).direct;
						}
					}//if
				}//if
			}//else
		}while(!S.isEmpty());
		return false;
	}//MazePath
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int maze[][] = {{0,0,0,0,0,0,0,0,0,0},
				        {0,1,1,0,1,1,1,0,1,0},
				        {0,1,1,0,1,1,1,0,1,0},
				        {0,1,1,1,1,0,0,1,1,0},
				        {0,1,0,0,0,1,1,1,1,0},
				        {0,1,1,1,0,1,1,1,1,0},
				        {0,1,0,1,1,1,0,1,1,0},
				        {0,1,0,0,0,1,0,0,1,0},
				        {0,0,1,1,1,1,1,1,1,0},
				        {0,0,0,0,0,0,0,0,0,0}};   //0代表不能通过，1代表可以通过
		Seat start = new Seat(1,1);
		Seat end = new Seat(8,8);
		migong m = new migong();
		m.MazePath(maze, start, end);
	}

}
