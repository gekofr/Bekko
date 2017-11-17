package vikings.com.bekko.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by roberto.fedota on 16/11/2017.
 */

@IgnoreExtraProperties
public class Fields implements Serializable {
    private String region;

    private String uid;

    private String department;

    private String date_start;

    private String link;

    private String image;

    private String timetable;

    private String placename;

    private String lang;

    private String city;

    private String space_time_info;

    private String tags;

    private String date_end;

    private String title;

    private String updated_at;

    private String free_text;

    private ArrayList<Double> latlon;

    private String address;

    private String description;

    private String image_thumb;

    public String getRegion ()
    {
        return region;
    }

    public void setRegion (String region)
    {
        this.region = region;
    }

    public String getUid ()
    {
        return uid;
    }

    public void setUid (String uid)
    {
        this.uid = uid;
    }

    public String getDepartment ()
    {
        return department;
    }

    public void setDepartment (String department)
    {
        this.department = department;
    }

    public String getDate_start ()
    {
        return date_start;
    }

    public void setDate_start (String date_start)
    {
        this.date_start = date_start;
    }

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getTimetable ()
    {
        return timetable;
    }

    public void setTimetable (String timetable)
    {
        this.timetable = timetable;
    }

    public String getPlacename ()
    {
        return placename;
    }

    public void setPlacename (String placename)
    {
        this.placename = placename;
    }

    public String getLang ()
    {
        return lang;
    }

    public void setLang (String lang)
    {
        this.lang = lang;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    public String getSpace_time_info ()
    {
        return space_time_info;
    }

    public void setSpace_time_info (String space_time_info)
    {
        this.space_time_info = space_time_info;
    }

    public String getDate_end ()
    {
        return date_end;
    }

    public void setDate_end (String date_end)
    {
        this.date_end = date_end;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getFree_text ()
    {
        return free_text;
    }

    public void setFree_text (String free_text)
    {
        this.free_text = free_text;
    }

    public ArrayList<Double> getLatlon ()
    {
        return latlon;
    }

    public void setLatlon (ArrayList<Double> latlon)
    {
        this.latlon = latlon;
    }

    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getImage_thumb ()
    {
        return image_thumb;
    }

    public void setImage_thumb (String image_thumb)
    {
        this.image_thumb = image_thumb;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Fields{" +
                "region='" + region + '\'' +
                ", uid='" + uid + '\'' +
                ", department='" + department + '\'' +
                ", date_start='" + date_start + '\'' +
                ", link='" + link + '\'' +
                ", image='" + image + '\'' +
                ", timetable='" + timetable + '\'' +
                ", placename='" + placename + '\'' +
                ", lang='" + lang + '\'' +
                ", city='" + city + '\'' +
                ", space_time_info='" + space_time_info + '\'' +
                ", tags='" + tags + '\'' +
                ", date_end='" + date_end + '\'' +
                ", title='" + title + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", free_text='" + free_text + '\'' +
                ", latlon=" + latlon +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", image_thumb='" + image_thumb + '\'' +
                '}';
    }
}
