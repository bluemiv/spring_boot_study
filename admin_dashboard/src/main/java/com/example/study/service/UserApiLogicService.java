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
import java.util.Optional;

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
    return userRepository
        .findById(id)
        .map(user -> response(user))
        .orElseGet(() -> Header.ERROR("해당하는 사용자는 없습니다."));
  }

  @Override
  public Header<UserApiResponse> update(Header<UserApiRequest> request) {
    UserApiRequest userApiRequest = request.getData();

    Optional<User> optionalUser = userRepository.findById(userApiRequest.getId());
    return optionalUser
        .map(
            user -> {
              user.setAccount(userApiRequest.getAccount())
                  .setPassword(userApiRequest.getPassword())
                  .setPhoneNumber(userApiRequest.getPhoneNumber())
                  .setEmail(userApiRequest.getEmail())
                  .setStatus(userApiRequest.getStatus())
                  .setRegisteredAt(userApiRequest.getRegisteredAt())
                  .setUnregisteredAt(userApiRequest.getUnregisteredAt());
              return user;
            })
        .map(user -> userRepository.save(user))
        .map(updatedUser -> response(updatedUser))
        .orElseGet(() -> Header.ERROR("해당 사용자는 없습니다."));
  }

  @Override
  public Header delete(Long id) {
    Optional<User> optionalUser = userRepository.findById(id);
    return optionalUser
        .map(
            user -> {
              userRepository.delete(user);
              return Header.OK();
            })
        .orElseGet(() -> Header.ERROR("해당 사용자는 없습니다."));
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
