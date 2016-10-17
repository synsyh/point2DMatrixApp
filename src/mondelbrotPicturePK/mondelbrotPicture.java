package mondelbrotPicturePK;

import Ynu.Sei.cpLibrary.BASIC.cpDraw;
import Ynu.Sei.cpLibrary.DS.kdTree.KeyDuplicateException;
import Ynu.Sei.cpLibrary.DS.kdTree.KeySizeException;
import Ynu.Sei.cpLibrary.Math.Complex;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;
import point2DMatrixPK.mondelbrotPoint;
import point2DMatrixPK.point2DMatrix;

import java.util.ArrayList;

/**
 * Created by lj on 2016/4/19.
 */
public class mondelbrotPicture extends point2DMatrix<mondelbrotPoint> {
    private Point2D mouse = new Point2D(-0.5, 0);
    private double sizeX = 2.0;
    private double sizeY = 2.0;
    private int NUM = 200;

    public mondelbrotPicture(Point2D cp, double W, double H, int M, Class cl) throws KeySizeException, KeyDuplicateException,
            InstantiationException, IllegalAccessException {
        super(cp, W, H, M, cl);
        for (mondelbrotPoint mp : this.points()) {
            mp.mTest(255);
        }
    }

    public void draw() {
        ArrayList<mondelbrotPoint> ps = super.points();
        for (mondelbrotPoint mp : super.points()) {
            if (mp.getmTestNum() == 255) {
                cpDraw.FilledCircle(mp.x(), mp.y(), sizeX / 300);
            }
        }

    }

}
