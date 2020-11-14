package com.example.study.interfaces;

import com.example.study.model.network.Header;

public interface CrudInterface<Request, Response> {

  public Header<Response> create(Header<Request> request);

  public Header<Response> read(Long id);

  public Header<Response> update(Header<Request> request);

  public Header delete(Long id);
}
