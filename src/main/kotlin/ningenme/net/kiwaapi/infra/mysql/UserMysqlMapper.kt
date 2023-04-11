package ningenme.net.kiwaapi.infra.mysql

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface UserMysqlMapper {

    @Insert(
        "INSERT INTO user (user_id, encrypted_password) " +
                "VALUES (#{userId},#{encryptedPassword})"
    )
    fun insert(userMysqlDto: UserMysqlDto)

    @Select(
        "SELECT user_id, encrypted_password FROM user WHERE user_id = #{userId} "
    )
    fun select(userId: String): UserMysqlDto
}