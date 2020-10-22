package org.academiadecodigo.anderdogs.tilePaint.controls;

import org.academiadecodigo.anderdogs.tilePaint.TilePaint;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.IOException;


public class Controls implements KeyboardHandler {
    private TilePaint tp;
    private Keyboard keyboard;


    public Controls(TilePaint tp) {
        this.tp =  tp;

        keyboard = new Keyboard(this);

        int[] myKeys = {KeyboardEvent.KEY_H, KeyboardEvent.KEY_J, KeyboardEvent.KEY_K, KeyboardEvent.KEY_L,
                        KeyboardEvent.KEY_UP, KeyboardEvent.KEY_DOWN,KeyboardEvent.KEY_LEFT, KeyboardEvent.KEY_RIGHT,
                        KeyboardEvent.KEY_SPACE, KeyboardEvent.KEY_B, KeyboardEvent.KEY_S, 27}; //27 = ESC

        for (int i = 0; i < myKeys.length; i++) {
            KeyboardEvent keyboardEvent = new KeyboardEvent();
            keyboardEvent.setKey(myKeys[i]);
            keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(keyboardEvent);
        }


    }


    /**
     * @param keyboardEvent
     */
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        try {
            tp.inputKey(keyboardEvent);
        } catch (IOException e) {
            System.out.println("something went wrong");
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
