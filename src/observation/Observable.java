package observation;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.NaSch;

/**
 *
 * @author tadaki
 */
public abstract class Observable {

    protected NaSch sys;
    protected int sysSize;
    protected int numSample = 10;

    public Observable(int sysSize, int vmax, double p) {
        sys = new NaSch(sysSize, 0, vmax, p);
        this.sysSize = sysSize;
    }

    /**
     * 平均量の取得
     *
     * @param numCar 車両数
     * @return 平均量
     */
    abstract public double calcValue(int numCar);

    /**
     * 初期化して緩和
     *
     * @param numCar 車両数
     * @param tmax 緩和させる時間
     */
    protected void initializeAndRelax(int numCar, int tmax) {
        sys.setNumCar(numCar);
        sys.randomInitialize();
        //緩和
        for (int t = 0; t < tmax; t++) {
            sys.update();
        }
    }

    public void setNumSample(int numSample) {
        this.numSample = numSample;
    }

    /**
     * 平均量の取得
     *
     * @param dp 密度の間隔
     * @param tmax 平均を行う時間
     * @return 密度に対する平均量のリスト
     */
    public List<Point2D.Double> calcValues(double dp, int tmax) {
        List<Point2D.Double> pList = Collections.synchronizedList(new ArrayList<>());
        int k = (int) (1. / dp);
        pList.add(new Point2D.Double(0., 0.));
        for (int i = 1; i < k; i++) {
            double p = i * dp;//初期密度
            int numCar = (int) (sysSize * p);
            for (int j = 0; j < numSample; j++) {
                initializeAndRelax(numCar, tmax);
                double value = calcValue(numCar);//平均量
                p = (double) numCar / sysSize;//実際の密度を再計算
                pList.add(new Point2D.Double(p, value));
            }
        }
        pList.add(new Point2D.Double(1., 0.));
        return pList;
    }
}
