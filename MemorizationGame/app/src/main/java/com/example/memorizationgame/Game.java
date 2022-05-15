package com.example.memorizationgame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class Game implements Serializable {
    int[] shapes = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5,
            R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9, R.drawable.image10,
            R.drawable.image11, R.drawable.image12};
    int[] answer = new int[3];


    //用set生成answer
    public int[] getAnswer() { //用answer储存的数字展示图片
        Random rand = new Random();
        HashSet<Integer> answerSet = new HashSet<>();
        while (answerSet.size() < 3){
            int n = rand.nextInt(12);
            answerSet.add(n);
        }
        Object[] an = answerSet.toArray();
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (int) an[i];
        }
        return answer;
    }

    //用set生成optionArray
    public Object[] getOptions(){
        HashSet<Integer> optionSet = new HashSet<>();
        for (int i = 0; i < answer.length; i++) {
            optionSet.add(answer[i]);
        }
        Random rand = new Random();
        while (optionSet.size() < 6){
            int n = rand.nextInt(12);
            optionSet.add(n);
        }
        ArrayList<Integer> list = new ArrayList<>(optionSet);

        Collections.shuffle(list);

        Object[] optionArray = list.toArray();
        return optionArray;
    }


}