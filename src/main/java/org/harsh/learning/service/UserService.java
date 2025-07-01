package org.harsh.learning.service;

import lombok.RequiredArgsConstructor;
import org.harsh.learning.entity.ApplyEntity;
import org.harsh.learning.entity.LoginEntity;
import org.harsh.learning.entity.ModifyEntity;
import org.harsh.learning.entity.UserEntity;
import org.harsh.learning.model.ApplyResponse;
import org.harsh.learning.model.LoginResponse;
import org.harsh.learning.model.ModifyResponse;
import org.harsh.learning.model.UserResponse;
import org.harsh.learning.repository.ApplyRepository;
import org.harsh.learning.repository.LoginRepository;
import org.harsh.learning.repository.ModifyRepository;
import org.harsh.learning.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final LoginRepository loginRepository;
    private final ApplyRepository applyRepository;
    private final ModifyRepository modifyRepository;
    private final UserRepository userRepository;


    public LoginResponse login(int userId){
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setUserId(userId);
        LoginEntity savedLogin = loginRepository.save(loginEntity);
        LoginResponse loginResponse = new LoginResponse(loginEntity.getLoginId(), loginEntity.getUserId(), loginEntity.getLoginTime());

        return loginResponse;
    }

    public ApplyResponse apply(int userId) {
        ApplyEntity applyEntity = new ApplyEntity();
        applyEntity.setUserId(userId);
        ApplyEntity savedLogin = applyRepository.save(applyEntity);
        ApplyResponse applyResponse = new ApplyResponse(applyEntity.getApplyId(), applyEntity.getUserId(), applyEntity.getApplyTime());

        return applyResponse;
    }

    public ModifyResponse modify(int userId) {
        ModifyEntity modifyEntity = new ModifyEntity();
        modifyEntity.setUserId(userId);
        ModifyEntity savedLogin = modifyRepository.save(modifyEntity);
        ModifyResponse modifyResponse = new ModifyResponse(modifyEntity.getModifyId(), modifyEntity.getUserId(), modifyEntity.getModifyTime());

        return modifyResponse;
    }

    public void user(int userId, UserResponse userResponse) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();
            userEntity.setFirstName(userResponse.getFirstName());
            userEntity.setLastName(userResponse.getLastName());
            userEntity.setAge(userResponse.getAge());
            userEntity.setEmail(userResponse.getEmail());
            userEntity.setPhoneNumber(userResponse.getPhoneNumber());
            userEntity.setDateOfBirth(userResponse.getDateOfBirth());
            userEntity.setGender(userResponse.getGender());
            userEntity.setUserType(userResponse.getUserType());
            userRepository.save(userEntity);
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }
}
