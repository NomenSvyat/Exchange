package ${escapeKotlinIdentifiers(packageName)}

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nomensvyat.exchange.core.di.ComponentManager
import com.nomensvyat.exchange.core.ui.base.BaseFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import javax.inject.Inject
import dagger.Lazy

class ${screenName}Fragment : BaseFragment(), ${screenName}Contract.View {

    //region Presenter
    @Inject
    lateinit var presenterProvider : Lazy<${screenName}Presenter>

    @InjectPresenter
    lateinit var presenter: ${screenName}Presenter

    @ProvidePresenter
    fun providePresenter() : ${screenName}Presenter = presenterProvider.get()
    //endregion

    override fun inject(componentManager: ComponentManager) {
        TODO()
    }

    private lateinit var binding : ${underscoreToCamelCase(layout)}Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ${underscoreToCamelCase(layout)}Binding.inflate(inflater, container, false)
        return binding.root
    }

}
