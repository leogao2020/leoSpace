package com.amos.think.event;

import lombok.Getter;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
public abstract class DomainEvent implements Serializable {
    public  String eventId;
    public   Date createTime;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public DomainEvent() {
        this.eventId = UUID.randomUUID().toString();
        this.createTime = new Date();
    }
}
