package tw.kaiyeee.android.android_lab01;

/**
 * Created by KaiYi.C on 30/01/2018.
 */

public class BMI {
    private double bmi;
    private double[] bmiLevel = {18.5, 24, 27, 30, 35};
    private String[] Suggestions = {
        "「體重過輕」，需要多運動，均衡飲食，\n以增加體能，維持健康！",
        "「健康體重」，要繼續保持喔！",
        "「體重過重」，要小心囉，\n趕快力行健康體重管理吧！",
        "「輕度肥胖」，\n需要立刻力行健康體重管理喔！",
        "「中度肥胖」，\n需要立刻力行健康體重管理喔！",
        "「重度肥胖」，\n需要立刻力行健康體重管理喔！"
    };

    public void setBmi(double height, double weight) {
        double h = height / 100.0;
        double w = weight;
        bmi = w / (h*h);
    }

    public double getBmi() { return bmi; }
    public String getSuggestion() {
        if(bmi < bmiLevel[0]) {
            return Suggestions[0];
        } else if(bmi >= bmiLevel[0] && bmi < bmiLevel[1]) {
            return Suggestions[1];
        } else if(bmi >= bmiLevel[1] && bmi < bmiLevel[2]) {
            return Suggestions[2];
        } else if(bmi >= bmiLevel[2] && bmi < bmiLevel[3]) {
            return Suggestions[3];
        } else if(bmi >= bmiLevel[3] && bmi < bmiLevel[4]) {
            return Suggestions[4];
        } else if(bmi >= bmiLevel[4]) {
            return Suggestions[5];
        } else return "錯誤";
    }
}
