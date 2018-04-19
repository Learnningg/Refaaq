package com.alatheer.refaaq;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ProgramsAdapter extends RecyclerView.Adapter<ProgramsAdapter.RecyclerViewHolder> {

private static int NUM_OF_ITEMS;
private static String[]programsNames;
private static String[]programsRate;
private static int [] programsImg;
private static Context mContext;



  public ProgramsAdapter(Context mContext, String[]programsNames, String[]programsRate, int[]programsImg) {
        NUM_OF_ITEMS = programsNames.length;
        this.programsNames = programsNames;
        this.programsRate= programsRate;
        this.programsImg= programsImg;
        this.mContext = mContext;

   }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.programes_item,parent,false);
        RecyclerViewHolder holder = new RecyclerViewHolder(v);

        return holder;
    }

    private final static int FADE_DURATION = 1000;
    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        holder.bind(position);
        setScaleAnimation(holder.itemView);
        holder.itemProgramImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext,programsRate[position], Toast.LENGTH_SHORT).show();

            }
        });
    }
            // functions to Animate Recycler Items
    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }

    private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }

    @Override
    public int getItemCount() {
        if (NUM_OF_ITEMS >0){
            return NUM_OF_ITEMS;
        }else
        return 0;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        Typeface t1;
        TextView itemProgramName,itemProgramRate;
        ImageView itemProgramImage;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            itemProgramImage = (ImageView) itemView.findViewById(R.id.item_program_image);
            itemProgramName = (TextView) itemView.findViewById(R.id.item_program_name);

            itemProgramRate = (TextView) itemView.findViewById(R.id.item_program_rate);
            itemProgramName.setTypeface(t1);
          //  t1= Typeface.createFromAsset(getAssets(),"d.ttf");
        }

        public void bind(int itemPosition){
            itemProgramRate.setText(programsRate[itemPosition]);
            itemProgramName.setText(programsNames[itemPosition]);

            itemProgramImage.setImageResource(programsImg[itemPosition]);

        }

    }

}
