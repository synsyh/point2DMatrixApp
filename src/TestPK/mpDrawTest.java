package TestPK;

import Ynu.Sei.cpLibrary.BASIC.cpDraw;
import Ynu.Sei.cpLibrary.DS.kdTree.KeyDuplicateException;
import Ynu.Sei.cpLibrary.DS.kdTree.KeySizeException;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;
import mondelbrotPicturePK.mondelbrotPicture;
import point2DMatrixPK.mondelbrotPoint;

/**
 * Created by lj on 2016/4/19.
 */
public class mpDrawTest {
    public static void main(String[] args) throws KeySizeException, KeyDuplicateException,
            InstantiationException, IllegalAccessException {
        // TODO Auto-generated method stub
        cpDraw.setX(-10, 10, 0.1);
        cpDraw.setY(-10, 10, 0.1);
        cpDraw.drawStyle2();
        mondelbrotPicture mpic = new mondelbrotPicture(new Point2D(-0.5, 0), 2, 2, 100, mondelbrotPoint.class);
        mpic.draw();
        mpic.translate(new Point2D(-5, -5));
        mpic.draw();
        mpic.translate(new Point2D(7, 6));
        mpic.draw();

    }

}
