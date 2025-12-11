
package com.gym.business;
import com.gym.dao.CoachDAO;
import com.gym.dao.PersonDAO;
import com.gym.model.Coach;
import java.util.ArrayList;

public class CoachService {
    private PersonDAO personDAO=new PersonDAO();
    private CoachDAO coachDAO=new CoachDAO();
    
    public boolean registerNewCoach(Coach c)
    {
        int personID=personDAO.AddNewPerson(c);
        if(personID==-1)
            return false;
        c.setPersonId(personID);
        return coachDAO.AddNewCoach(c);            
    }
    public ArrayList<Coach> getAllCoach()
    {
        return coachDAO.getAllCoachs();
    }
    public boolean removeCoach(int coachId, int personId)
    {
        boolean isCoachDeleted=coachDAO.deleteCoach(coachId);
        if(isCoachDeleted){
            return personDAO.deletePerson(personId);
        }
        return false;
    }
    public boolean editCoach(Coach c)
    {
         boolean pUpdate = personDAO.updatePerson(c);
         boolean cUpdate = coachDAO.updateCoach(c);
         
         return pUpdate&&cUpdate;
    }
}
