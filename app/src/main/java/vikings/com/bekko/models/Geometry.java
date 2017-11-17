package vikings.com.bekko.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by roberto.fedota on 16/11/2017.
 */

@IgnoreExtraProperties
public class Geometry implements Serializable {
    private String type;

    private ArrayList<Double> coordinates;

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public ArrayList<Double> getCoordinates ()
    {
        return coordinates;
    }

    public void setCoordinates (ArrayList<Double> coordinates)
    {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Geometry{" +
                "type='" + type + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}
