package com.tybxx.Chap8.Homework09;

public class Homework09 {
    public static void main(String[] args) {
        Point p = new LabeledPoint(1929, 230.07,"Black Thursday");
        System.out.println(p);

    }
}

class Point{
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

class LabeledPoint extends Point{
    String label;

    public LabeledPoint(double x, double y, String label) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "LabeledPoint{" +
                "label='" + label + "\'\t" +
                "x='" + getX() + "\'\t" +
                "y='" + getY() + "\'" +
                '}';
    }
}