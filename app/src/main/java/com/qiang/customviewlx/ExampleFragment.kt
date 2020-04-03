package com.qiang.customviewlx

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

/**
 * @author qhc
 * @time 2020/3/31
 */
class ExampleFragment private constructor() : Fragment() {

    private var layoutRes: Int? = null

    companion object {
         private const val LAYOUT_COLOR : String = "layout_res"

        fun newInstance(layoutRes: Int): ExampleFragment {
            val bundle = Bundle()
            bundle.putInt(LAYOUT_COLOR, layoutRes)
            return ExampleFragment().apply { arguments = bundle }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            layoutRes = it.getInt(LAYOUT_COLOR)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes ?: R.layout.fragment_example, container)
    }

    private fun login(password: String, user: String) {
        /* fun checkEmpty(value: String, illegalStr: String){
             if (value.isEmpty()) {
                 throw IllegalArgumentException(illegalStr)
             }
         }
         check(user, "账号不能为空")
         check(password, "密码不能为空")*/
        require(user.isEmpty()) {"账号不能为空"}
        require(password.isEmpty()) {"密码不能为空"}
    }

}