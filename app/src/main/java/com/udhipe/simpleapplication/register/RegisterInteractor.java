package com.udhipe.simpleapplication.register;

import org.json.JSONObject;

public class RegisterInteractor implements RegisterContract.RegisterInteractor {
    @Override
    public void createAccountData(String username, String password, int accountType, Listener<JSONObject> listener) {
        try {
/*            PersonDao mPersonDao = daoSession.getPersonDao();
            Query<Person> personQuery = mPersonDao.queryBuilder().orderAsc(PersonDao.Properties.Name).build();
            List<Person> listPersonData = personQuery.list();
            listener.onSuccess(listPersonData, "success");*/
        } catch (Exception exception) {
            listener.onError(exception.getMessage());
        }
    }
}
