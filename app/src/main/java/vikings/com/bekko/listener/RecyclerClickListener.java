package vikings.com.bekko.listener;

import android.view.View;

/**
 * Created by roberto.fedota on 17/11/2017.
 */

public interface RecyclerClickListener {

    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
