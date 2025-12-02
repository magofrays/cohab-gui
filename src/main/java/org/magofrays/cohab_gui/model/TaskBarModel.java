package org.magofrays.cohab_gui.model;

import javax.swing.DefaultListModel;

import org.magofrays.cohab_gui.model.dto.task.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskBarModel extends DefaultListModel<Task>{
 	@Override
    public Task getElementAt(int index) {
        return super.getElementAt(index); 
    }
    
    @Override
    public int getSize() {
        return super.getSize(); 
    }
    
    public void addMember(Task task) {
        super.addElement(task); 
    }

}
