package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMain {

    public static void main(String[] args) {
        //Regex
        //Regexp
        //Regular 123123.0123 Expressions

        String s = "My email is: test@site.com. " +
                "My secondary email: test2@test.co.il." +
                "I am 30 years old \\n";
        //I am 30 years old

        System.out.println(s
                .replaceAll("@", "#")
                .replaceAll("My", "Your"));




        //Pattern - компилятор regex
        //Matcher - ищет совпадения в тексте
        //PatternSyntaxException - не закрытая скобка

        String test = "test";

        //что ищем
        Pattern pattern = Pattern.compile("test");

        //из какого теста
        Matcher matcher = pattern.matcher(test);

        System.out.println(matcher.find());

        /**
         * \d - digit
         * \d+ - one or more digits
         * \d{1,3} - 1 or 11 or 111
         * \d{,3} - nothing or 1 or 11 or 111
         * \d{1,} - 1 or more (MUST BE AT LEAST ONE)
         * \d[1-5] - 1 or 2 or 3 ..., but not 6 ..
         * \d[0-9] - 0 or 1 or 2, but not 15
         * \d[50-100] - 50 to 100, but not 49
         * \D - not a digit

         * \w - word character (a-z A-Z)
         * \w+ - one or more characters
         * \W - not a word character
         * \s - space (пробел)
         * \s+ - multiple spaces
         * \S - not space
         * .*? - all
         * \b - new line
         * \B - not new line
         *
         * ^ (in the beginning) - must start with
         * Dog is here - ^Dog
         *
         * $ - must end with
         * Is there a dog - dog$
         *
         * [a-zA-Z0-9] - alphanumeric
         * ^ (NOT in the beginning) - NOT
         * [^[abc]] in [zyxwvutsrqponm]
         */
//        matcher.find() ->
//        matcher.matches()
        //pattern   text    matches
        //\d        123        3
        //\d{2}     123        2
        //\d{3}     123        1

        runRegex("\\d", "123");
        runRegex("\\d{2}", "123");
        runRegex("\\d{3}", "123");
        runRegex("\\w", "This is Java!");
        runRegex("\\W", "This is Java!");
        runRegex("is", "This is Java!");
        runRegex("is\\s", "This is Java!");
        runRegex("\\sis\\s", "This is Java!");
        runRegex("https.*?\\..*?/", "https://medium.com/factory-mind/regex-tutorial-a-simple-cheatsheet-by-examples-649dc1c3f285");
        runRegex("https.*?\\..*?/.*?-cheatsheet-", "https://medium.com/factory-mind/regex-tutorial-a-simple-cheatsheet-by-examples-649dc1c3f285");
        runRegex("7", "https://medium.com/factory-mind/regex-tutorial-a-simple-cheatsheet-by-examples-649dc1c3f285");
        runRegex("\\d[8-9]", "https://medium.com/factory-mind/regex-tutorial-a-simple-cheatsheet-by-examples-649dc1c3f285");

        getValueFromTextByPattern();

    }

    private static void getValueFromTextByPattern() {
        Pattern pattern = Pattern.compile(".*?(\\w+@.*?)\\.\\s"); //anything, till @ anything till . (dot with a space)
        Matcher matcher = pattern.matcher("My primary email address is tel123ran@telran.co.il. I have no secondary email");
        //group(0) - everything found
        //group(1) - within zero group
        while (matcher.find()) {

            String email = matcher.group(1); //group(0) = group()
            System.out.println(email);
        }
    }

    private static void runRegex(String regexPattern, String text) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(text);



        int howManyMatched = 0;
        while (matcher.find()) {
            howManyMatched++;
        }

        System.out.printf("%s found %s matches from [%s]\n", regexPattern, howManyMatched, text);


    }
}
