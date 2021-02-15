package com.sinlov.android.demo.template;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public class MainBizModules {

    @Provides
    public static MainBizService provideMainBizService() {
        return new MainBizService();
    }
}
