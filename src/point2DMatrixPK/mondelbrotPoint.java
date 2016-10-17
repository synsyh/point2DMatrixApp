package point2DMatrixPK;

import Ynu.Sei.cpLibrary.Math.Complex;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

/**
 * Created by lj on 2016/4/19.
 */
public class mondelbrotPoint extends Point2D {
    private int mTestNum = 0;

    public mondelbrotPoint() {
        this(0, 0);
    }

    public mondelbrotPoint(double x, double y) {
        this(x, y, 255);
    }

    public mondelbrotPoint(double x, double y, int maxTestNum) {
        super(x, y);
        this.mTestNum = new Complex(x, y).I_Mandelbrot(maxTestNum);
    }

    public int getmTestNum() {
        return mTestNum;
    }

    ;

    public void mTest(int maxTestNum) {
        this.mTestNum = new Complex(super.x(), super.y()).I_Mandelbrot(maxTestNum);
    }
}
