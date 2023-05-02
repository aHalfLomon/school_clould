package talks.Pojo;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class Auth_user {
    private String user_avatar;

    private String user_name;

    public String getUser_avatar() {
        return user_avatar;
    }

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "Auth_user{" +
                "user_avatar='" + user_avatar + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
