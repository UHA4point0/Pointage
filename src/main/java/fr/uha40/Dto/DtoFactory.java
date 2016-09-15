package fr.uha40.Dto;

import fr.uha40.Entity.UserEntity;
import fr.uha40.Security.dto.JwtUserDto;
import org.springframework.stereotype.Component;

/**
 * DtoFactory
 * Package : fr.uha40.Dto
 * Created : 13/09/2016 16:18
 * Creator : Mathieu Geissler <mathieu.geissler@cgi.com>.
 */
@Component
public class DtoFactory {

    public JwtUserDto createUserDto(UserEntity userEntity) {
        if (userEntity != null) {
            JwtUserDto userDto = new JwtUserDto();
            userDto.setUsername(userEntity.getUsername());
            userDto.setId(userEntity.getId());
            userDto.setRole(userEntity.getRole());

            return userDto;
        } else {
            return null;
        }
    }

}