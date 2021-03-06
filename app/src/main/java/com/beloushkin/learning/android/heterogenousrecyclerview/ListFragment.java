package com.beloushkin.learning.android.heterogenousrecyclerview;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beloushkin.learning.android.heterogenousrecyclerview.mock.MockAdapter;
import com.beloushkin.learning.android.heterogenousrecyclerview.mock.MockData;
import com.beloushkin.learning.android.heterogenousrecyclerview.mock.MockGenerator;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment
        implements MockData.MockDataListener
{

    private RecyclerView mRecyclerView;
    private final MockData mMockData = MockData.getInstance();
    private final MockAdapter mAdapter = new MockAdapter(mMockData.mockList());

    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    // создадим листенер и будем инициализировать в onAttach
    // если бы листенеров было несколько то пришлось бы пихать в ArrayList
    private MockAdapter.onItemClickListener mOnclickListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MockAdapter.onItemClickListener) {
            mOnclickListener = (MockAdapter.onItemClickListener) context;
        }
    }

    @Override
    public void onDetach() {
        mOnclickListener = null;
        super.onDetach();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.recycler);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
        //Setting add data listener here because only here we have adapter
        mMockData.setMockDataListener(this);
        //Setting onClick listener here
        mAdapter.setOnClickListener(mOnclickListener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fr_list, container, false);
    }

    // MockDataListener implementation
     @Override
    public void itemAdded(int position) {
        mAdapter.notifyItemInserted(position);
        mRecyclerView.scrollToPosition(position);
    }

    public void itemRemoved(int position) {
        mAdapter.notifyDataSetChanged();
    }


}
