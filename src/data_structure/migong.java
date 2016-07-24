package data_structure;

import java.util.Stack;


class Seat{
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
class Pos{
	Seat s;
	int direct = 0;	
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
	boolean IsPass(int maze[][]){
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
				maze[curpos.s.x][curpos.s.y] = 0;
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
					while(e.direct == 4 && !S.isEmpty()){
						System.out.println("(" + e.s.x + "," + e.s.y + ")");
//						System.out.println("经过点" + "(" + e.s.x + "," + e.s.y + ")" + "的路不能通过");
						e = (Pos) S.pop();
					}///while
					if(e.direct < 4){
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
				        {0,0,0,0,0,0,0,0,0,0}};
		Seat start = new Seat(1,1);
		Seat end = new Seat(8,8);
		migong m = new migong();
		m.MazePath(maze, start, end);
	}

}
