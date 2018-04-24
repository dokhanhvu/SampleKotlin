package com.example.vudo.samplekotlin.ui.screen.base

import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import javax.inject.Inject

/**
 * Created by vu.do on 4/19/2018.
 */
abstract class BaseFragment <B : ViewDataBinding, VM : BaseViewModel<*>> : Fragment() {

    lateinit var mViewDataBinding: B
    lateinit var mViewModel: VM
    lateinit var mVRootView: View

    abstract fun getVariable(): Int

    @LayoutRes
    abstract fun getLayoutId() : Int

    abstract fun getViewModel() : VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        mVRootView = mViewDataBinding.root
        return mVRootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewDataBinding.setVariable(getVariable(), mViewModel)
        mViewDataBinding.executePendingBindings()
    }
}