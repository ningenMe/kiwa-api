package ningenme.net.kiwaapi.infra

data class UserMysqlDto(
    var userId: String? = null,
    var encryptedPassword: String? = null
)