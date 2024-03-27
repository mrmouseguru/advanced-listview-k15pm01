package com.cgm.advancedlistviewk15pm01;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<Country> listData;

    public CustomListAdapter(Context context, List<Country> listData) {
        this.context = context;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return this.listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.list_item_layout, null);
            holder.flagView = convertView.findViewById(R.id.imageView_flag);
            holder.countryNameView = convertView.findViewById(R.id.textView_countryName);
            holder.populationView = convertView.findViewById(R.id.textView_population);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        //holder
        Country country = listData.get(position);
        holder.countryNameView.setText(country.getCountryName());
        holder.populationView.setText("Population: " + country.getPopulation());
        int imageId = getMipmapResIdByName(country.getFlagName());
        holder.flagView.setImageResource(imageId);
        return convertView;
    }


    static class ViewHolder {
        ImageView flagView;
        TextView countryNameView;
        TextView populationView;
    }
                                   //vn, us, ru
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        //Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }
}
