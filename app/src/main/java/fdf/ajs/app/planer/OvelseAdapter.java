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

public class OvelseAdapter extends BaseAdapter {
        List<PlanRequest> ovelser;
        Context context;

        public OvelseAdapter(List<PlanRequest> ovelser, Context context){
                this.ovelser = ovelser;
                this.context = context;
        }

        @Override
        public int getCount() {
                return ovelser.size();
        }

        @Override
        public Object getItem(int position){
                return null;
        }

        @Override
        public long getItemId(int position){
                return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = LayoutInflater.from(context);
                View view = inflater.inflate(R.layout.ovelsedescription_view_adapter, null);
                PlanRequest ovelse = ovelser.get(position);

                TextView ovelsenavn = view.findViewById(R.id.OvelseNavn);
                TextView ovelsedesc = view.findViewById(R.id.OvelseDesc);
                TextView ovelserep = view.findViewById(R.id.OvelseRep);
                TextView ovelseset = view.findViewById(R.id.OvelseSet);

                ovelsenavn.setText(ovelse.getNavn()); //String
                ovelsedesc.setText(ovelse.getoevelseDesc()); //String
                ovelserep.setText(ovelse.getrepetitioner()); //Integer
                ovelseset.setText(ovelse.getsaet()); // Integer
                return view;
        }
}
