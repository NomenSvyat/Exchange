package ${escapeKotlinIdentifiers(packageName)}

import com.arellomobile.mvp.InjectViewState
import javax.inject.Inject

@InjectViewState
class ${screenName}Presenter @Inject constructor() : ${screenName}Contract.Presenter()