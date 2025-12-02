package org.magofrays.cohab_gui.model;

import javax.swing.DefaultListModel;

import org.magofrays.cohab_gui.model.dto.member.Member;
import org.springframework.stereotype.Component;


@Component
public class MemberBarModel extends DefaultListModel<Member> {

	 	@Override
	    public Member getElementAt(int index) {
	        return super.getElementAt(index); 
	    }
	    
	    @Override
	    public int getSize() {
	        return super.getSize(); 
	    }
	    
	    public void addMember(Member member) {
	        super.addElement(member); 
	    }

	
	
}
