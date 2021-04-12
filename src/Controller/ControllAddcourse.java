/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Course.CourseManager;
import GUI1.AddCourse1;
import GUI1.GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lehun
 */
public class ControllAddcourse {

    GUI gui = new GUI();
    AddCourse1 addCourse = new AddCourse1(gui, true);
//    public String check = "";

    public ControllAddcourse(ArrayList<Course.CourseManager> list) {
//        System.out.println(list.toString() + "");

        Add(list);
//        btnAdd(list);
        btnClear();
        System.out.println(list.toString() + "");
        addCourse.setVisible(true);
        addCourse.setResizable(false);
        addCourse.setLocationRelativeTo(null);
    }

    private boolean isDuplicate(ArrayList<Course.CourseManager> list, String code) {
        for (CourseManager courseManager : list) {
            if (courseManager.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkEmpty(String num) {
        return num.isEmpty();
    }

    public String vertifyinput() {
        String check = "";
        if (checkEmpty(addCourse.getTxtCode().getText())) {
            check += " Code ";
        }
        if (checkEmpty(addCourse.getTxtName().getText())) {
            check += " Name ";
        }
        return check;
    }

  public static String chuannHoa(String stt) {
        String result = "";
        String sentense[] = stt.split("\\s+");
        for (int i = 0; i < sentense.length; i++) {
            for (int j = 0; j < sentense[i].length(); j++) {
                if (Character.isLetter(sentense[i].charAt(j))) {
                    result += String.valueOf(sentense[i].charAt(j)).toUpperCase().concat(sentense[i].substring(j + 1).toLowerCase()) + " ";
                    break;
                } else {
                    result += sentense[i].charAt(j);
                }
            }
        }
        return result;
    }
//

    private void Add(ArrayList<CourseManager> list) {
        addCourse.getBtnAdd1().addActionListener((ActionEvent e) -> {
            String input = vertifyinput();
            if (input.isEmpty()) {
                String code = (addCourse.getTxtCode().getText());
                String name = chuannHoa(addCourse.getTxtName().getText());
                int num = -1;
                try {
                    num = Integer.parseInt(addCourse.getTxtCredit().getText());
                } catch (NumberFormatException exx) {
                    JOptionPane.showMessageDialog(null, "number must input Number");
                    return;
                }
                if (num < 0 || num > 32) {
                    JOptionPane.showMessageDialog(null, "number must input in range 0 - 32");
                    return;
                }
                if (!isDuplicate(list, code)) {
                    list.add(new CourseManager(code, name, num));
                    JOptionPane.showMessageDialog(addCourse, "Add Successful");
                } else {
                    JOptionPane.showMessageDialog(addCourse, "Add Fail");
                }
            } else {
                JOptionPane.showMessageDialog(null, input + "Null");
            }
        });
    }

    public void btnClear() {
        addCourse.getBtnClear().addActionListener((java.awt.event.ActionEvent evt) -> {
            addCourse.txtCode.setText("");
            addCourse.txtCredit.setText("");
            addCourse.txtName.setText("");
        });
    }
}
