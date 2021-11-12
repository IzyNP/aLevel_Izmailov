package com.izmaylov.hw7.actions;

import com.izmaylov.hw7.model.Animal;

public class GettingSick {
    public void testYourLuck(Animal animal){
        if(!animal.isIll()){
            int chance = 1 + ((int) (Math.random() * 101));
            if(chance <= animal.getChanceToGetSick()){
                animal.setIll(true);
                System.out.println(animal.getName() + " заболел");
            }
        }
    }
}
