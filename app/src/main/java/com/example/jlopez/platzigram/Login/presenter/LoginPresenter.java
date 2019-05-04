package com.example.jlopez.platzigram.Login.presenter;

public interface LoginPresenter {
    void SignIn(String username, String password); //Interactor
    void LoginSucces();
    void LoginError(String error);

}
