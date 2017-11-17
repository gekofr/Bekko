package vikings.com.bekko.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import vikings.com.bekko.R;
import vikings.com.bekko.models.Evenement;

public class DetailsActivity extends AppCompatActivity {
    private static final String LOG_TAG = "DetailsActivity";
    Evenement ev;

    private ImageView imageView;
    private TextView title;
    private TextView placename;
    private TextView spaceTimeInfo;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView = findViewById(R.id.image_view);
        title = findViewById(R.id.title);
        placename = findViewById(R.id.placename);
        spaceTimeInfo = findViewById(R.id.space_time_info);
        description = findViewById(R.id.description);

        Bundle b = getIntent().getExtras();
        if(b != null)
            ev = (Evenement) b.getSerializable("evenement");

        if(ev != null)
            loadPage();
    }

    private void loadPage() {
        Picasso.with(this).load(ev.getFields().getImage()).into(imageView);
        title.setText(ev.getFields().getTitle());
        placename.setText(ev.getFields().getPlacename());
        spaceTimeInfo.setText(ev.getFields().getSpace_time_info());
        description.setText(ev.getFields().getFree_text());
        Log.d(LOG_TAG,ev.toString());
    }

}
