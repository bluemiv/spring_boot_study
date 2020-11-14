package com.example.study.service;

import com.example.study.interfaces.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

  @Autowired private UserRepository userRepository;

  @Override
  public Header<UserApiResponse> create(UserApiRequest userApiRequest) {
    return null;
  }

  @Override
  public Header<UserApiResponse> read(Long id) {
    return null;
  }

  @Override
  public Header<UserApiResponse> update(UserApiRequest userApiRequest) {
    return null;
  }

  @Override
  public Header delete(Long id) {
    return null;
  }
}
