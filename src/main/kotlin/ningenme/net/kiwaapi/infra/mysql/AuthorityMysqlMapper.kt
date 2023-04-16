package ningenme.net.kiwaapi.infra.mysql

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface AuthorityMysqlMapper {

    @Select(
        "SELECT a.authority_id FROM authority AS a " +
                "JOIN relation_user_authority AS ua ON a.authority_id = ua.authority_id " +
                "JOIN user AS u ON ua.user_id = u.user_id WHERE u.user_id = #{userId} "
    )
    fun select(userId: String): List<AuthorityMysqlDto>
}