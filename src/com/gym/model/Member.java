
package com.gym.model;

import java.sql.Date;

public class Member extends Person {
    private int memberId;
    private Date startDate;
    private Date endDate;
    private int coachId;

    public Member(int memberId, Date startDate, Date endDate, int coachId, int personId, String name, String phone, String address) {
        super(personId, name, phone, address);
        this.memberId = memberId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.coachId = coachId;
    }

    public Member(int memberId, Date startDate, Date endDate, int coachId) {
        this.memberId = memberId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.coachId = coachId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }
    
    
}
