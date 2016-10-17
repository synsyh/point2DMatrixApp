package point2DMatrixPK;

import Ynu.Sei.cpLibrary.BASIC.cpDraw;
import Ynu.Sei.cpLibrary.BASIC.cpRandom;
import Ynu.Sei.cpLibrary.DS.kdTree.KDTree;
import Ynu.Sei.cpLibrary.DS.kdTree.KeyDuplicateException;
import Ynu.Sei.cpLibrary.DS.kdTree.KeySizeException;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class point2DMatrix<T extends Point2D> {
    private KDTree<T> kd = new KDTree<T>(2);
    private ArrayList<T> cps = new ArrayList<T>();
    private Point2D lbp = new Point2D(0, 0);
    private double W = 1.0;
    private double H = 1.0;
    private int M = 10;
    private int N = 10;

    public point2DMatrix(Class<T> cl) throws KeySizeException,
            KeyDuplicateException, InstantiationException, IllegalAccessException {
        this(new Point2D(0, 0), 1.0, 1.0, 10, 10, cl);
    }

    public point2DMatrix(Point2D cp, double W, double H, int M, Class<T> cl)
            throws KeySizeException, KeyDuplicateException, InstantiationException, IllegalAccessException {
        this(new Point2D(cp.x() - W / 2, cp.y() - H / 2), W, H, M, M, cl);

    }

    public point2DMatrix(Point2D lbp, double W, double H, int M, int N, Class<T> cl)
            throws KeySizeException, KeyDuplicateException, IllegalAccessException, InstantiationException {
        this.lbp = lbp;
        this.W = W;
        this.H = H;
        this.M = M;
        this.N = N;
        double deltaW = W / N;
        double deltaH = H / M;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                double center_x = lbp.x() + c * deltaW + deltaW / 2;
                double center_y = lbp.y() + r * deltaH + deltaH / 2;
                T p = cl.newInstance();
                p.setx(center_x);
                p.sety(center_y);
                double key[] = {center_x, center_y};
                kd.insert(key, p);
                cps.add(p);
            }
        }
    }

    // return all points
    public ArrayList<T> points() {
        return cps;
    }

    // return the point which coordinates are r,c
    public T point(int r, int c) {
        return cps.get(N * r + c);
    }

    public ArrayList<T> get_Nearest_k_Points(Point2D p, int k)
            throws KeySizeException, IllegalArgumentException,
            KeyDuplicateException {
        double find_key[] = {p.x(), p.y()};
        ArrayList<T> results = new ArrayList<T>();
        List<T> nps = kd.nearest(find_key, k);
        for (int i = 0; i < nps.size(); i++) {
            results.add(nps.get(i));
        }
        return results;
    }

    /*return the nearest point among the matrix pointed by p*/
    public T pointByLocation(T p) {
        int r, c;
        c = (int) ((p.x() - this.lbp.x()) / this.deltaW());
        r = (int) ((p.y() - this.lbp.y()) / this.deltaH());
        //鼠标点出了矩阵范围的情况，取边缘的点
        if (p.x() >= this.lbp.x() + W)
            c = N - 1;
        if (p.y() >= this.lbp.y() + H)
            r = M - 1;
        return cps.get(r * N + c);
    }

    public int M() {
        return this.M;
    }

    public int N() {
        return this.N;
    }

    public double W() {
        return this.W;
    }

    public double H() {
        return this.H;
    }

    public double deltaW() {
        return this.W / this.N;
    }

    public double deltaH() {
        return H / M;
    }

    public Point2D centerPoint() {
        return new Point2D(lbp.x() + W / 2, lbp.y() + H / 2);
    }

    ;

    public void translate(Point2D newCp) {
        Point2D currentCp = centerPoint();
        double deltaX = newCp.x() - currentCp.x();
        double deltaY = newCp.y() - currentCp.y();
        for (T p : cps) {
            p.setx(p.x() + deltaX);
            p.sety(p.y() + deltaY);
        }
    }

    public void rotate(double theta) {
    }


}

