package vikings.com.bekko.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

/**
 * Created by roberto.fedota on 16/11/2017.
 */

@IgnoreExtraProperties
public class Evenement implements Serializable {
    private String datasetid;

    private String record_timestamp;

    private String recordid;

    private Geometry geometry;

    private Fields fields;

    public String getDatasetid ()
    {
        return datasetid;
    }

    public void setDatasetid (String datasetid)
    {
        this.datasetid = datasetid;
    }

    public String getRecord_timestamp ()
    {
        return record_timestamp;
    }

    public void setRecord_timestamp (String record_timestamp)
    {
        this.record_timestamp = record_timestamp;
    }

    public String getRecordid ()
    {
        return recordid;
    }

    public void setRecordid (String recordid)
    {
        this.recordid = recordid;
    }

    public Geometry getGeometry ()
    {
        return geometry;
    }

    public void setGeometry (Geometry geometry)
    {
        this.geometry = geometry;
    }

    public Fields getFields ()
    {
        return fields;
    }

    public void setFields (Fields fields)
    {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "datasetid='" + datasetid + '\'' +
                ", record_timestamp='" + record_timestamp + '\'' +
                ", recordid='" + recordid + '\'' +
                ", geometry=" + geometry +
                ", fields=" + fields +
                '}';
    }
}
