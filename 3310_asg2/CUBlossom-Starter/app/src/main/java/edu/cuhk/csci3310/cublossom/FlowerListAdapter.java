package edu.cuhk.csci3310.cublossom;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.LinkedList;
import java.util.List;

public class FlowerListAdapter extends Adapter<FlowerListAdapter.FlowerViewHolder>  {
    private Context context;
    private LayoutInflater mInflater;

    private final LinkedList<String> mImagePathList;
    private final List<Flowers> flowers;

    class FlowerViewHolder extends RecyclerView.ViewHolder {

        ImageView flowerImageItemView, richnessImageItemView1, richnessImageItemView2, richnessImageItemView3;
        TextView nameTextView, wikiTextView;

        final FlowerListAdapter mAdapter;

        public FlowerViewHolder(final View itemView, FlowerListAdapter adapter) {
            super(itemView);
            context = itemView.getContext();
            flowerImageItemView = itemView.findViewById(R.id.image);
            nameTextView = itemView.findViewById(R.id.nameText);
            wikiTextView = itemView.findViewById(R.id.wikiText);
            richnessImageItemView1 = itemView.findViewById(R.id.richnessImageView1);
            richnessImageItemView2 = itemView.findViewById(R.id.richnessImageView2);
            richnessImageItemView3 = itemView.findViewById(R.id.richnessImageView3);
            this.mAdapter = adapter;

            // Event handling registration, page navigation goes here
            flowerImageItemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view){
                    Intent intent = new Intent(context, NewActivity.class);
                    String str1 = nameTextView.getText().toString();
                    String str2 = wikiTextView.getText().toString();
                    str2 = str2.substring(0,str2.indexOf(' ')).trim();
                    String str3 = "";
                    if(richnessImageItemView3.getVisibility() == View.VISIBLE){
                        str3 = "3";
                    }
                    else if(richnessImageItemView2.getVisibility() == View.INVISIBLE){
                        str3 = "1";
                    }
                    else {
                        str3 = "2";
                    }
                    String str4 = flowerImageItemView.getTag().toString();
                    String str5 = nameTextView.getTag().toString();
                    intent.putExtra("FName", str1);
                    intent.putExtra("FEntry", str2);
                    intent.putExtra("Abd", str3);
                    intent.putExtra("photo", str4);
                    intent.putExtra("pos", str5);
                    context.startActivity(intent);
                }
            });

            wikiTextView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    String entry = wikiTextView.getText().toString();
                    entry = entry.substring(0,entry.indexOf(' ')).trim();
                    String link = "https://en.wikipedia.org/wiki/"+entry;
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                    context.startActivity(browserIntent);
                }
            });

            // End of ViewHolder initialization
        }
    }


    public FlowerListAdapter(Context context,
                            LinkedList<String> imagePathList, List<Flowers> flowers) {
        mInflater = LayoutInflater.from(context);
        this.mImagePathList = imagePathList;
        this.flowers = flowers;
    }

    @NonNull
    @Override
    public FlowerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.imagelist_item, parent, false);
        return new FlowerViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull FlowerViewHolder holder, int position) {
        String mImagePath = mImagePathList.get(position);
        Uri uri = Uri.parse(mImagePath);
        // Update the following to display correct information based on the given position


        // Set up View items for this row (position), modify to show correct information read from the CSV
        holder.flowerImageItemView.setImageURI(uri);
        holder.flowerImageItemView.setTag(mImagePath);
        holder.nameTextView.setText(flowers.get(position + 1).getFlower_name());
        holder.nameTextView.setTag(position + 1);
        holder.wikiTextView.setText(flowers.get(position + 1).getGenus()+" @wikipedia");
        String a = flowers.get(position + 1).getRichness();
        if(a.equals("1")==true){
            holder.richnessImageItemView1.setVisibility(View.VISIBLE);
            holder.richnessImageItemView2.setVisibility(View.INVISIBLE);
            holder.richnessImageItemView3.setVisibility(View.INVISIBLE);
        }
        if(a.equals("2")==true){
            holder.richnessImageItemView1.setVisibility(View.VISIBLE);
            holder.richnessImageItemView2.setVisibility(View.VISIBLE);
            holder.richnessImageItemView3.setVisibility(View.INVISIBLE);
        }
        if(a.equals("3")==true){
            holder.richnessImageItemView1.setVisibility(View.VISIBLE);
            holder.richnessImageItemView2.setVisibility(View.VISIBLE);
            holder.richnessImageItemView3.setVisibility(View.VISIBLE);
        }

    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mImagePathList.size();
    }

}
