package tw.kaiyeee.android.android_lab03;

public class BmiData {

    // MEMBER ATTRIBUTES
    private double height;
    private double weight;
    private double bmi;
    private String suggestion;

    // CONSTRUCTOR
    public BmiData(double h, double w, double b, String s) {
        height = h;
        weight = w;
        bmi = b;
        suggestion = s;
    }

    // GETS
    public double getHeight() { return height; }
    public double getWeight() { return weight; }
    public double bmi() { return bmi; }
    public String getSuggestion() { return suggestion; }

    public String getBmiDataString() {
        String str = height + "\t"
                + weight + "\t"
                + bmi + "\t"
                + suggestion + "\n";
        return str;
    }

    // SETS
    public void setHeight(Double height) { this.height = height; }
    public void setWeight(Double weight) { this.height = weight; }
    public void setBmi(Double Bmi) { this.bmi = bmi; }
    public void setSuggestion(String  suggestion) { this.suggestion = suggestion; }
}
