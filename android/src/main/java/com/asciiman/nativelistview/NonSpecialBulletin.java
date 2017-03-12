package oley.tayfun.com.oleybulletintest;

import java.util.List;

/**
 * Created by typhoon on 12/03/2017.
 */

public class NonSpecialBulletin {

    private NonSpecialEventMetaData meta;
    private List<NonSpecialEvent> eventList;


    public NonSpecialEventMetaData getMeta() {
        return meta;
    }

    public void setMeta(NonSpecialEventMetaData meta) {
        this.meta = meta;
    }

    public List<NonSpecialEvent> getEventList() {
        return eventList;
    }

    public void setEventList(List<NonSpecialEvent> eventList) {
        this.eventList = eventList;
    }
}
