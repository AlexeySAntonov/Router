package com.aleksejantonov.router.ui.b

import android.os.*
import android.view.*
import com.aleksejantonov.router.*
import com.arellomobile.mvp.*

class BScreenFragment : MvpAppCompatFragment() {
    companion object {
        fun newInstance() = BScreenFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}