package com.aleksejantonov.router.ui.a

import android.os.*
import android.view.*
import com.aleksejantonov.router.*
import com.aleksejantonov.router.di.DI
import com.aleksejantonov.router.ui.base.BaseView.Action.OnNavigationClick
import com.arellomobile.mvp.*
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_a.bNavigation
import javax.inject.Inject

class AScreenFragment : MvpAppCompatFragment(), AView {
  companion object {
    fun newInstance() = AScreenFragment()
  }

  @Inject
  @InjectPresenter
  lateinit var presenter: APresenter

  @ProvidePresenter
  fun providePresenter(): APresenter {
    DI.componentManager().aScreenComponent().inject(this)
    return presenter
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_a, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    bNavigation.setOnClickListener { presenter.viewAction(OnNavigationClick) }
  }
}