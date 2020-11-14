package com.example.study.interfaces;

import com.example.study.model.network.Header;

public interface CrudInterface<Request, Response> {

  public Header<Response> create(Request request);

  public Header<Response> read(Long id);

  public Header<Response> update(Request request);

  public Header delete(Long id);
}
