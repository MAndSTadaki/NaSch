package observation;

import java.awt.geom.Point2D;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 * 流量を求めるクラス
 *
 * @author tadaki
 */
public class Flow extends Observable {

    /**
     * セルの数を与えて初期化するコンストラクタ
     *
     * @param sysSize
     * @param vmax
     * @param p
     */
    public Flow(int sysSize, int vmax, double p) {
        super(sysSize, vmax, p);
    }

    /**
     * 流量を求める
     *
     * @param numCar 車両数
     * @return 平均速度
     */
    @Override
    public double calcValue(int numCar) {
        double v = sys.evalAverageSpeed();
        return v * numCar / sysSize;//流量を返す
    }

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws IOException {
        int n = 100;
        int vmax = 5;
        double accel = 0.2;
        double dp = 0.005;
        int tmax = 100;
        Flow sys = new Flow(n, vmax, accel);
        List<Point2D.Double> points = sys.calcValues(dp, tmax);
        try (PrintStream out = new PrintStream(new FileOutputStream("fundamental.txt"))) {
            for (Point2D.Double p : points) {
                if (!Double.isNaN(p.y) && p.y >= 0) {
                    out.println(p.x + " " + p.y);
                }
            }
        }
    }

}
