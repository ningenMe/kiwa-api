package ningenme.net.kiwaapi.infra.mysql

import org.springframework.stereotype.Repository

@Repository
class UserMysqlRepository(
    private val userMysqlMapper: UserMysqlMapper,
    private val authorityMysqlMapper: AuthorityMysqlMapper
) {

    fun postUser(userId: String, encryptedPassword: String) {
        userMysqlMapper.insert(UserMysqlDto(userId, encryptedPassword))
    }

    fun getUser(userId: String): UserMysqlDto? {
        val authorityMysqlDtoList = authorityMysqlMapper.select(userId)
        val userMysqlDto = userMysqlMapper.select(userId)
        userMysqlDto?.authorityMysqlDtoList = authorityMysqlDtoList
        return userMysqlDto
    }
}
