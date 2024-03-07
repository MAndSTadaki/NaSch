package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author tadaki
 */
public class Utils {

    /**
     * 整数（値が0からlimit-1）のでたらめな配列作成
     *
     * @param limit リスト要素の最大値-1
     * @param num 帰す要素の数
     * @return 結果の配列
     */
    public static int[] createRandomNumberArray(int limit, int num) {
        List<Integer> inputList = createIntegerList(limit);//入力リスト生成 
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());//出力リスト
        int count = 0;
        while (!inputList.isEmpty() && count < num) {
            int k = (int) (inputList.size() * Math.random());
            Integer kk = inputList.remove(k);
            list.add(kk);  count++;
        }
        //出力リストの配列化
        int out[] = new int[num];
        for (int i = 0; i < num; i++) {  out[i] = list.get(i);  }
        return out;
    }

    /**
     * 整数のでたらめなリスト作成
     *
     * @param limit リスト要素の最大値-1
     * @return
     */
    public static int[] createRandomNumberArray(int limit)
    {  return Utils.createRandomNumberArray(limit, limit);  }
    
    /**
     * 0 からlimit-1 までの整数が順に並んだリスト
     *
     * @param limit
     * @return
     */
    public static List<Integer> createIntegerList(int limit) {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < limit; i++) {  list.add(i);  }
        return list;
    }
    
}
