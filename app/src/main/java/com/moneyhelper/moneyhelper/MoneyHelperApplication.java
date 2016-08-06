package com.moneyhelper.moneyhelper;

import com.moneyhelper.moneyhelper.models.MoneyHelperService;

/**
 * Created by proyecto on 06/08/2016.
 */
public class MoneyHelperApplication extends com.orm.SugarApp {
    private MoneyHelperService moneyHelperService = new MoneyHelperService();

    public MoneyHelperService getMoneyHelperService() {
        return moneyHelperService;
    }

    public void setMoneyHelperService(MoneyHelperService moneyHelperService) {
        this.moneyHelperService = moneyHelperService;
    }
}

