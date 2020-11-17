package com.example.study.service;

import com.example.study.interfaces.CrudInterface;
import com.example.study.model.entity.Item;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.ItemApiRequest;
import com.example.study.model.network.response.ItemApiResponse;
import com.example.study.repository.ItemRepository;
import com.example.study.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ItemApiLogicService implements CrudInterface<ItemApiRequest, ItemApiResponse> {

  @Autowired private PartnerRepository partnerRepository;
  @Autowired private ItemRepository itemRepository;

  @Override
  public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {
    ItemApiRequest itemApiRequest = request.getData();

    Item item =
        Item.builder()
            .status(itemApiRequest.getStatus())
            .name(itemApiRequest.getName())
            .title(itemApiRequest.getTitle())
            .price(itemApiRequest.getPrice())
            .brandName(itemApiRequest.getBrandName())
            .content(itemApiRequest.getContent())
            .registeredAt(LocalDateTime.now())
            .partner(partnerRepository.getOne(itemApiRequest.getPartnerId()))
            .build();

    return response(itemRepository.save(item));
  }

  @Override
  public Header<ItemApiResponse> read(Long id) {
    return null;
  }

  @Override
  public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {
    return null;
  }

  @Override
  public Header delete(Long id) {
    return null;
  }

  private Header<ItemApiResponse> response(Item item) {
    ItemApiResponse itemApiResponse =
        ItemApiResponse.builder()
            .id(item.getId())
            .name(item.getName())
            .status(item.getStatus())
            .title(item.getTitle())
            .content(item.getContent())
            .price(item.getPrice())
            .brandName(item.getBrandName())
            .registeredAt(item.getRegisteredAt())
            .unregisteredAt(item.getUnregisteredAt())
            .partnerId(item.getPartner().getId())
            .build();
    return Header.OK(itemApiResponse);
  }
}
