package il.ac.shenkar.recycleviewlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Benda on 11/24/15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Information> data = Collections.emptyList();

    public MyAdapter()
    {
        super();
        data = new ArrayList<Information>();
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row, parent, false);

        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Information info = data.get(position);
        holder.title.setText(info.title);
        holder.subTitle.setText(info.subTitle);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addTask(Information task) {
        data.add(task);
        notifyDataSetChanged();
    }

    public void  removeTask(int position) {
        data.remove(position);
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView title, subTitle;
        private ImageView image;


        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            subTitle = (TextView) itemView.findViewById(R.id.subTitle);
            image = (ImageView) itemView.findViewById(R.id.delBut);
            image.setImageResource(R.drawable.delete);

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    removeTask(pos);
                }
            });
        }
    }
}
