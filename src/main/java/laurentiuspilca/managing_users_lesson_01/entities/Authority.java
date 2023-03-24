package laurentiuspilca.managing_users_lesson_01.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Table(name = "authorities")
@Getter
@Setter
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "authorities")//DİĞER CLASSDAKİ SET'İN İSMİ
    private Set<User> users;
}
