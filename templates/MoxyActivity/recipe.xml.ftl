<?xml version="1.0"?>
<recipe>
    
    <instantiate from="root/res/layout/activity.xml.ftl"
                   to="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(activityLayout)}.xml" />
    <open file="${escapeXmlAttribute(resOut)}/layout/${activityLayout}.xml" />

    <instantiate from="root/src/app_package/Activity.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${screenName}Activity.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${screenName}Activity.kt" />

    <instantiate from="root/src/app_package/Contract.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${screenName}Contract.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${screenName}Contract.kt" />

    <instantiate from="root/src/app_package/Presenter.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${screenName}Presenter.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${screenName}Presenter.kt" />

</recipe>
