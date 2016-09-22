package com.emroxriprap;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * Credit to http://www.devtopics.com/best-programming-jokes/ for the jokes.
 */

public class JavaJoke {

    private ArrayList<String> jokeList;


    public JavaJoke() {
        populateJokeList();
    }

    public String getRandomJoke(){
        Random r = new Random();
        return jokeList.get(r.nextInt(jokeList.size()));
    }

    private void populateJokeList() {
        jokeList = new ArrayList<>();
        jokeList.add("Two bytes meet.  The first byte asks, “Are you ill?”  \n" +
                "The second byte replies, “No, just feeling a bit off.”");
        jokeList.add("Eight bytes walk into a bar.  The bartender asks, “Can I get you anything?”\n" +
                "\n" +
                "“Yeah,” reply the bytes.  “Make us a double.”");
        jokeList.add("Q. How did the programmer die in the shower?\n" +
                "A. He read the shampoo bottle instructions: Lather. Rinse. Repeat.");
        jokeList.add("How many programmers does it take to change a light bulb?\n" +
                "None – It’s a hardware problem");
        jokeList.add("Why do programmers always mix up Halloween and Christmas? \n" +
                "Because Oct 31 equals Dec 25.");
        jokeList.add("There are only 10 kinds of people in this world: those who know binary and those who don’t.");
        jokeList.add("A programmer walks to the butcher shop and buys a kilo of meat.  An hour later he comes back upset that the butcher shortchanged him by 24 grams.");
        jokeList.add("“Knock, knock.”\n" +
                "“Who’s there?”\n" +
                "very long pause….\n" +
                "“Java.”");
        jokeList.add("Programming is 10% science, 20% ingenuity, and 70% getting the ingenuity to work with the science.");
        jokeList.add("Programming is like sex:\n" +
                "One mistake and you have to support it for the rest of your life.");
        jokeList.add("A man is smoking a cigarette and blowing smoke rings into the air.  His girlfriend becomes irritated with the smoke and says, “Can’t you see the warning on the cigarette pack?  Smoking is hazardous to your health!” \n" +
                "\n" +
                "To which the man replies, “I am a programmer.  We don’t worry about warnings; we only worry about errors.”");
        jokeList.add("There are three kinds of lies: Lies, damned lies, and benchmarks.");
        jokeList.add("All programmers are playwrights, and all computers are lousy actors.");
        jokeList.add("Have you heard about the new Cray super computer?  It’s so fast, it executes an infinite loop in 6 seconds.");
        jokeList.add("The generation of random numbers is too important to be left to chance.");
        jokeList.add("“I just saw my life flash before my eyes and all I could see was a close tag…”");
        jokeList.add("The computer is mightier than the pen, the sword, and usually, the programmer.");
        jokeList.add("Debugging: Removing the needles from the haystack.");
        jokeList.add("Two strings walk into a bar and sit down. The bartender says, “So what’ll it be?”\n" +
                "\n" +
                "The first string says, “I think I’ll have a beer quag fulk boorg jdk^CjfdLk jk3s d#f67howe%^U r89nvy~~owmc63^Dz x.xvcu”\n" +
                "\n" +
                "“Please excuse my friend,” the second string says, “He isn’t null-terminated.”");
        jokeList.add("From the Random Shack Data Processing Dictionary:\n" +
                "\n" +
                "Endless Loop: n., see Loop, Endless.\n" +
                "Loop, Endless: n., see Endless Loop.");
        jokeList.add("The three most dangerous things in the world are a programmer with a soldering iron, a hardware engineer with a software patch, and a user with an idea.  – The Wizardry Compiled by Rick Cook\n" +
                "\n");
        jokeList.add("One hundred little bugs in the code\n" +
                "One hundred little bugs.\n" +
                "Fix a bug, link the fix in,\n" +
                "One hundred little bugs in the code.");

    }

}
