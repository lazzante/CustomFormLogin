package CustomFormLogin.security;


import CustomFormLogin.entities.Authority;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

//USER CLASS'INDA BAĞIMLILIK VE KİRLİLİK OLMAMASI İÇİN USERDETAİLS İMPLEMENTE EDECEĞİM CLASSIMI AYIRMIŞTIM, BUDA AYNISI
@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private final Authority authority;
    @Override
    public String getAuthority() {
        return authority.getName();
    }
}
