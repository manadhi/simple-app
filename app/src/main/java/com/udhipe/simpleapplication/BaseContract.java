package com.udhipe.simpleapplication;

public interface BaseContract {
    interface BaseView {
        void openPage(String page);

        void showInfo(String infoCode);
    }

    interface BasePresenter {
        void goToPage(String page);

        void exceptionHandler(String message);
    }

    interface BaseInteractor {
        interface Listener<T> {
            void onSuccess(T data, String message);

            void onError(String message);
        }

    }
}
