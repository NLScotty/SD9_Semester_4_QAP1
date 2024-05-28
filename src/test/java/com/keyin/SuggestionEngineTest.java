package com.keyin;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class SuggestionEngineTest {
    private SuggestionEngine suggestionEngine = new SuggestionEngine();

    // a test case given to us; tests to see if it can find hello if a character is incorrect
    @Test
    public void testGenerateSuggestionsIncorrect() throws Exception {
        suggestionEngine.loadDictionaryData( Paths.get( ClassLoader.getSystemResource("words.txt").getPath()));
        Assertions.assertTrue(suggestionEngine.generateSuggestions("hellw").contains("hello"));
    }

    //tests to see if it can find hello if a character is missing
    @Test
    public void testGenerateSuggestionsMissing() throws Exception {
        suggestionEngine.loadDictionaryData( Paths.get( ClassLoader.getSystemResource("words.txt").getPath()));
        //System.out.println(suggestionEngine.generateSuggestions("ello"));
        Assertions.assertTrue(suggestionEngine.generateSuggestions("ello").contains("hello"));
    }

    //tests to see if it can find hello if a character is added
    @Test
    public void testGenerateSuggestionsAdditional() throws Exception {
        suggestionEngine.loadDictionaryData( Paths.get( ClassLoader.getSystemResource("words.txt").getPath()));
        Assertions.assertFalse(suggestionEngine.generateSuggestions("hellow").contains("hello"));
    }

    //tests to see if it can find hello if a character is missing and there is a mistake
    @Test
    public void testGenerateSuggestionsLessWithMistake() throws Exception {
        suggestionEngine.loadDictionaryData( Paths.get( ClassLoader.getSystemResource("words.txt").getPath()));
        //System.out.println(suggestionEngine.generateSuggestions("hilo"));
        Assertions.assertTrue(suggestionEngine.generateSuggestions("hilo").contains("hello"));
    }

    //tests to see if it can find hello if a character is added and there is a mistake
    @Test
    public void testGenerateSuggestionsMoreWithMistake() throws Exception {
        suggestionEngine.loadDictionaryData( Paths.get( ClassLoader.getSystemResource("words.txt").getPath()));
        Assertions.assertFalse(suggestionEngine.generateSuggestions("hellaw").contains("hello"));
    }

    // a test case given to us; returns blank if the word matches with one in the database
    @Test
    public void testGenerateSuggestionWordIsCorrect() throws Exception {
        suggestionEngine.loadDictionaryData( Paths.get( ClassLoader.getSystemResource("words.txt").getPath()));
        boolean testInstanceSame = false;
        String result = suggestionEngine.generateSuggestions("hello");
        if(result.equals("")) { testInstanceSame = true; }
        Assertions.assertTrue(testInstanceSame);
        Assertions.assertFalse(suggestionEngine.generateSuggestions("hello").contains("hello"));
    }

}
