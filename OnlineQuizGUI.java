import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineQuizGUI extends JFrame implements ActionListener {

    String[] questions = {
            "Which language is used for Android Development?",
            "Which keyword is used to inherit a class in Java?",
            "What is the size of int in Java?",
            "Which collection stores unique elements?",
            "Which company developed Java?"
    };

    String[][] options = {
            {"Python", "Java", "C++", "PHP"},
            {"extends", "implement", "import", "package"},
            {"2 bytes", "4 bytes", "8 bytes", "16 bytes"},
            {"ArrayList", "LinkedList", "HashSet", "Vector"},
            {"Microsoft", "Apple", "Sun Microsystems", "Google"}
    };

    int[] answers = {1, 0, 1, 2, 2};

    int currentQuestion = 0;
    int score = 0;

    JLabel questionLabel;
    JRadioButton option1, option2, option3, option4;
    ButtonGroup group;
    JButton nextButton;

    public OnlineQuizGUI() {

        setTitle("Online Quiz Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));

        option1 = new JRadioButton();
        option2 = new JRadioButton();
        option3 = new JRadioButton();
        option4 = new JRadioButton();

        group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1));

        optionsPanel.add(option1);
        optionsPanel.add(option2);
        optionsPanel.add(option3);
        optionsPanel.add(option4);

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);

        add(questionLabel, BorderLayout.NORTH);
        add(optionsPanel, BorderLayout.CENTER);
        add(nextButton, BorderLayout.SOUTH);

        loadQuestion();

        setVisible(true);
    }

    void loadQuestion() {
        questionLabel.setText((currentQuestion + 1) + ". " + questions[currentQuestion]);

        option1.setText(options[currentQuestion][0]);
        option2.setText(options[currentQuestion][1]);
        option3.setText(options[currentQuestion][2]);
        option4.setText(options[currentQuestion][3]);

        group.clearSelection();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int selected = -1;

        if (option1.isSelected()) selected = 0;
        else if (option2.isSelected()) selected = 1;
        else if (option3.isSelected()) selected = 2;
        else if (option4.isSelected()) selected = 3;

        if (selected == answers[currentQuestion]) {
            score++;
        }

        currentQuestion++;

        if (currentQuestion < questions.length) {
            loadQuestion();
        } else {

            double percentage = (score * 100.0) / questions.length;

            String grade;

            if (percentage >= 80)
                grade = "Excellent";
            else if (percentage >= 60)
                grade = "Good";
            else
                grade = "Needs Improvement";

            JOptionPane.showMessageDialog(
                    this,
                    "Score: " + score + "/" + questions.length +
                    "\nPercentage: " + percentage + "%" +
                    "\nGrade: " + grade
            );

            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new OnlineQuizGUI();
    }
}