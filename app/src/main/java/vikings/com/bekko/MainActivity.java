package vikings.com.bekko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import vikings.com.bekko.activity.DetailsActivity;
import vikings.com.bekko.adapters.EventAdapter;
import vikings.com.bekko.listener.RecyclerClickListener;
import vikings.com.bekko.listener.RecyclerTouchListener;
import vikings.com.bekko.models.Evenement;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "MainActivity";
    private DatabaseReference mPostReference;
    private List<Evenement> allEvenements = new ArrayList<>();
    private List<Evenement> toDayEvenements = new ArrayList<>();

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private RecyclerView recyclerView;
    private EventAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPostReference = FirebaseDatabase.getInstance().getReference().child("records");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new EventAdapter(getApplicationContext(), toDayEvenements);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("evenement", toDayEvenements.get(position));
                intent.putExtras(b);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));



        Query lastEvents = mPostReference.orderByChild("tags").limitToLast(1000);
        allEvenements = new ArrayList<>();
        lastEvents.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d(LOG_TAG, "List DataSnapshot:"+dataSnapshot.getChildrenCount());
                for (DataSnapshot noteSnapshot: dataSnapshot.getChildren()){
                    Evenement evenement = noteSnapshot.getValue(Evenement.class);
                    allEvenements.add(evenement);
                }
                Log.d(LOG_TAG, "List ALL Evenements:"+allEvenements.size());
                getEventsStartToday();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(LOG_TAG, databaseError.getMessage());
            }
        });
    }

    //Start Today
    private void getEventsStartToday() {
        try {
            toDayEvenements = new ArrayList<>();
            for (Evenement ev : allEvenements) {
                Date evDateStart = dateFormat.parse(ev.getFields().getDate_start());
                Date evDateEnd = dateFormat.parse(ev.getFields().getDate_end());
                Calendar calDateStart = Calendar.getInstance();
                calDateStart.setTime(evDateStart);
                Calendar calDateEnd = Calendar.getInstance();
                calDateEnd.setTime(evDateEnd);
                Calendar calToday = Calendar.getInstance();
                if (calDateStart.get(Calendar.YEAR) == calToday.get(Calendar.YEAR) && calDateStart.get(Calendar.MONTH) == calToday.get(Calendar.MONTH)  && calDateEnd.get(Calendar.DAY_OF_MONTH) <= calToday.get(Calendar.DAY_OF_MONTH)) {
                    toDayEvenements.add(ev);
                }
            }
        } catch (ParseException e) {
            Log.e(LOG_TAG, e.getMessage());
        }
        mAdapter.refreshList(toDayEvenements);
        Log.d(LOG_TAG, "List Start Today Evenements:"+toDayEvenements.size());
    }

    private void getEventsToday() {
        try {
            Date today = new Date();
            toDayEvenements = new ArrayList<>();
            for (Evenement ev : allEvenements) {
                Date evDateStart = dateFormat.parse(ev.getFields().getDate_start());
                Date evDateEnd = dateFormat.parse(ev.getFields().getDate_end());
                if (evDateStart.before(today) && evDateEnd.after(today) || evDateStart.equals(today) || (ev.getFields().getImage() != null && !ev.getFields().getImage().isEmpty())) {
                    toDayEvenements.add(ev);
                }
            }
        } catch (ParseException e) {
            Log.e(LOG_TAG, e.getMessage());
        }
        mAdapter.refreshList(toDayEvenements);
        Log.d(LOG_TAG, "List Today Evenements:"+toDayEvenements.size());
    }
}
