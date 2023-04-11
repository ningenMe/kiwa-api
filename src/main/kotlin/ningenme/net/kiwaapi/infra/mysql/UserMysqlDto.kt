package ningenme.net.kiwaapi.infra.mysql

data class UserMysqlDto(
    var userId: String? = null,
    var encryptedPassword: String? = null
)