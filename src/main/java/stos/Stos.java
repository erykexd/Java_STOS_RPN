package stos;

import java.util.Arrays;

public class Stos {

    private double[] stos = new double[1];
    private int iterator = 0;

    public void push(double value) {
        this.stos[iterator] = value;
        this.iterator += 1;
        this.stos = Arrays.copyOf(this.stos, iterator + 1);
    }

    public double pop() {
        double pom = this.stos[iterator - 1];
        this.stos[iterator - 1] = '\n';
        if (this.iterator > 0)
            this.iterator -= 1;
        return pom;
    }

    public double peek() {
        double pom = this.stos[iterator - 1];
        return pom;
    }
}
