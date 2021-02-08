package com.demo.android.template;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.demo.temp.AbstractTemplateTestActivity;
import com.demo.temp.utils.ClipboardUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivityAbstract extends AbstractTemplateTestActivity {

    @BindView(R.id.btn_main_module_init_check)
    Button btnMainModuleInitCheck;
    @BindView(R.id.btn_main_skip_to_module)
    Button btnMainSkipToModule;
    @BindView(R.id.btn_main_get_module_data)
    Button btnMainGetModuleData;
    @BindView(R.id.tv_main_result)
    TextView tvMainResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @OnClick({
            R.id.btn_main_module_init_check,
            R.id.btn_main_skip_to_module,
            R.id.btn_main_get_module_data,
            R.id.tv_main_result,
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            default:
                break;
            case R.id.btn_main_module_init_check:
                Log.v(TAG, "onViewClicked: btn_main_skip_to_module");
                break;
            case R.id.btn_main_skip_to_module:
                Log.d(TAG, "onViewClicked: btn_main_skip_to_module");
                showToast("skip_to_module");
                break;
            case R.id.btn_main_get_module_data:
                Log.i(TAG, "onViewClicked: btn_main_get_module_data");
                showToast("get_module_data");
                break;
            case R.id.tv_main_result:
                Log.w(TAG, "onViewClicked: tv_main_result", new IllegalArgumentException("log tv_main_result"));
                ClipboardUtils.copy2Clipboard(getBaseContext(), tvMainResult.getText().toString());
                showToast("Result has copy to clipboard");
                break;
        }
    }
}
