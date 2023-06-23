package uz.gita.testappmy.controller;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import uz.gita.testappmy.model.TestData;

public class AppController {
    ArrayList<Integer> skipClick;

    public HashMap<Integer, Boolean> ans=new HashMap<>();

    private List<TestData> list;
    private final int MAX_COUNT = 30;

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }

    private int currentPos = 0;
    private int wrongCount;
//    public boolean[] truFalse;

    public void setWrongCount(int wrongCount) {
        this.wrongCount = wrongCount;
    }

    public void setCorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    private int correctCount;

//    public List<TestData> getList() {
//        return list;
//    }

    public int getMAX_COUNT() {
        return MAX_COUNT;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public int getWrongCount() {
        return wrongCount;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public static AppController getController() {
        return controller;
    }

    public int getSkipCount() {
        return MAX_COUNT - correctCount - wrongCount;
    }

    {

        loadTests();
    }


    private AppController() {
        skipClick = new ArrayList<>();
    }

    private static AppController controller;

    public static AppController getInstance() {
        if (controller == null)
            controller = new AppController();
        return controller;
    }

    private void loadTests() {

        list = new ArrayList<>();
//        list.add(new TestData("What is the difference between \"affect\" and \"effect\"?", "There is no difference", "\"Affect\" is a noun, \"effect\" is a verb", "\"Affect\" is a verb, \"effect\" is a noun", "\"Affect\" and \"effect\" are both adjectives", "\"Affect\" and \"effect\" are both adjectives"));
//        list.add(new TestData("What is the meaning of the word \"supercilious\"?", "Confused", "Arrogant", "Sympathetic", "Humble", "Humble"));
//        list.add(new TestData("What is the difference between \"disinterested\" and \"uninterested\"?", "There is no difference", "\"Disinterested\" means unbiased, \"uninterested\" means not interested", "\"Disinterested\" means uninterested, \"uninterested\" means unbiased", "\"Disinterested\" and \"uninterested\" are synonyms", "\"Disinterested\" and \"uninterested\" are synonyms"));
//        list.add(new TestData("Which of the following sentences is grammatically correct?", "\"Me and my friends are going to the movies.\"", "\"My friends and I are going to the movies.\"", "\"I and my friends are going to the movies.\"", "\"My friends and me are going to the movies.\"", "\"My friends and me are going to the movies.\""));
//        list.add(new TestData("What is the correct plural form of \"octopus\"?", "Octopuses", "Octopi", "Octopodes", "Octopii", "Octopii"));
//        list.add(new TestData("What is the difference between \"compliment\" and \"complement\"?", "There is no difference", "\"Compliment\" is an adjective, \"complement\" is a noun", "\"Compliment\" is a noun, \"complement\" is a verb", "\"Compliment\" is an expression of praise, \"complement\" means to complete or enhance", "\"Compliment\" is an expression of praise, \"complement\" means to complete or enhance"));
//        list.add(new TestData("What is the difference between \"emigrate\" and \"immigrate\"?", "There is no difference", "\"Emigrate\" means to leave a country, \"immigrate\" means to enter a country", "\"Emigrate\" means to enter a country, \"immigrate\" means to leave a country", "\"Emigrate\" and \"immigrate\" are synonyms", "\"Emigrate\" and \"immigrate\" are synonyms"));
//        list.add(new TestData("Which of the following words is a synonym for \"abstruse\"?", "Simple", "Obvious", "Puzzling", "Clear", "Clear"));
//        list.add(new TestData("Which of the following sentences is grammatically correct?", "\"I could care less about politics.\"", "\"I couldn't care less about politics.\"", "\"I could care less or more about politics.\"", "\"I couldn't care less or more about politics.\"", "\"I couldn't care less or more about politics.\""));
//        list.add(new TestData("What is the meaning of the phrase \"to turn a blind eye\"?", "To be unaware of something", "To ignore something intentionally", "To look at something closely", "To be intrigued by something", "To be intrigued by something"));
//        list.add(new TestData("What is the difference between \"accept\" and \"except\"?", "There is no difference", "\"Accept\" is a verb, \"except\" is a noun", "\"Accept\" means to exclude, \"except\" means to include", "\"Accept\" means to receive or agree to, \"except\" means to exclude or leave out", "\"Accept\" means to receive or agree to, \"except\" means to exclude or leave out"));
//        list.add(new TestData("Which of the following words is a synonym for \"perfidious\"?", "Loyal", "Faithful", "Treacherous", "Honest", "Honest"));
//        list.add(new TestData("Which of the following is a correct use of a semicolon?", "I love to read; books are my favorite hobby.", "I love to read, books are my favorite hobby.", "I love to read books; are my favorite hobby.", "I love to read books, are my favorite hobby.", "I love to read books, are my favorite hobby."));
//        list.add(new TestData("What is the meaning of the word \"ennui\"?", "Extreme happiness", "Extreme sadness", "Extreme boredom", "Extreme anger", "Extreme anger"));
//        list.add(new TestData("Which of the following sentences is written in the active voice?", "\"The ball was caught by John.\"", "\"John caught the ball.\"", "\"The ball had been caught by John.\"", "\"The ball will be caught by John.\"", "\"The ball will be caught by John.\""));
//        list.add(new TestData("What is the difference between \"advice\" and \"advise\"?", "There is no difference", "\"Advice\" is a verb, \"advise\" is a noun", "\"Advice\" is a noun, \"advise\" is a verb", "\"Advice\" and \"advise\" are synonyms", "\"Advice\" and \"advise\" are synonyms"));
//        list.add(new TestData("Which word is an example of an absolute adjective?\n", "Red", "Unique", "Tall", "Angry", "Angry"));
//        list.add(new TestData("Which of the following words is a phrasal verb?", "Run", "Run into", "Runner", "Running", "Running"));
//        list.add(new TestData("Which of the following words is an example of a modal verb?", "Can", "Was", "Is", "Were", "Were"));
//        list.add(new TestData("Which of the following sentences is an example of a gerund phrase?", "I love swimming in the ocean.", "Swimming in the ocean is my favorite activity.", "The ocean is where I love to swim.", "To swim in the ocean is a great experience.", "To swim in the ocean is a great experience."));

//
//        list = new ArrayList<>(5);
//        list.add(new TestData("kecha nima yeding","osh","somsa","shorva","tuxum","osh"));
//        list.add(new TestData("kecha nima yeding","osh","somsa","shorva","tuxum","osh"));
//        list.add(new TestData("kecha nima yeding","osh","somsa","shorva","tuxum","osh"));
//        list.add(new TestData("kecha nima yeding","osh","somsa","shorva","tuxum","osh"));
//        list.add(new TestData("kecha nima yeding","osh","somsa","shorva","tuxum","osh"));
//
//
//        list = new ArrayList<>(20);
        list.add(new TestData("8 * 10 = ?","70","80","90","23","80"));
        list.add(new TestData("12 + 128 = ?","140","122","130","150","140"));
        list.add(new TestData("2+2*(2-2) = ?","0","2","4","6","2"));
        list.add(new TestData("x + 18 = 92.5","77.5","74.5","87.5","67.5","77.5"));
        list.add(new TestData("65.6 - 21.3 = ?","44.3","34.3","34.2","54.3","44.3"));
        list.add(new TestData("252 / 3 = ?","74","94","64","84","84"));
        list.add(new TestData("8 * x = 12","2.6","2.5","1.6","1.5","80"));
        list.add(new TestData("x - 9.7 = 24.5","34.3","34.2","34.4","24.2","34.2"));
        list.add(new TestData("3.2 / x = 0.4","60","8","80","6","8"));
        list.add(new TestData("39-x = 23","6","17","16","32","16"));
        list.add(new TestData("560 / x = 70","70","60","80","8","8"));
        list.add(new TestData("x + 63 = 79","26","16","36","6","16"));
        list.add(new TestData("924 / x=  ","70","60","90","23","80"));
        list.add(new TestData("2 * x = 162","70","60","90","23","80"));
        list.add(new TestData("x  + 50 = 89","70","60","90","23","80"));
        list.add(new TestData("x + 13 = 26","70","60","90","23","80"));
        list.add(new TestData("8 * 42 = ?","70","60","90","23","80"));


        list.add(new TestData("30 + x = 46?","70","80","90","23","80"));
        list.add(new TestData("37 * 3.7 = ?","140","122","130","150","140"));
        list.add(new TestData("2+2*(2-2) = ?","0","2","4","6","2"));
        list.add(new TestData("98 * x = 441.6","77.5","74.5","87.5","67.5","77.5"));
        list.add(new TestData("x/ 2 = 63","44.3","34.3","34.2","54.3","44.3"));
        list.add(new TestData("43 + 65 = ?","74","94","64","84","84"));
        list.add(new TestData("52.4 - x = 5.3","2.6","2.5","1.6","1.5","80"));
        list.add(new TestData("x - 9.7 = 24.5","34.3","34.2","34.4","24.2","34.2"));
        list.add(new TestData("130 / 10 = ?","60","8","80","6","8"));
        list.add(new TestData("39-x = 23","6","17","16","32","16"));
        list.add(new TestData("560 / x = 70","70","60","80","8","8"));
        list.add(new TestData("x + 63 = 79","26","16","36","6","16"));
        list.add(new TestData("924 / x=  ","70","60","90","23","80"));
        list.add(new TestData("2 * x = 162","70","60","90","23","80"));
        list.add(new TestData("x  + 50 = 89","70","60","90","23","80"));
        list.add(new TestData("x + 13 = 26","70","60","90","23","80"));
        list.add(new TestData("8 * 42 = ?","70","60","90","23","80"));
        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(list);
    }

    public TestData getNextTextData() {
        shuffle();
        return list.get(currentPos++);
    }

    public boolean islastQuestion() {
        return currentPos < MAX_COUNT;
    }

    public void testCheck(String userAnswer) {
        if (list.get(currentPos - 1).getAnswer().equals(userAnswer)) {
            correctCount++;
            ans.put((currentPos-1),true);
        } else {
            ans.put((currentPos-1),false);
            wrongCount++;
        }
    }
}
