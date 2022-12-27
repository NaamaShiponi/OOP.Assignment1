package observer;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * This class adds undo functions to the StringBuilder class
 *
 * @author Ben Dabush and Naana Shiponi
 * @version 1.0.0 Nov 2 2022
 */
public class UndoableStringBuilder {

    /**
     * Generic params for the class
     *
     * @param strB  - Saves the most updated text
     * @param stack - Saves the text history
     */
    private StringBuilder strB;
    private Stack<StringBuilder> stack;

    /**
     * A constructor of type UndoableStringBuilder
     */
    public UndoableStringBuilder() {
        strB = new StringBuilder();
        stack = new Stack<StringBuilder>();
    }

    /**
     * A constructor of type UndoableStringBuilder that accepts a string
     */
    public UndoableStringBuilder(String str) {
        strB = new StringBuilder(str);
        stack = new Stack<StringBuilder>();
        newStringBuilder();
    }

    /**
     * append function -
     * Appends the specified string to this character sequence.
     *
     * @param str - The new content of the repository.
     * @return Updated UndoableStringBuilder text
     */
    public UndoableStringBuilder append(String str) {
        strB.append(str);
        newStringBuilder();
        return this;
    }

    /**
     * delete function -
     * Removes the characters in a substring of this sequence. The substring begins
     * at the specified start and extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     *
     * @param start - Removes characters from this index
     * @param end   -Removes characters up to this index
     * @return If the function succeeded then is returned updated UndoableStringBuilder text otherwise than null
     * @exception StringIndexOutOfBoundsException
     */
    public UndoableStringBuilder delete(int start, int end) {
        try {
            strB.delete(start, end);
            newStringBuilder();
            return this;
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("delete err" + e);
            return null;
        }
    }

    /**
     * insert function -
     * Inserts the string into this character sequence.
     *
     * @param offset -Enters from this character index
     * @param str    -New text to be inserted
     * @return If the function succeeded then is returned updated UndoableStringBuilder text otherwise than null
     * @exception StringIndexOutOfBoundsException
     */
    public UndoableStringBuilder insert(int offset, String str) {
        try {
            strB.insert(offset, str);
            newStringBuilder();
            return this;
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("insert err " + e);
            return null;
        }

    }

    /**
     * replace function -
     * Replaces the characters in a substring of this sequence with characters in
     * the specified String. The substring begins at the specified start and
     * extends to the character at index end - 1 or to the end of the sequence if
     * no such character exists. First the characters in the substring are removed
     * and then the specified String is inserted at start. (This sequence will be
     * leng thened to accommodate the specified String if necessary).
     *
     * @param start -Enters from this character index
     * @param end   -Enters up to this character index
     * @param str   -New text to be inserted
     * @return If the function succeeded then is returned updated UndoableStringBuilder text otherwise than null
     * @exception StringIndexOutOfBoundsException
     */
    public UndoableStringBuilder replace(int start, int end, String str) {
        try {
            strB.replace(start, end, str);
            newStringBuilder();
            return this;
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("replace err " + e);
        }catch(Exception e){
            System.err.println("replace err " + e);
        }
        return null;
    }

    /**
     * reverse function -
     * Causes this character sequence to be replaced by the reverse of the sequence.
     *
     * @return Updated UndoableStringBuilder text
     */
    public UndoableStringBuilder reverse() {
        strB.reverse();
        newStringBuilder();
        return this;
    }

    /**
     * undo function -
     * Removes the current text from the stack and returns the previous one
     *
     * @exception EmptyStackException
     */
    public void undo() {
        try {
            stack.pop();
            strB = stack.peek();
        } catch (EmptyStackException e) {
            strB.setLength(0);
        }

    }

    /**
     * newStringBuilder function -
     * Creates a new object and pushes the object onto the stack.
     * Creating a new object is to avoid overrunning.
     */
    private void newStringBuilder() {
        StringBuilder newsSB = new StringBuilder(strB.toString());
        stack.push(newsSB);
    }

    /**
     * toString function -
     * Converts an object to a string
     *
     * @return String text
     */
    @Override
    public String toString() {
        return strB.toString();
    }
}
//public class main(){
//
//}
