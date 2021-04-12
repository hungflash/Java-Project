/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Course.CourseManager;
import GUI1.GUI;
import GUI1.SearchCode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lehun
 */
public class ControllSearch {

    GUI1.GUI gui = new GUI();
    GUI1.SearchCode view = new SearchCode(gui, true);

    public ControllSearch(ArrayList<Course.CourseManager> list) {
        search(list);
        view.setVisible(true);
        view.setResizable(false);
    }

    private boolean IsExits(ArrayList<Course.CourseManager> list, String code) {
        for (CourseManager courseManager : list) {
            if (courseManager.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    private void search(ArrayList<CourseManager> list) {
        view.getBtnSearch1().addActionListener((ActionEvent e) -> {
            String code = view.getTxtInputCode().getText();
            if (!code.isEmpty()) {
                if (IsExits(list, code)) {
                    for (CourseManager courseManager : list) {
                        view.getTxtDisplayNameCourse().setText(courseManager.getName());
                        view.getTxtDisplayCredit().setText(courseManager.getCredit() + "");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Not found");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please input");
            }
        });
    }
}
