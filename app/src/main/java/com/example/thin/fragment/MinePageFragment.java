package com.example.thin.fragment;

import android.view.View;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.activity.CreateAddressActivity;
import com.example.thin.activity.LoginActivity;
import com.example.thin.activity.MyOrderActivity;
import com.example.thin.base.mvp.BaseFragment;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.presenter.MinePagePresenter;
import com.example.thin.util.LocalUser;
import com.example.thin.view.MineLoginView;

/**
 * @Author: xingyan
 * @Date: 2019/8/2
 * @Desc:
 */
public class MinePageFragment extends BaseFragment<BasePresenter> implements IBaseView, View.OnClickListener {

    private TextView myOrder, addressManager;
    private TextView tvWaitPay;
    private TextView tvUnuse;
    private TextView tvWaitSend;
    private TextView tvWaitGet;
    private TextView tvFinish;
    private MineLoginView mineLoginView;


    public static MinePageFragment newInstance() {
        return new MinePageFragment();
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_mine_page;
    }

    @Override
    protected void initView(View view) {
        myOrder = getView(view, R.id.tv_my_order);
        mineLoginView = getView(view, R.id.lv_login);
        addressManager = getView(view, R.id.tv_my_address);
        tvWaitPay = getView(view, R.id.tv_wait_pay);
        tvUnuse = getView(view, R.id.tv_unuse);
        tvWaitSend = getView(view, R.id.tv_wait_send);
        tvWaitGet = getView(view, R.id.tv_wait_get);
        tvFinish = getView(view, R.id.tv_finish);
        myOrder.setOnClickListener(this);
        addressManager.setOnClickListener(this);
        tvWaitPay.setOnClickListener(this);
        tvUnuse.setOnClickListener(this);
        tvWaitSend.setOnClickListener(this);
        tvWaitGet.setOnClickListener(this);
        tvFinish.setOnClickListener(this);

        getView(view, R.id.tv_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.open(getActivity());
            }
        });
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            if (LocalUser.getInstance().isLogin()) {
                mineLoginView.dismiss();
            } else {
                mineLoginView.show();
            }
        } else {
            mineLoginView.dismiss();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (LocalUser.getInstance().isLogin()) {
            mineLoginView.dismiss();
        } else {
            mineLoginView.show();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        mineLoginView.dismiss();
    }

    /**
     * 这个方法可能被用来在一组有序的fragmen里 ，例如 fragment生命周期的更新。告诉我们这个方法被调用希望在一个pager里，因此 FragmentPagerAdapter 可以使用这个，然后调用这个 setUserVisibleHint() 在fragment里，因此有些人也建议重写 setUserVisibileHint() 来知道当前一个fragment对用户来说是隐藏还是显示，这个方法仅仅工作在FragmentPagerAdapter中，不能被使用在一个普通的activity中。
     * <p>
     * 作者：糖葫芦_倩倩
     * 链接：<a href='https://www.jianshu.com/p/ae3bf6fb2585'>https://www.jianshu.com/p/ae3bf6fb2585</a>
     * 来源：简书
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    protected void initData() {

//        LocalUser.getInstance().getProfile().userId
        if (!LocalUser.getInstance().isLogin()) {
            mineLoginView.show();
//            CommonDialogUtils dialogUtils = new CommonDialogUtils(getActivity()) {
//                @Override
//                protected int layoutId() {
//                    return R.layout.layout_login;
//                }
//
//                @Override
//                protected void initView(View view) {
//
//                }
//            };
//            dialogUtils.show();
            return;
        }

    }

    @Override
    public MinePagePresenter createPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_wait_pay://待付款
                MyOrderActivity.open(getActivity(), 1);
                break;
            case R.id.tv_unuse://未使用
                MyOrderActivity.open(getActivity(), 2);
                break;
            case R.id.tv_wait_send://待发货
                MyOrderActivity.open(getActivity(), 3);
                break;
            case R.id.tv_wait_get://待收货
                MyOrderActivity.open(getActivity(), 4);
                break;
            case R.id.tv_finish://已完成
                MyOrderActivity.open(getActivity(), 5);
                break;
            case R.id.tv_my_order://我的订单
                MyOrderActivity.open(getActivity(), 0);
                break;
            case R.id.tv_my_address://地址管理
                CreateAddressActivity.open(getActivity());
                break;
            default:
                break;
        }

    }
}
