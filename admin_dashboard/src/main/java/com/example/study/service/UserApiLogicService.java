package com.example.study.service;

import com.example.study.interfaces.CrudInterface;
import com.example.study.model.entity.User;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

  @Autowired private UserRepository userRepository;

  @Override
  public Header<UserApiResponse> create(Header<UserApiRequest> request) {
    UserApiRequest userApiRequest = request.getData();
    User user =
        User.builder()
            .account(userApiRequest.getAccount())
            .password(userApiRequest.getPassword())
            .email(userApiRequest.getEmail())
            .status("REGISTERED")
            .phoneNumber(userApiRequest.getPhoneNumber())
            .registeredAt(LocalDateTime.now())
            .build();
    User createdUser = userRepository.save(user);
    return response(createdUser);
  }

  @Override
  public Header<UserApiResponse> read(Long id) {
    return null;
  }

  @Override
  public Header<UserApiResponse> update(Header<UserApiRequest> userApiRequest) {
    return null;
  }

  @Override
  public Header delete(Long id) {
    return null;
  }

  private Header<UserApiResponse> response(User user) {
    UserApiResponse userApiResponse =
        UserApiResponse.builder()
            .id(user.getId())
            .account(user.getAccount())
            .password(user.getPassword())
            .email(user.getEmail())
            .status(user.getStatus())
            .phoneNumber(user.getPhoneNumber())
            .registeredAt(user.getRegisteredAt())
            .unregisteredAt(user.getUnregisteredAt())
            .build();
    return Header.OK(userApiResponse);
  }
}
