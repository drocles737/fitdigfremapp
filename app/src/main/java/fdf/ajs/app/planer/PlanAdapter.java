package fdf.ajs.app.planer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import fdf.ajs.app.R;


public class PlanAdapter extends BaseAdapter {
    List<PlanRequest> plans;
    Context context;

    public PlanAdapter(List<PlanRequest> plans, Context context){
        this.plans = plans;
        this.context = context;
    }

    @Override
    public int getCount() {
        return plans.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_item, null);


        PlanRequest plan = plans.get(position);
        //find ud af om row_item skal have en textbox eller ligende for at virke
        TextView txtnavn = view.findViewById(R.id.textViewPlaner);
        //TextView txtnavn2 = view.findViewById(R.id.textViewPlaner1);
        txtnavn.setText(plan.getNavn());
        return view;
    }
}
