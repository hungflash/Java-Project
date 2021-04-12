/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author lehun
 */
public class Controller {

    GUI1.GUI view = new GUI1.GUI();
    ArrayList<Course.CourseManager> list = new ArrayList<>();

    public Controller() {
        view.setVisible(true);
        view.setResizable(false);
        addCourse();
        DisplayCourse();
        SearchCourse();
        Exits();
    }

    private void SearchCourse() {
        view.getBtnSearch().addActionListener((e) -> {
            ControllSearch ser = new ControllSearch(list);
        });
    }

    private void DisplayCourse() {
        view.getBtnDisplay().addActionListener((e) -> {
            ControllerDisplay dis = new ControllerDisplay(list);
        });
    }

    private void addCourse() {

        view.getBtnAdd().addActionListener((ActionEvent e) -> {
            ControllAddcourse con = new ControllAddcourse(list);
        });
    }

    private void Exits() {
        view.getBtnExit().addActionListener((e) -> {
            System.exit(0);
        });
    }

}
