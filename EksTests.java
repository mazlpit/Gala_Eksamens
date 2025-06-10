package Gala_Eksamens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
}
