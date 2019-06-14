<?xml version="1.0"?>
<recipe>
    
    <instantiate from="root/res/layout/layout.xml.ftl"
                   to="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(layout)}.xml" />
    <open file="${escapeXmlAttribute(resOut)}/layout/${layout}.xml" />

    <instantiate from="root/src/app_package/Fragment.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${screenName}Fragment.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${screenName}Fragment.kt" />

    <instantiate from="root/src/app_package/Contract.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${screenName}Contract.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${screenName}Contract.kt" />

    <instantiate from="root/src/app_package/Presenter.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${screenName}Presenter.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${screenName}Presenter.kt" />

</recipe>
