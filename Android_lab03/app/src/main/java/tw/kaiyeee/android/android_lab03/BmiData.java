package tw.kaiyeee.android.android_lab03;

public class BmiData {

    // MEMBER ATTRIBUTES
    private double height;
    private double weight;
    private double bmi;
    private String suggestion;

    // CONSTRUCTOR
    public BmiData() { }
    public BmiData(double h, double w, double b, String s) {
        height = h;
        weight = w;
        bmi = b;
        suggestion = s;
    }

    // GETS
    public double getHeight() { return height; }
    public double getWeight() { return weight; }
    public double getBmi() { return bmi; }
    public String getSuggestion() { return suggestion; }

    public String getBmiDataString() {
        String str = height + "\t"
                + weight + "\t"
                + bmi + "\t"
                + suggestion.replaceAll("\n","") + "\n";
        return str;
    }

    // SETS
    public void setHeight(Double h) { height = h; }
    public void setWeight(Double w) { weight = w; }
    public void setBmi(Double b) { bmi = b; }
    public void setSuggestion(String  s) { suggestion = s; }
}
