package main.java.string;

/**
 * Created by mengye on 17/4/24.
 */

import java.util.Stack;

/**
 * Description：
 * Given an input string, reverse the string word by word.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 */
public class ReverseWordInString {
  private String originString;

  public String getOriginString() {
    return this.originString;
  }

  public void setOriginString(String originString) {
    this.originString = originString;
  }

  public String reverseTwo() {
    Stack<Character> word = new Stack<>();
    Stack<Character> sentence = new Stack<>();
    int i = 0;

    while (i <= originString.length()) {
      if (i == originString.length() || originString.charAt(i) == ' ') {
        if (!word.empty()) {
          if (!sentence.empty()) {
            sentence.push(' ');
          }
          while (!word.empty()) {
            sentence.push(word.peek());
            word.pop();
          }
        }
      } else {
        word.push(originString.charAt(i));
      }
      i++;
    }
    StringBuilder afterReverse = new StringBuilder();
    while (!sentence.empty()) {
      afterReverse.append(sentence.pop());
    }
    return afterReverse.toString();
  }

  public String reverse() {
    originString = originString + " ";
    Stack<String> words = new Stack<>();
    StringBuilder word = new StringBuilder();
    for (int i = 0; i < originString.length(); i++) {

      if (originString.charAt(i) == ' ') {
        words.push(word.toString());
        word.delete(0, word.length());
      } else {
        word.append(originString.charAt(i));
      }
    }
    StringBuilder afterReverse = new StringBuilder();
    while (!words.isEmpty()) {
      afterReverse.append(words.pop()).append(" ");
    }
    return afterReverse.toString();
  }

  public static void main(String[] args) {
    ReverseWordInString reverseWordInString = new ReverseWordInString();
    reverseWordInString.setOriginString(" this is a  test  word ");
    String reverseWord = reverseWordInString.reverse();
    System.out.println("反转结果1：" + reverseWord);
    String reverseWord2 = reverseWordInString.reverseTwo();
    System.out.println("反转结果2：" + reverseWord2);

  }
}
