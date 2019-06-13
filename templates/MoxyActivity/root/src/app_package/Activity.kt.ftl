package ${escapeKotlinIdentifiers(packageName)}

import android.os.Bundle
import com.nomensvyat.exchange.core.di.ComponentManager
import com.nomensvyat.exchange.core.ui.base.BaseActivity
import com.nomensvyat.exchange.core.ui.utils.extensions.setContentBinding
import com.arellomobile.mvp.presenter.InjectPresenter
import javax.inject.Inject
import dagger.Lazy

class ${screenName}Activity : BaseActivity(), ${screenName}Contract.View {

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

    private lateinit var binding : ${underscoreToCamelCase(activityLayout)}Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentBinding(R.layout.${activityLayout})
    }
}
