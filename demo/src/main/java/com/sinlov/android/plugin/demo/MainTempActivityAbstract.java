package com.sinlov.android.plugin.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hjq.permissions.OnPermissionCallback;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.sinlov.temp.android.AbsTemplateActivity;
import com.sinlov.temp.android.utils.ClipboardUtils;

import java.util.List;


public class MainTempActivityAbstract extends AbsTemplateActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setOnClickListener(
                R.id.btn_init_check,
                R.id.btn_get_module_data,
                R.id.btn_skip_to_module,
                R.id.btn_grant_permission,
                R.id.tv_result
        );
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_init_check) {
            toastBottom("module init check");
        } else if (id == R.id.btn_skip_to_module) {
            toast("Skip to module");
        } else if (id == R.id.btn_get_module_data) {
            toastBottom("get module data");
        } else if (id == R.id.btn_grant_permission) {
            requestFullPermission();
        } else if (id == R.id.tv_result) {
            TextView tvResult = findViewById(R.id.tv_result);
            ClipboardUtils.copy2Clipboard(getBaseContext(), tvResult.getText().toString());
            toast("copy at Clipboard");
        }
    }

    private void requestFullPermission() {
        XXPermissions.with(MainTempActivityAbstract.this)
//                .permission(Permission.MANAGE_EXTERNAL_STORAGE)
                .permission(Permission.READ_EXTERNAL_STORAGE)
                .permission(Permission.WRITE_EXTERNAL_STORAGE)
                .request(new NeedPermissionCall());
    }

    private class NeedPermissionCall implements OnPermissionCallback {
        @Override
        public void onGranted(List<String> permissions, boolean all) {
            if (all) {
                toast("已授权全部权限");
            } else {
                toast("获取部分权限成功，但部分权限未正常授予");
                requestFullPermission();
            }
        }

        @Override
        public void onDenied(List<String> permissions, boolean never) {
            if (never) {
                toast("被永久拒绝授权，请手动授予权限");
                // 如果是被永久拒绝就跳转到应用权限系统设置页面
                XXPermissions.startPermissionActivity(MainTempActivityAbstract.this, permissions);
            } else {
                toast("文件存储权限失败");
                requestFullPermission();
            }
        }
    }
}
