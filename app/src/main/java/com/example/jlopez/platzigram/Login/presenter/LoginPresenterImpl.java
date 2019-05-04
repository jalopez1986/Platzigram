package com.example.jlopez.platzigram.Login.presenter;

import com.example.jlopez.platzigram.Login.interactor.LoginInteractor;
import com.example.jlopez.platzigram.Login.interactor.LoginInteractorImpl;
import com.example.jlopez.platzigram.Login.view.LoginView;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        interactor = new LoginInteractorImpl(this);
    }

    @Override
    public void SignIn(String username, String password) {
        loginView.disableInputs();
        loginView.showProgressBar();
        interactor.SignIn(username,password);

    }

    @Override
    public void LoginSucces() {
        loginView.goHome();
        loginView.hideProgressBar();

    }

    @Override
    public void LoginError(String error) {
        loginView.enableInputs();
        loginView.hideProgressBar();
        loginView.loginError(error);

    }
}
