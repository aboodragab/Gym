
package com.gym.business;
import com.gym.dao.MemberDAO;
import com.gym.dao.PersonDAO;
import com.gym.model.Member;
import java.util.ArrayList;
public class MemberService {
    private PersonDAO personDao = new PersonDAO();
    private MemberDAO memberDao = new MemberDAO();
    
    public boolean registerNewMember(Member member) {
        int personID=personDao.AddNewPerson(member);
        if (personID == -1) {
            return false; 
        }
        member.setPersonId(personID);
        return memberDao.AddNewMember(member);
    }
    public ArrayList<Member> getAllMembers()
    {
        return memberDao.getAllMembers();
    }
    public boolean removeMember(int memberId, int personId)
    {
        boolean isMemberDeleted = memberDao.deleteMember(memberId);
        if(isMemberDeleted)
            return personDao.deletePerson(personId);
        else
            return false;
    }
    public boolean editMember(Member member)
    {
        boolean pUpdate = personDao.updatePerson(member);
        boolean mUpdate = memberDao.updateMember(member);
        
        return pUpdate && mUpdate;
    } 
    
}
