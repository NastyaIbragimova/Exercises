package space.pandawithflowers.exercises;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayAdapter extends ArrayAdapter<ListItemClass> {

    private LayoutInflater inflater;
    private List<ListItemClass> listItem = new ArrayList<>();
    private Context context;


    public CustomArrayAdapter(@NonNull Context context, int resource, List<ListItemClass> listItem, LayoutInflater inflater) {
        super(context, resource, listItem);
        this.inflater = inflater;
        this.listItem = listItem;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        ListItemClass listItemMain = listItem.get(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_view_item, null, false);
            viewHolder.pic = convertView.findViewById(R.id.iv_pic);
            viewHolder.headline = convertView.findViewById(R.id.tv_headline);
            viewHolder.desc = convertView.findViewById(R.id.tv_desc);
            convertView.setTag(viewHolder);
        } else viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.headline.setText(listItemMain.getHeadline());
        viewHolder.desc.setText(listItemMain.getDesc());
        viewHolder.pic.setImageResource(listItemMain.getPic());
        return convertView;
    }

    private class ViewHolder {
        TextView headline;
        TextView desc;
        ImageView pic;
    }
}
