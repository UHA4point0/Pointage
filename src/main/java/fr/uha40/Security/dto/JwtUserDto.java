package fr.uha40.Security.dto;

import fr.uha40.Enums.Role;

/**
 * JwtUserDto
 * Package : fr.uha40.Security.dto
 * Created : 13/09/2016 12:43
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
public class JwtUserDto {

    private Long id;

    private String username;

    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
