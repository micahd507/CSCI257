package Shape;


public class TestShapes {

	public static void main(String[] args) {
		Rect r = new Rect();
		r.makeVisible();
		r.slowMoveHorizontal(100);
		r.changeColor("magenta");
		r.changeSize(100, 200);
		
		Oval o = new Oval();
		o.makeVisible();
		o.slowMoveDiagonal(125, 1, 1);
		o.changeColor("green");
		o.changeSize(80, 160);
		
		Rect s = new Rect();
		s.makeVisible();
		s.slowMoveVertical(50);
		s.changeColor("red");
		s.changeSize(200, 100);
		
		Triangle t = new Triangle();
		t.makeVisible();
		t.slowMoveVertical(50);
		t.changeColor("blue");
		t.changeSize(200, 50);
		t.slowMoveDiagonal(100, 1, -1);
	}

}
