package todo.mapper;

import todo.entity.UserEntity;
import todo.model.UserModel;

public class UserMapper {

    public static UserEntity mapToEntity (UserModel userModel){
        return UserEntity.builder()
                .login(userModel.getLogin())
                .password(userModel.getPassword())
                .email(userModel.getEmail())
                .build();
    }

    public static UserModel mapToModel (UserEntity userEntity){
        if(userEntity == null) {return null;}
        return UserModel.builder()
                .login(userEntity.getLogin())
                .password(userEntity.getPassword())
                .email(userEntity.getEmail())
                .build();
    }
}
