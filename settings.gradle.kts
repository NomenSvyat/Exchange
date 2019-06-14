include(":app")

LibModules.values().forEach {
    include(it.path)
}
