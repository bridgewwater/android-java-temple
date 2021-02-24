package com.sinlov.android.plugin.demo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.sinlov.android.plugin.Plugin;
import com.sinlov.android.plugin.demo.databinding.ActivityMainBinding;
import com.sinlov.android.plugin.demo.databinding.MainProfileBinding;
import com.sinlov.temp.android.AbstractTemplateTestActivity;
import com.sinlov.temp.android.utils.ClipboardUtils;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivityAbstract extends AbstractTemplateTestActivity {

    ActivityMainBinding activityMainBinding;
    MainProfileBinding mainProfile;

    @Inject
    MainActivityAdapter activityAdapter;

    @Override
    protected void onProcessLogic(Bundle savedInstanceState) {

    }

    @Override
    protected View onSetContentView() {
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        mainProfile = activityMainBinding.mainProfile;
        return activityMainBinding.getRoot();
    }

    @Override
    protected void onCreateBindView() {
        mainProfile.btnInitCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "onViewClicked: btn_init_check");
            }
        });
        mainProfile.btnSkipToModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onViewClicked: btn_skip_to_module");
                showToast("btnSkipToModule");
            }
        });
        mainProfile.btnGetModuleData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onViewClicked: btn_get_module_data");
                showToast("btnGetModuleData");
            }
        });
        mainProfile.btnTestModuleData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onViewClicked: btn_test_module_data");
                showToast("btnTestModuleData");
            }
        });
        mainProfile.tvResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w(TAG, "onViewClicked: tv_main_result", new IllegalArgumentException("log tv_main_result"));
                ClipboardUtils.copy2Clipboard(getBaseContext(), mainProfile.tvResult.getText().toString());
                Toast.makeText(MainActivityAbstract.this.getApplicationContext(), "Result has copy to clipboard", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
