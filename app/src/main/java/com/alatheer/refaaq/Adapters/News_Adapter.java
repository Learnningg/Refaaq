package com.alatheer.refaaq.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alatheer.refaaq.R;


public class News_Adapter extends RecyclerView.Adapter<News_Adapter.Holder> {
    private static int NUM_OF_ITEMS;


    private static String[]titlee;
    private static int [] Img;
    Context mcontext;

    public News_Adapter(Context mcontext, String[] titlee, int[] Img) {
        NUM_OF_ITEMS = titlee.length;

        this.mcontext = mcontext;
        this.titlee=titlee;
        this.Img=Img;

    }

    @Override

    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.news_item,parent,false);
        Holder holder=new Holder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        holder.title.setText(titlee[position]);

        holder.img.setImageResource(Img[position]);

    }

    @Override
    public int getItemCount() {
        if (NUM_OF_ITEMS >0){
            return NUM_OF_ITEMS;
        }else
            return 0;
    }

    public class Holder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView img;
        public Holder(View itemView) {
            super(itemView);
            title=(TextView) itemView.findViewById(R.id.txt_title);
            img=(ImageView) itemView.findViewById(R.id.img_news);
        }


    }
}
