fun getModel(
    packageName: String,
    key: String,
    upperKey: String,
    name: String,
    author: String
): HashMap<String, String> {
    return HashMap<String, String>().apply {
        put("packageName", packageName)
        put("key", key)
        put("upperKey", upperKey)
        put("name", name)
        put("author", author)
    }
}