package tw.kaiyeee.android.android_lab03;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BmiDataListActivity extends AppCompatActivity {

    ListView lsv;
    private BmiDataListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_data_list);
        this.setTitle("已儲存的資料");

        adapter = new BmiDataListAdapter(BmiDataListActivity.this, getBmiDataList());
        lsv = findViewById(R.id.list);
        lsv.setEmptyView(findViewById(R.id.nodataTV));
        lsv.setAdapter(adapter);
    }

    private ArrayList<BmiData> getBmiDataList() {
        ArrayList<BmiData> bmiDataList = new ArrayList<>();
        String fileName = "BMI_Data.txt";
        String extPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String filePath = extPath + File.separator + fileName;

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                BmiData bmi = new BmiData();
                bmi.setHeight(Double.parseDouble(data[0]));
                bmi.setWeight(Double.parseDouble(data[1]));
                bmi.setBmi(Double.parseDouble(data[2]));
                bmi.setSuggestion(data[3]);
                bmiDataList.add(bmi);
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return bmiDataList;
    }
}
