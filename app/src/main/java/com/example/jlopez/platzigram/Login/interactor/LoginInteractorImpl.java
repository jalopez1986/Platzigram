package com.example.jlopez.platzigram.Login.interactor;

import com.example.jlopez.platzigram.Login.presenter.LoginPresenter;
import com.example.jlopez.platzigram.Login.repository.LoginRepository;
import com.example.jlopez.platzigram.Login.repository.LoginRepositoryImpl;

public class LoginInteractorImpl implements LoginInteractor {

    private LoginPresenter presenter;
    private LoginRepository repository;

    public LoginInteractorImpl(LoginPresenter presenter) {
        this.presenter = presenter;
        repository = new LoginRepositoryImpl(presenter );
    }

    @Override
    public void SignIn(String username, String password) {
        repository.SignIn(username,password);

    }
}
