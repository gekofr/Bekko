package vikings.com.bekko.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import vikings.com.bekko.R;
import vikings.com.bekko.holders.EventHolder;
import vikings.com.bekko.models.Evenement;

/**
 * Created by roberto.fedota on 17/11/2017.
 */

public class EventAdapter extends RecyclerView.Adapter<EventHolder> {

    private List<Evenement> evenementList;
    private Context context;

    public EventAdapter(Context context, List<Evenement> evenementList) {
        this.evenementList = evenementList;
        this.context = context;
    }

    public void refreshList(List<Evenement> evenementList){
        this.evenementList = evenementList;
        notifyDataSetChanged();
    }

    @Override
    public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.evenement_row, parent, false);
        return new EventHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EventHolder holder, int position) {
        Evenement ev = evenementList.get(position);
        Picasso.with(context).load(ev.getFields().getImage()).into(holder.image_view);
        holder.tag.setText(ev.getFields().getDepartment());
        holder.title.setText(ev.getFields().getTitle());
        holder.dateStart.setText("Date Start: " + getDateCorrect(ev.getFields().getDate_start()));
        holder.dateEnd.setText("Date End: " + getDateCorrect(ev.getFields().getDate_end()));
    }

    @Override
    public int getItemCount() {
        return evenementList.size();
    }

    private DateFormat dateIn = new SimpleDateFormat("yyyy-MM-dd");
    private DateFormat dateOut = new SimpleDateFormat("dd-MM-yyyy");
    private String getDateCorrect(String date){
        try {
            Date dateInput = dateIn.parse(date);
            return dateOut.format(dateInput);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "...";
    }

}
