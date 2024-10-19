package StudentRegistrationForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegistrationFormGUI extends JFrame {

    private JTextField nameTF, emailTF, phoneNumberTF;
    private JLabel name, email, phoneNumber, gender, courseLabel, acceptTerms;
    private JRadioButton male;
    private JRadioButton female;
    private JComboBox course;
    private JCheckBox confirmation;
    private JButton submit;
    private JPanel registerPanel, genderPanel, coursePanel, acceptTermsPanel, submitPanel;

    public StudentRegistrationFormGUI() {
        this.setTitle("Student Registration Form");
        this.setLayout(new GridLayout(5, 1));
        initializeComponents();
        this.setSubmitButton();
        this.setSize(300, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    private void initializeComponents() {
        this.name = new JLabel("Name:");
        this.nameTF = new JTextField();

        this.email = new JLabel("Email:");
        this.emailTF = new JTextField();

        this.phoneNumber = new JLabel("Phone:");
        this.phoneNumberTF = new JTextField();

        this.gender = new JLabel("Gender:");
        this.male = new JRadioButton("Male");
        this.female = new JRadioButton("Female");

        this.courseLabel = new JLabel("Course:");
        this.course = new JComboBox();

        this.acceptTerms = new JLabel("Accept Terms:");
        this.confirmation = new JCheckBox("Agree Terms and Conditions");
        this.submit = new JButton("Submit");

        this.registerPanel = new JPanel();
        this.setRegisterPanel();

        this.genderPanel = new JPanel();
        this.setGenderPanel();

        this.coursePanel = new JPanel();
        this.setCoursePanel();

        this.acceptTermsPanel = new JPanel();
        this.setAcceptTermsPanel();

        this.submitPanel = new JPanel();
        this.setSubmitPanel();

        this.add(this.registerPanel);
        this.add(this.genderPanel);
        this.add(this.coursePanel);
        this.add(this.acceptTermsPanel);
        this.add(this.submitPanel);

    }


    private void setRegisterPanel() {
        this.registerPanel.setLayout(new GridLayout(3, 2));

        this.nameTF.setEditable(true);
        this.nameTF.setPreferredSize(new Dimension(100, 30));

        this.emailTF.setEditable(true);
        this.emailTF.setPreferredSize(new Dimension(100, 30));

        this.phoneNumberTF.setEditable(true);
        this.phoneNumberTF.setPreferredSize(new Dimension(100, 30));

        this.registerPanel.add(name);
        this.registerPanel.add(nameTF);

        this.registerPanel.add(email);
        this.registerPanel.add(emailTF);

        this.registerPanel.add(phoneNumber);
        this.registerPanel.add(phoneNumberTF);


    }

    private void setGenderPanel() {
        this.genderPanel.setLayout(new GridLayout(1, 3));

        this.male.setSelected(false);
        this.female.setSelected(false);

        this.male.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (male.isSelected()) {
                    female.setSelected(false);
                }
            }
        });

        this.female.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (female.isSelected()) {
                    male.setSelected(false);
                }
            }
        });

        this.genderPanel.add(gender);
        this.genderPanel.add(male);
        this.genderPanel.add(female);


    }

    public void setCoursePanel() {
        this.coursePanel.setLayout(new GridLayout(1, 2));

        this.course.addItem("Java");
        this.course.addItem("Python");
        this.course.addItem("C++");
        this.course.setVisible(true);

        this.course.setEditable(false);
        this.coursePanel.add(courseLabel);
        this.coursePanel.add(course);


    }

    private void setAcceptTermsPanel() {
        this.acceptTermsPanel.setLayout(new GridLayout(1, 2));
        this.confirmation.setSelected(false);

        this.acceptTermsPanel.add(acceptTerms);
        this.acceptTermsPanel.add(confirmation);


    }

    private void setSubmitPanel() {
        this.submitPanel.add(submit);
    }

    private void setSubmitButton() {
        this.submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name, email, phoneNumber;
                name = nameTF.getText();
                email = emailTF.getText();
                phoneNumber = phoneNumberTF.getText();

                if (confirmation.isSelected()) {
                    if (!(name.equals("")) && !(email.equals("")) && !(phoneNumber.equals(""))) {
                        if (male.isSelected() || female.isSelected()) {
                            String msg;
                            if (male.isSelected()) {
                                msg = showMessage(name, email, phoneNumber, "male", course.getSelectedItem().toString());
                            } else {
                                msg = showMessage(name, email, phoneNumber, "female", course.getSelectedItem().toString());
                            }
                            JOptionPane.showMessageDialog(StudentRegistrationFormGUI.this, msg);

                        } else {
                            JOptionPane.showMessageDialog(StudentRegistrationFormGUI.this, "Please select your gender");

                        }

                    } else {
                        JOptionPane.showMessageDialog(StudentRegistrationFormGUI.this, "Please enter your information");
                    }
                } else {
                    JOptionPane.showMessageDialog(StudentRegistrationFormGUI.this, "Please accept terms and conditions");

                }

            }

            public String showMessage(String name, String email, String phoneNumber, String gender, String course) {
                String message = "";

                message += "Name: " + name + "\n";
                message += "Email: " + email + "\n";
                message += "Phone: " + phoneNumber + "\n";
                message += "Gender: " + gender + "\n";
                message += "Course: " + course + "\n";
                message += "You have successfully submitted!" + "\n";
                return message;
            }

        });
    }
}
