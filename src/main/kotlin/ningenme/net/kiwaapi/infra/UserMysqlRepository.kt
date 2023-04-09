package ningenme.net.kiwaapi.infra

import org.springframework.stereotype.Repository

@Repository
class UserMysqlRepository(private val userMysqlMapper: UserMysqlMapper) {

    fun postUser(userId: String, encryptedPassword: String) {
        userMysqlMapper.insert(UserMysqlDto(userId, encryptedPassword))
    }

    fun getUser(userId: String): UserMysqlDto? {
        return userMysqlMapper.select(userId)
    }

}