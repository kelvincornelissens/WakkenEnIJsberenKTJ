package com.kelvin.wakkenenijsberenktj;

import org.junit.Test;

import GameClasses.*;
import GameClasses.Level;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

    }


    @Test
    public void testGame(){
        GameClasses.Level level = new Level(5,true,50,3);

        Game game = new Game(level);

        game.start();

        int punten = game.answer(new Result(2,3,2));



        int i =0;

    }
}