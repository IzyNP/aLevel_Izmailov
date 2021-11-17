package com.izmaylov.hw7.actions;

public enum ActionsMenu {
    FOOD("Покормить"), GAME("Поиграть"), SHOP("Купить подарок"), WORK("Поработать"),
    HEAL("Вылечить"),INFO("Информация про питомца"),PRESENTS_INFO("Информация про подарки"), EXIT("Выйти");

    private  String russianActionsName;

    ActionsMenu(String string) {
        this.russianActionsName = string;
    }



    @Override
    public String toString() {

        return  russianActionsName;
    }
}
