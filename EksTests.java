package Gala_Eksamens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

public class EksTests {
    // Iekšējā klase, kas reprezentē jautājumu
    private static class Question {
        String question;           // Jautājuma teksts
        List<String> answers;      // Atbilžu saraksts
        int correctAnswerIndex;    // Pareizās atbildes indekss

        // Konstruktorā inicializē jautājumu, atbildes un pareizās atbildes indeksu
        public Question(String question, String[] answers, int correctAnswerIndex) {
            this.question = question;
            this.answers = new ArrayList<>();
            Collections.addAll(this.answers, answers);
            this.correctAnswerIndex = correctAnswerIndex;
        }

        // Sajauc atbildes un atjauno pareizās atbildes indeksu
        public void shuffleAnswers() {
            String correctAnswer = answers.get(correctAnswerIndex);
            Collections.shuffle(answers);
            correctAnswerIndex = answers.indexOf(correctAnswer);
        }
    }
     public static void main(String[] args) {
        // Uzdod lietotājam jautājumu, vai sākt testu
        int startOption = JOptionPane.showOptionDialog(null,
            "Vai vēlies sākt Cikls ar pēcnosacījumu testu?",
            "Sākums",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new Object[] { "Sākt testu", "Iziet" },
            "Sākt testu");

        if (startOption != JOptionPane.YES_OPTION) {
            // Ja lietotājs neizvēlas sākt testu, izvada paziņojumu un beidz programmu
            JOptionPane.showMessageDialog(null, "Tests netika sākts. Uzredzēšanos!", "Iziet", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Izveido jautājumu sarakstu
        List<Question> questions = createQuestions();
        List<Question> incorrectAnswers = new ArrayList<>();  // Jautājumi ar nepareizām atbildēm
        int correctCount = 0;  // Pareizo atbilžu skaits

        // Izvada īsu testu instrukciju
        JOptionPane.showMessageDialog(null, 
            "Tests par Ciklu ar pēcnosacījumu\n\n" +
            "Katram jautājumam ir 4 atbilžu varianti. Izvēlies pareizo!",
            "Cikls ar pēcnosacījumu Tests", 
            JOptionPane.INFORMATION_MESSAGE);
}
