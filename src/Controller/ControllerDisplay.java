/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI1.GUI;
import GUI1.ListCourse;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author lehun
 */
public class ControllerDisplay {
    
    GUI1.GUI gui = new GUI();
    GUI1.ListCourse view = new ListCourse(gui, true);
    
    public ControllerDisplay(ArrayList<Course.CourseManager> list) {
        if (list.isEmpty()) {
            view.txtArea.append("Is Empty");
        } else {
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                view.getTxtArea().append(list.get(i).toString() + "\n");
            }
        }
        view.setVisible(true);
        view.setResizable(false);
    }
    
}
