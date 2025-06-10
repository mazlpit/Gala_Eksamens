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
            for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);
            currentQuestion.shuffleAnswers();  // Sajauc atbildes

            // Sagatavo atbilžu opcijas dialogam
            String[] options = currentQuestion.answers.toArray(new String[0]);
            // Parāda jautājumu un atbildes opcijas
            int response = JOptionPane.showOptionDialog(null,
                (i + 1) + ". " + currentQuestion.question,
                "Jautājums " + (i + 1) + " no " + questions.size(),
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

            // Pārbauda atbildi un izvada atbilstošu ziņu
            if (response == currentQuestion.correctAnswerIndex) {
                JOptionPane.showMessageDialog(null,
                    "Pareizi!",
                    "Rezultāts",
                    JOptionPane.INFORMATION_MESSAGE);
                correctCount++;
            } else {
                JOptionPane.showMessageDialog(null,
                    "Nepareizi! Pareizā atbilde: " + 
                    currentQuestion.answers.get(currentQuestion.correctAnswerIndex),
                    "Rezultāts",
                    JOptionPane.ERROR_MESSAGE);
                incorrectAnswers.add(currentQuestion);
            }
        }

        // Sagatavo gala rezultātu ziņojumu
        StringBuilder resultMessage = new StringBuilder();
        resultMessage.append("Tests pabeigts!\n");
        resultMessage.append("Pareizo atbilžu skaits: ").append(correctCount)
                    .append(" no ").append(questions.size()).append("\n");

        // Ja ir nepareizas atbildes, izvada arī tās
        if (!incorrectAnswers.isEmpty()) {
            resultMessage.append("\nJautājumi, uz kuriem atbildēji nepareizi:\n");
            for (Question q : incorrectAnswers) {
                resultMessage.append("\n- ").append(q.question);
                resultMessage.append("\n  Pareizā atbilde: ")
                            .append(q.answers.get(q.correctAnswerIndex)).append("\n");
            }
        }

        // Parāda gala rezultātu dialogu
        JOptionPane.showMessageDialog(null,
            resultMessage.toString(),
            "Gala rezultāti",
            JOptionPane.INFORMATION_MESSAGE);
    }
     // Funkcija, kas izveido un atgriež jautājumu sarakstu
    private static List<Question> createQuestions() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
            "Kāda ir do-while cikla sintakse Java?",
            new String[] {
                "do { ... } while (nosacījums);",
                "while (nosacījums) do { ... }",
                "do while (nosacījums) { ... }",
                "do (nosacījums) { ... } while;"
            },
            0
        ));

        questions.add(new Question(
            "Kāda ir galvenā atšķirība starp while un do-while ciklu?",
            new String[] {
                "do-while vienmēr izpilda kodu vismaz vienu reizi",
                "while cikls vienmēr izpilda kodu vismaz vienu reizi",
                "do-while nevar izmantot ar nosacījumiem",
                "nav atšķirību"
            },
            0
        ));

        questions.add(new Question(
            "Kas notiks, ja do-while cikla nosacījums vienmēr būs true?",
            new String[] {
                "Cikls darbosies bezgalīgi",
                "Cikls izpildīsies vienu reizi un apstāsies",
                "Programma neizpildīsies",
                "Kompilators izmetīs kļūdu"
            },
            0
        ));

        questions.add(new Question(
            "Cik reizes izpildīsies šāds cikls: do { ... } while (false);",
            new String[] {
                "1",
                "0",
                "Bezgalīgi daudz",
                "2"
            },
            0
        ));

        questions.add(new Question(
            "Kā pareizi pārtraukt do-while ciklu pirms nosacījuma pārbaudes?",
            new String[] {
                "Izmantot break;",
                "Izmantot exit;",
                "Izmantot stop;",
                "Do-while ciklu nevar pārtraukt pirms nosacījuma pārbaudes"
            },
            0
        ));

        questions.add(new Question(
            "Kāda būs mainīgā x vērtība pēc šāda cikla izpildes?\nint x = 5; do { x++; } while (x < 10);",
            new String[] {
                "10",
                "9",
                "11",
                "5"
            },
            0
        ));

        questions.add(new Question(
            "Vai do-while cikla nosacījums tiek pārbaudīts pirms koda izpildes?",
            new String[] {
                "Nē, tiek pārbaudīts pēc koda izpildes",
                "Jā, tāpat kā while ciklā",
                "Tikai tad, ja izmanto speciālu atslēgvārdu",
                "Jā, bet tikai pirmajā iterācijā"
            },
            0
        ));

        questions.add(new Question(
            "Kādu rezultātu izvadīs šis kods?\nint i = 0; do { System.out.print(i + \" \"); i++; } while (i > 0 && i < 3);",
            new String[] {
                "0 1 2",
                "1 2",
                "0 1 2 3",
                "Bezgalīga izvade"
            },
            0
        ));

        questions.add(new Question(
            "Vai do-while ciklā var izmantot vairākus nosacījumus?",
            new String[] {
                "Jā, izmantojot loģiskos operatorus (&&, ||)",
                "Nē, do-while cikls atļauj tikai vienu nosacījumu",
                "Jā, bet tikai ar speciālu sintaksi",
                "Nē, nosacījumi nav atļauti do-while ciklā"
            },
            0
        ));

        questions.add(new Question(
            "Kāda būs mainīgā y vērtība pēc šāda cikla izpildes?\nint y = 10; do { y -= 2; } while (y > 5);",
            new String[] {
                "4",
                "6",
                "8",
                "10"
            },
            0
        ));

        return questions;
    }
}


