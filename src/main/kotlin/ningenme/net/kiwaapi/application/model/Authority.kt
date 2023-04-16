package ningenme.net.kiwaapi.application.model

import ningenme.net.kiwaapi.infra.mysql.AuthorityMysqlDto
import org.springframework.security.core.GrantedAuthority

enum class Authority(
    val value: String
) : GrantedAuthority {
    COMPRO_CATEGORY("COMPRO_CATEGORY");

    companion object {
        private fun of(value: String): Authority {
            return Authority.values().first { it.value == value }
        }

        fun of(valueList: List<AuthorityMysqlDto>): List<Authority> {
            return valueList.map { of(it.authorityId!!) }
        }
    }

    override fun getAuthority(): String {
        return value
    }

    fun isAuthorized(grantedAuthorityList: Collection<GrantedAuthority>): Boolean {
        return grantedAuthorityList.any { it.authority == this.authority }
    }
}