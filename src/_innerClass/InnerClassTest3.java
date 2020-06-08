package _innerClass;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/5
 */
public class InnerClassTest3 {
    public static void main(String[] args) {
        double[] doubles = new double[10];
        for (int i = 0; i<10 ; ++i){
            doubles[i] = 20*Math.random();
        }
        ArrayAlg.Pair pair = ArrayAlg.maxMin(doubles);

        System.out.println("--------------------------------");
        System.out.println(pair.getMax());
        System.out.println(pair.getMin());
    }

}

class ArrayAlg{

    public static class Pair {
        private double max;
        private double min;

        Pair(double max, double min) {
            this.max = max;
            this.min = min;
        }

        public double getMax() {
            return max;
        }

        public double getMin() {
            return min;
        }

    }

    public static Pair maxMin(double[] doubles){
        double max = doubles[0];
        double min = doubles[0];

        for (double v : doubles){
            System.out.println(v);
            if (min > v) min = v;
            if (max < v) max = v;
        }

        return new Pair(max,min);
    }
}
