package ningenme.net.kiwaapi.infra

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMysqlMapper {

    @Insert(
        "INSERT INTO user (user_id, encrypted_password) " +
                "VALUES (#{userId},#{encryptedPassword})"
    )
    fun insert(userMysqlDto: UserMysqlDto)
}