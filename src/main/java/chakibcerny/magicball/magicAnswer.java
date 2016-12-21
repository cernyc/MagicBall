package chakibcerny.magicball;

import java.util.Random;

/**
 * Created by chakibcerny on 10/24/16.
 */

public class magicAnswer {

    Random ran = new Random();
    int num;

    public String newPhrase(){

        num = ran.nextInt(10);

        if (num < 1){
            return "The answer is in \n the question";
        }
        if (num < 2){
            return "Very doubtful";
        }
        if (num < 3){
            return "You may rely \n on it";
        }
        if (num < 4){
            return "Better not tell \n you now";
        }
        if (num < 5){
            return "Concentrate and \n ask again";
        }
        if ( num < 6){
            return "Yes, this project \n deserves an A";
        }
        if (num < 7){
            return "Only yhe future \n can tell us";
        }
        if (num < 8){
            return "It only depends \n on you !";
        }
        if (num < 9){
            return "It is decidedly so";
        }
        else return "As I see \nit, yes";

    }

}
