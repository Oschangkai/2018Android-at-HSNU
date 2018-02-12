package tw.kaiyeee.android.android_lab03;

import android.Manifest;
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
        askForPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        askForPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
    }

}