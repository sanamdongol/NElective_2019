package com.example.mylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    String[] title;
    int[] image;
    LayoutInflater inflater;
    Context context;
    ViewHolder vh;



    public CustomAdapter(Context c, String[] t, int[] img) {
        this.context = c;
        this.title = t;
        this.image = img;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        //It is used to return a view instance that represents a single row in ListView item.

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_row, null);
            vh = new ViewHolder();
            vh.imageView = convertView.findViewById(R.id.imageView);
            vh.textTitle = convertView.findViewById(R.id.tvTitle);
            convertView.setTag(vh);


        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.imageView.setImageResource(image[position]);
        vh.textTitle.setText(title[position]);

      /*  vh.imageView.setImageResource(image[position]);
        vh.textTitle.setText(title[position]);
*/
       /* if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_row, null);
            vh = new ViewHolder();
            vh.imageView = convertView.findViewById(R.id.imageView);
            vh.textTitle = convertView.findViewById(R.id.tvTitle);

            convertView.setTag(vh);
        } else {

            vh = (ViewHolder) convertView.getTag();
        }

        vh.imageView.setImageResource(image[position]);
        vh.textTitle.setText(title[position]);
*/

        return convertView;
    }

    public static class ViewHolder {
        public ImageView imageView;
        public TextView textTitle;
    }

    @Override
    public int getCount() {
        //It will return total number of rows count in listview
        return title.length;
    }

    @Override
    public Object getItem(int position) {
        //It is used to specify the object data of each row
        return position;
    }

    @Override
    public long getItemId(int position) {
        //It return the id of each row item
        return position;
    }
}
