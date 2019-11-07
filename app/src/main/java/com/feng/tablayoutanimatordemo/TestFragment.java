package com.feng.tablayoutanimatordemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author Feng Zhaohao
 * Created on 2018/8/24
 */
public class TestFragment extends Fragment {

    private String content; //碎片正文内容
    private int index;

    /**
     * 返回碎片实例
     * @param content
     * @return
     */
    public static TestFragment newInstance(String content, int index) {
        TestFragment fragment = new TestFragment();
        //动态加载fragment，接受activity传入的值
        Bundle bundle = new Bundle();
        bundle.putString("content", content);
        bundle.putInt("index", index);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        content = getArguments().getString("content");
        index = getArguments().getInt("index");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_test, null);
        view.setTag(index);
        TextView contentTextView = view.findViewById(R.id.tv_fragment_test_content);
        contentTextView.setText(content);
        return view;
    }
}
