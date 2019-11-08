package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.base.BaseScrollTitleBarActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.base.util.ToastUtil;
import com.example.thin.util.LocalUser;

/**
 * @Author: xingyan
 * @Date: 2019/10/16
 * @Desc:
 */
public class FollowPositionActivity extends BaseScrollTitleBarActivity<BasePresenter> implements IBaseView, View.OnClickListener {
    private Button nextBtn;
    private TextView tvAllSelect;
    private CheckBox cbChest;
    private CheckBox cbArm;
    private CheckBox cbAbdomen;
    private CheckBox cbHips;
    private CheckBox cbLeg;
    private StringBuilder followPosition;


    public static void open(Context context) {
        context.startActivity(new Intent(context, FollowPositionActivity.class));
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_follow_position;
    }

    @Override
    protected void initContentView() {
        mTitleBar.setTitle("哪一部分最关注的？");
        nextBtn = getView(R.id.btn_next);
        tvAllSelect = getView(R.id.tv_all_select);

        cbChest = getView(R.id.cb_chest);
        cbArm = getView(R.id.cb_arm);
        cbAbdomen = getView(R.id.cb_abdomen);
        cbHips = getView(R.id.cb_hips);
        cbLeg = getView(R.id.cb_leg);

        nextBtn.setOnClickListener(this);
        tvAllSelect.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        followPosition = new StringBuilder();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int bottomLayoutId() {
        return super.bottomLayoutId();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_all_select://全选
                cbChest.setChecked(true);
                cbArm.setChecked(true);
                cbAbdomen.setChecked(true);
                cbHips.setChecked(true);
                cbLeg.setChecked(true);
                break;
            case R.id.btn_next://下一步
                if (!cbChest.isChecked() && !cbArm.isChecked() && !cbAbdomen.isChecked() && !cbHips.isChecked() && !cbLeg.isChecked()) {
                    showToastMsg("请选择您最关注得部位");
                    return;
                }
                Log.e("-----", "cbChest = " + cbChest.isChecked()
                        + "  cbArm = " + cbArm.isChecked()
                        + "  cbAbdomen = " + cbAbdomen.isChecked()
                        + "  cbHips = " + cbHips.isChecked()
                        + "  cbLeg = " + cbLeg.isChecked());

                //1手臂 2胸部 3臂部 4腹部 5腿部

                if (cbArm.isChecked()) {
                    followPosition.append(1 + ",");
                }
                if (cbChest.isChecked()) {
                    followPosition.append(2 + ",");
                }
                if (cbHips.isChecked()) {
                    followPosition.append(3 + ",");
                }
                if (cbAbdomen.isChecked()) {
                    followPosition.append(4 + ",");
                }
                if (cbLeg.isChecked()) {
                    followPosition.append(5);
                }

                LocalUser.getInstance().setFollowPosition(followPosition.toString());
                WelcomeJoinActivity.open(this);
                finish();
                break;
            default:
                break;
        }
    }
}
