package com.sinlov.android.demo.template;


import dagger.Component;

@Component(modules = {
        MainBizModules.class
})
public interface MainActivityComponent {

    void inject(MainActivityAbstract mainActivityAbstract);

    void tag(String tag);
}
