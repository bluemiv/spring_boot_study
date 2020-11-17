package com.example.study.controller.api;

import com.example.study.interfaces.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.ItemApiRequest;
import com.example.study.model.network.response.ItemApiResponse;
import com.example.study.service.ItemApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse> {

  @Autowired private ItemApiLogicService itemApiLogicService;

  @Override
  @PostMapping("")
  public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {
    log.info("Create item: {}", request.toString());
    return itemApiLogicService.create(request);
  }

  @Override
  @GetMapping("{id}")
  public Header<ItemApiResponse> read(@PathVariable(name = "id") Long id) {
    log.info("Read item id: {}", id);
    return itemApiLogicService.read(id);
  }

  @Override
  @PutMapping("")
  public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {
    log.info("Update item: {}", request.toString());
    return itemApiLogicService.update(request);
  }

  @Override
  @DeleteMapping("{id}")
  public Header delete(@PathVariable(name = "id") Long id) {
    log.info("Delete item id: {}", id);
    return itemApiLogicService.delete(id);
  }
}
