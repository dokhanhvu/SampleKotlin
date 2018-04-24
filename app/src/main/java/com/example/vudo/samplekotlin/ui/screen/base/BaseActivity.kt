package com.example.vudo.samplekotlin.ui.screen.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

/**
 * Created by vu.do on 4/18/2018.
 */
abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel<*>> : AppCompatActivity(){

    lateinit var mViewDataBinding: B
    lateinit var mViewModel: VM

    //private var activityComponent : ActivityComponent? = null

    abstract fun getVariable(): Int

    @LayoutRes
    abstract fun getLayoutId() : Int

    abstract fun getViewModel() : VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    fun performDataBinding(){
        mViewDataBinding = DataBindingUtil.setContentView(this,getLayoutId())
        mViewModel = getViewModel()
        mViewDataBinding.setVariable(getVariable(),mViewModel)
        mViewDataBinding.executePendingBindings()

    }

//    fun getActivityComponent() : ActivityComponent?{
//        if (activityComponent == null) {
//            setUpInject()
//        }
//        return activityComponent
//    }
//
//    fun setUpInject(){
//        activityComponent = DaggerActivityComponent.builder()
//                .activityModule(ActivityModule(this))
//                .applicationComponent((application as KotlinSampleApplication).getApplicationComponent())
//                .build()
//    }
}