package ${escapeKotlinIdentifiers(packageName)}

import com.nomensvyat.exchange.core.ui.base.BasePresenter
import com.nomensvyat.exchange.core.ui.base.BaseView

class ${screenName}Contract private constructor() {

    interface View : BaseView

    abstract class Presenter : BasePresenter<View>()
}
