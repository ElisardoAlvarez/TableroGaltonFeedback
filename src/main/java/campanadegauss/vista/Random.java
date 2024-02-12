package main.java.campanadegauss.vista;

public class Random {
    private final java.util.Random random = new java.util.Random();

    public double nextGaussian() {
        return random.nextGaussian();
    }

    public int nextInt(int i) {
        return random.nextInt(i);
    }
}

