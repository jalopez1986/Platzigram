package com.example.jlopez.platzigram.Login.repository;

import com.example.jlopez.platzigram.Login.presenter.LoginPresenter;

public class LoginRepositoryImpl implements  LoginRepository {

    LoginPresenter presenter;

    public LoginRepositoryImpl(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void SignIn(String username, String password) {
        boolean success = true;
        if (success) {
            presenter.LoginSucces();
        } else {
            presenter.LoginError("Ocurrió un error");
        }

    }
}
