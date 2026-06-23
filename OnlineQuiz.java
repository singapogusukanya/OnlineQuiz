import java.util.Scanner;

public class OnlineQuiz {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] questions = {
                "1. Which language is used for Android Development?",
                "2. Which keyword is used to inherit a class in Java?",
                "3. What is the size of int in Java?",
                "4. Which collection stores unique elements?",
                "5. Which company developed Java?"
        };

        String[][] options = {
                {"A) Python", "B) Java", "C) C++", "D) PHP"},
                {"A) extends", "B) implement", "C) import", "D) package"},
                {"A) 2 bytes", "B) 4 bytes", "C) 8 bytes", "D) 16 bytes"},
                {"A) ArrayList", "B) LinkedList", "C) HashSet", "D) Vector"},
                {"A) Microsoft", "B) Apple", "C) Sun Microsystems", "D) Google"}
        };

        char[] answers = {'B', 'A', 'B', 'C', 'C'};

        int score = 0;

        System.out.println("===== ONLINE QUIZ APPLICATION =====");

        for (int i = 0; i < questions.length; i++) {

            System.out.println("\n" + questions[i]);

            for (int j = 0; j < options[i].length; j++) {
                System.out.println(options[i][j]);
            }

            System.out.print("Enter your answer (A/B/C/D): ");
            char userAnswer = Character.toUpperCase(sc.next().charAt(0));

            if (userAnswer == answers[i]) {
                score++;
            }
        }

        System.out.println("\n===== RESULT =====");
        System.out.println("Your Score: " + score + "/" + questions.length);

        double percentage = (score * 100.0) / questions.length;
        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 80) {
            System.out.println("Grade: Excellent");
        } else if (percentage >= 60) {
            System.out.println("Grade: Good");
        } else {
            System.out.println("Grade: Needs Improvement");
        }

        sc.close();
    }
}