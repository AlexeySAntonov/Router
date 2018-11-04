package com.aleksejantonov.router.ui.start

import android.os.*
import android.view.*
import com.aleksejantonov.router.*
import com.aleksejantonov.router.di.*
import com.aleksejantonov.router.ui.base.BaseView.Action.OnNavigationClick
import com.arellomobile.mvp.*
import com.arellomobile.mvp.presenter.*
import kotlinx.android.synthetic.main.fragment_main.aNavigation
import javax.inject.*

class StartFragment : MvpAppCompatFragment(), StartView {
  companion object {
    fun newInstance() = StartFragment()
  }

  @Inject
  @InjectPresenter
  lateinit var presenter: StartPresenter

  @ProvidePresenter
  fun providePresenter(): StartPresenter {
    DI.componentManager().startScreenComponent().inject(this)
    return presenter
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_main, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    aNavigation.setOnClickListener { presenter.viewAction(OnNavigationClick) }
  }
}