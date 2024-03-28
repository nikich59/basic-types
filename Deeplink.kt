package uz.uzum.tezkor.courier.basic_types

data class Deeplink(
    val originalString: String,
    val host: String,
    val path: Path,
    val arguments: Map<String, String>,
) {
    data class Path(
        val pathString: String,
        val pathSegments: List<String>,
    )
}
