package laurentiuspilca.managing_users_lesson_01.security;


import laurentiuspilca.managing_users_lesson_01.entities.Authority;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

//USER CLASS'INDA BAĞIMLILIK VE KİRLİLİK OLMAMASI İÇİN YSERDETAİLS İMPLEMENTE EDECEĞİM CLASSIMI AYIRMIŞTIM, BUDA AYNISI
@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private final Authority authority;
    @Override
    public String getAuthority() {
        return authority.getName();
    }
}
