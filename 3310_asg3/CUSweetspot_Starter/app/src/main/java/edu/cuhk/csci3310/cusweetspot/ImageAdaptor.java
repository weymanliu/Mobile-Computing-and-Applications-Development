//Liu Kam Nam 1155109652
package edu.cuhk.csci3310.cusweetspot;

import android.content.Context;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;

/**
 * ImageAdaptor for the GridView
 */
public class ImageAdaptor extends BaseAdapter {
    Context context;
    int[] dissertImageIds;

    private ImageViewHolder holder;

    ImageAdaptor(Context c, int[] imageIds) {
        context = c;
        dissertImageIds = imageIds;
    }

    /**
     * Inner View Holder class
     */
    private class ImageViewHolder  {
        int position;
        ImageView mImageView;

        public ImageViewHolder(@NonNull View itemView) {

            mImageView = (ImageView) itemView.findViewById(R.id.image);

            // Set up listener to handle context menu creation
            itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                /**
                 * Callback during creation of context menu
                 * @param menu
                 * @param v
                 * @param menuInfo
                 */
                @Override
                public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                    position = getPosition();
                    String food = String.valueOf(position);

                    // Add a new menu item and set up the on--ItemClick handler as well
                    menu.add("Show Location").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            // TODO: remove the following toast and show map
                            Intent intent = new Intent(context, MainActivity2.class);
                            intent.putExtra("choice","0");
                            intent.putExtra("food",food);
                            context.startActivity(intent);

                            return true;
                        }
                    });
                    // Add another menu item and set up the on--ItemClick handler
                    menu.add("Show Route").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            // TODO: remove the following toast and show route
                            Intent intent = new Intent(context, MainActivity2.class);
                            intent.putExtra("choice","1");
                            intent.putExtra("food",food);
                            context.startActivity(intent);

                            return true;
                        }
                    });
                }
            });
        }

        // getter and setter for the layout position
        void setPosition(int pos) { position = pos;}
        int getPosition() { return position;}
    }

    @Override
    public int getCount() {
        return dissertImageIds.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // ViewHolder Pattern is implemented via getTag/setTag of convertView
        ImageViewHolder holder;
        if(convertView == null) {
            convertView = (LayoutInflater.from(context)).inflate(R.layout.grid_item_layout, null);
            holder = new ImageViewHolder(convertView);
            holder.setPosition(position);
            convertView.setTag(holder);
        } else {
            holder = (ImageViewHolder) convertView.getTag();
        }

        holder.mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.mImageView.setImageResource(dissertImageIds[position]);

        return convertView;
    }


}
