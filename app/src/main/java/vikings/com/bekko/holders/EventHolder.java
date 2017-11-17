package vikings.com.bekko.holders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import vikings.com.bekko.R;

/**
 * Created by roberto.fedota on 16/11/2017.
 */

public class EventHolder extends RecyclerView.ViewHolder {

    public CardView cardView;
    public ImageView image_view;
    public TextView tag;
    public TextView title;
    public TextView dateStart;
    public TextView dateEnd;

    public EventHolder(View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.card_view);
        title = itemView.findViewById(R.id.title);
        dateStart = itemView.findViewById(R.id.dateStart);
        dateEnd = itemView.findViewById(R.id.dateEnd);
        image_view = itemView.findViewById(R.id.image_view);
        tag = itemView.findViewById(R.id.tag);
    }
}
