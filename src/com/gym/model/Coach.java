
package com.gym.model;


public class Coach extends Person{
    private int coachId;
    private int experienceYears;

    public Coach(int coachId, int experienceYears, int personId, int age, String name, String phone, String address) {
        super(personId, age, name, phone, address);
        this.coachId = coachId;
        this.experienceYears = experienceYears;
    }
    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }
    
}
