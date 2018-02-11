package tw.kaiyeee.android.android_lab03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BmiDataListAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<BmiData> bmi_data_list;

    public BmiDataListAdapter(Context context, ArrayList<BmiData> BmiDataList) {
        inflater = LayoutInflater.from(context);
        this.bmi_data_list = BmiDataList;
    }

    @Override
    public int getCount() {
        return bmi_data_list.size();
    }

    @Override
    public Object getItem(int i) {
        return bmi_data_list.get(i);
    }

    @Override
    public long getItemId(int position) {
        return bmi_data_list.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vHolder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.bmi_data_row, null);
            vHolder = new ViewHolder(
                    (TextView) convertView.findViewById(R.id.heightTV),
                    (TextView) convertView.findViewById(R.id.weightTV),
                    (TextView) convertView.findViewById(R.id.bmiTV),
                    (TextView) convertView.findViewById(R.id.suggestionTV)
            );
            convertView.setTag(vHolder);
        } else {
            vHolder = (ViewHolder) convertView.getTag();
        }

        final BmiData data = (BmiData)getItem(position);
        vHolder.txtHeight.setText(String.valueOf(data.getHeight()));
        vHolder.txtWeight.setText(String.valueOf(data.getWeight()));
        vHolder.txtBmi.setText(String.valueOf(data.getBmi()));
        vHolder.txtSuggestion.setText(String.valueOf(data.getSuggestion()));

        return convertView;
    }

    private class ViewHolder {
        TextView txtHeight;
        TextView txtWeight;
        TextView txtBmi;
        TextView txtSuggestion;

        public ViewHolder(TextView txtHeight, TextView txtWeight, TextView txtBmi, TextView txtSuggestion) {
            this.txtHeight = txtHeight;
            this.txtWeight = txtWeight;
            this.txtBmi = txtBmi;
            this.txtSuggestion = txtSuggestion;
        }

    }
}
