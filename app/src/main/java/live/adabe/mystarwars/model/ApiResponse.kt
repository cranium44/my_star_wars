package live.adabe.mystarwars.model

data class ApiResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<User>
)