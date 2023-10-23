/*Name: Avuyile Maxhwele
* Student number: 4123042
* Project Sprint 3, Task2: First project software version
* Tittle: Fitness Coaching System*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class _4123042_FitnessAppGUI {
    private JFrame frame;
    private JPanel panel;

    public _4123042_FitnessAppGUI() {
        frame = new JFrame("Fitness Coaching App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        panel = new JPanel();
        frame.add(panel);

        showLoginPage();
    }
    private void saveUserToFile(String username, String password, String email){
        try{
            FileWriter writer = new FileWriter("users.txt",true);
            writer.write(username+ ","+ password + ","+ email +"\n");
            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private void showLoginPage() {
        panel.removeAll();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton signUpButton = new JButton("Sign Up");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement login logic here
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                boolean loggedIn = checkUserCredentials(username, password);
                if(loggedIn) {
                    showHomePage();

                    JOptionPane.showMessageDialog(null, "Login successful!");
                } else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }
            }

            private boolean checkUserCredentials(String username, String password) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] userInfo = line.split(",");
                        String storedUsername = userInfo[0];
                        String storedPassword = userInfo[1];
                        if (username.equals(storedUsername) && password.equals(storedPassword)) {
                            reader.close();
                            return true;
                        }
                    }
                    reader.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
                return false;
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement sign-up logic here
                showSignUpPage();
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(signUpButton);

        frame.setVisible(true);
    }

    private void showSignUpPage() {
        panel.removeAll();
        panel.setLayout(new GridLayout(5, 5));

        // Implement sign-up page here
        JLabel usernameLabel = new JLabel("username:");
        JTextField usernameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JLabel password2Label = new JLabel("Confirm Password:");
        JPasswordField passwordField = new JPasswordField();
        JPasswordField password2Field = new JPasswordField();

        // Create sign-up button
        JButton signUpButton = new JButton("Sign Up");
        JButton loginButton = new JButton("Login");
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                saveUserToFile(username,password,email);

                showHomePage();

                JOptionPane.showMessageDialog(null, "Sign up successful!");
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLoginPage();
            }
        });

        // Add components to the frame
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(password2Label);
        panel.add(password2Field);
        panel.add(signUpButton);
        panel.add(loginButton);

        frame.setVisible(true);
    }


    private void showHomePage() {
        panel.removeAll();
        panel.setLayout(new GridLayout(5, 4));
        // Create and customize GUI components
        JLabel titleLabel = new JLabel("Welcome to True's Fitness Coaching");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 15));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        // Implement home page with buttons here
        JButton profileButton = new JButton("Profile");
        JButton coachingButton = new JButton("Coaching");
        JButton aboutButton = new JButton("About");

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showProfilePage();
            }
        });

        coachingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCoachingPage();
            }


        });

        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAboutPage();
            }
        });
        panel.add(titleLabel);
        panel.add(profileButton);
        panel.add(coachingButton);
        panel.add(aboutButton);

        frame.revalidate();
        frame.repaint();
    }
    // The profile page
    private void showProfilePage() {
        panel.removeAll();
        panel.setLayout(new GridLayout(7, 6));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();
        JLabel heightLabel = new JLabel("Height:");
        JTextField heightField = new JTextField();
        JLabel weightLabel = new JLabel("Weight:");
        JLabel fitnessGoalsArea = new JLabel("Fitness goals:");
        JTextField weightField = new JTextField();
        JTextField fitnessGoalsField = new JTextField();
        JButton saveButton = new JButton("Save");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String age = ageField.getText();
                String height = heightField.getText();
                String weight = weightField.getText();
                String fitnessGoals = fitnessGoalsField.getText();
                try {
                    FileWriter fileWriter = new FileWriter("user_profile.txt", true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    bufferedWriter.write("Name: " + name);
                    bufferedWriter.newLine();
                    bufferedWriter.write("Age: " + age);
                    bufferedWriter.newLine();
                    bufferedWriter.write("Height: " + height);
                    bufferedWriter.newLine();
                    bufferedWriter.write("Weight: " + weight);
                    bufferedWriter.newLine();
                    bufferedWriter.write("Fitness Goals: " + fitnessGoals);
                    bufferedWriter.newLine();

                    bufferedWriter.close();


                    showHomePage();
                    JOptionPane.showMessageDialog(null, "Profile added successful!");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error saving profile!");
                }
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(heightLabel);
        panel.add(heightField);
        panel.add(weightLabel);
        panel.add(weightField);
        panel.add(fitnessGoalsArea);
        panel.add(fitnessGoalsField);
        saveButton.setBounds(335, 11, 89, 23);
        panel.add(saveButton);
        frame.setVisible(true);

    }
    // The coaching page
    private void showCoachingPage() {
        panel.removeAll();
        panel.setLayout(new GridLayout(7, 5));
        // Create exercise options
        String[] workoutOptions = {"Cardio", "Strength Training", "Yoga", "Pilates"};
        JComboBox<String> workoutComboBox = new JComboBox<>(workoutOptions);
        panel.add(new JLabel("Choose Workout Type: "));
        panel.add(workoutComboBox);

        // Create nutrition information
        JTextArea nutritionInfo = new JTextArea(5, 8);
        nutritionInfo.setEditable(false);
        nutritionInfo.setText("Here is some nutrition information...");
        JScrollPane scrollPane = new JScrollPane(nutritionInfo);
        panel.add(scrollPane);

        // Create payment method options
        JRadioButton cashRadioButton = new JRadioButton("Cash");
        JRadioButton creditCardRadioButton = new JRadioButton("Credit Card");
        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(cashRadioButton);
        paymentGroup.add(creditCardRadioButton);
        panel.add(new JLabel("Choose Payment Method: "));
        panel.add(cashRadioButton);
        panel.add(creditCardRadioButton);

        // Create submit button
        JButton submitButton = new JButton("Submit");
        panel.add(submitButton);

        // Add action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String workoutType = (String)workoutComboBox.getSelectedItem();
                String paymentMethod = cashRadioButton.isSelected() ? "Cash" : "Credit Card";


                // Perform necessary actions with workoutType and paymentMethod
                // E.g., save the user's choice, process payment, etc.

                JOptionPane.showMessageDialog(null, "Workout type: " + workoutType +
                        "\nPayment method: " + paymentMethod +
                        "\n\nSubmission successful!");
                showHomePage();

            }
        });
        frame.setVisible(true);
    }
    // The about page
    private void showAboutPage(){
        panel.removeAll();
        panel.setLayout(new GridLayout(5, 3));
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("About True's Coaching App");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);

        JTextArea aboutText = new JTextArea();
        aboutText.setWrapStyleWord(true);
        aboutText.setLineWrap(true);
        aboutText.setEditable(false);
        aboutText.setText("Welcome to our Fitness Coaching App! We are dedicated to helping you achieve your health and fitness goals through personalized coaching and guidance.\n\nOur app provides a wide range of features to support your fitness journey. With our workout plans, you can access various exercises and track your progress. Additionally, our nutrition plans offer tailored meal suggestions to optimize your diet.");
        panel.add(aboutText, BorderLayout.CENTER);

        JButton contactButton = new JButton("Contact Us");
        contactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the contact page or perform desired action
                JOptionPane.showMessageDialog(null, "Please contact us at support@truesfitnesscoaching.com for any inquiries.\nphone number: 0738776452");
                showHomePage();
            }
        });
        panel.add(contactButton);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the sign-up page or perform desired action
                showSignUpPage();
            }
        });
        panel.add(signUpButton);
        panel.add(mainPanel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new _4123042_FitnessAppGUI();
            }
        });
    }
}

