package tw.kaiyeee.android.android_lab02;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class IntroPage extends AppIntro {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntroFragment.newInstance("你好！", "這是一個多國語言的 BMI App",
                R.mipmap.ic_launcher, getResources().getColor(R.color.colorPrimary)));
        addSlide(AppIntroFragment.newInstance("第二頁", "這就只是第二頁",
                R.mipmap.ic_launcher, getResources().getColor(R.color.colorPrimaryDark)));

    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
    }

}