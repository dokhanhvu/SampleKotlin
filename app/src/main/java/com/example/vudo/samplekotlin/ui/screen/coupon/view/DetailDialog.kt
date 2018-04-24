package com.example.vudo.samplekotlin.ui.screen.coupon.view

import android.app.Dialog
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.*
import android.widget.RelativeLayout
import butterknife.BindColor
import com.example.vudo.samplekotlin.R
import com.example.vudo.samplekotlin.databinding.DialogCouponDetailBinding
import com.example.vudo.samplekotlin.model.Coupon
import com.example.vudo.samplekotlin.ui.screen.coupon.CouponDialogNavigator
import com.example.vudo.samplekotlin.ui.screen.coupon.ViewModel.CouponDialogViewModel
import java.io.Serializable

/**
 * Created by vu.do on 4/24/2018.
 */
class DetailDialog () : DialogFragment(), CouponDialogNavigator{

    lateinit var coupon: Coupon

    lateinit var couponDialogViewModel: CouponDialogViewModel

    companion object {
        fun newInstance(coupon: Coupon) : DetailDialog{
            val args : Bundle = Bundle()
            args.putSerializable("Extra_1", coupon as Serializable)
            val dialog = DetailDialog()
            dialog.arguments = args
            return dialog
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val root: RelativeLayout = RelativeLayout(activity)
        root.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)

        val dialog : Dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(root)
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window!!.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
        }
        dialog.setCanceledOnTouchOutside(false)

        return dialog

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        coupon = arguments.getSerializable("Extra_1") as Coupon
        couponDialogViewModel = CouponDialogViewModel(coupon)
        couponDialogViewModel.setNavigator(this)
        lifecycle.addObserver(couponDialogViewModel)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : DialogCouponDetailBinding = DataBindingUtil.inflate(inflater, R.layout.dialog_coupon_detail, container, false)
        val view = binding.getRoot()
        binding.viewmodel = couponDialogViewModel
        return view
    }

    override fun dismissDialog() {
        dismiss()
    }
}